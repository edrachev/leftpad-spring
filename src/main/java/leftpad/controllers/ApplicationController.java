package leftpad.controllers;

import java.util.concurrent.CompletionStage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import leftpad.forms.PadderForm;
import leftpad.services.PadderService;

@Controller
public class ApplicationController {
	private final PadderService padderService;

	@Autowired
	public ApplicationController(PadderService padderService) {
		this.padderService = padderService;
	}

	@RequestMapping("")
	public String home(Model model) {
		PadderForm form = new PadderForm();
		model.addAttribute("padderForm", form);
		return "main";
	}

	@RequestMapping("/padding")
	public CompletionStage<String> doPadding(PadderForm form) {
		String input = form.getInput();
		return padderService.padAsync(input).thenApply(output -> {
			form.setOutput(output);
			return "main";
		});
	}
}
