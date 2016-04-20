package leftpad.controllers;

import java.util.concurrent.CompletionStage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import leftpad.beans.LastPadded;
import leftpad.forms.PadderForm;
import leftpad.services.PadderHistoryService;
import leftpad.services.PadderService;

@Controller
public class ApplicationController {
	private final PadderService padderService;
	private final LastPadded lastPadded;
	private final PadderHistoryService padderHistoryService;

	@Autowired
	public ApplicationController(PadderService padderService, LastPadded lastPadded,
			PadderHistoryService padderHistoryService) {
		this.padderService = padderService;
		this.lastPadded = lastPadded;
		this.padderHistoryService = padderHistoryService;
	}

	@RequestMapping("")
	public String home(Model model) {
		PadderForm form = new PadderForm();
		form.setInput(lastPadded.getValue());
		model.addAttribute("padderForm", form);
		return "main";
	}

	@RequestMapping("/padding")
	public CompletionStage<String> doPadding(PadderForm form) {
		String input = form.getInput();
		lastPadded.setValue(input);
		return padderService.padAsync(form.getInput()).thenApply(output -> {
			form.setOutput(output);
			padderHistoryService.log(input, output);
			return "main";
		});
	}

	@RequestMapping("/history")
	public String history(Model model) {
		model.addAttribute("historyItems", padderHistoryService.findAll());
		return "history";
	}

	@RequestMapping("/history/{id}")
	public String historyItem(Model model, @PathVariable Long id) {
		model.addAttribute("historyItem", padderHistoryService.findById(id));
		return "historyItem";
	}
}
