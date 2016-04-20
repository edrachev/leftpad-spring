package leftpad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import leftpad.beans.LastPadded;
import leftpad.forms.PadderForm;
import leftpad.services.PadderService;


@Controller
public class ApplicationController {
    private final PadderService padderService;
    private final LastPadded lastPadded;
    
    @Autowired
    public ApplicationController(PadderService padderService, LastPadded lastPadded) {
	this.padderService = padderService;
	this.lastPadded = lastPadded;
    }

    @RequestMapping("")
    public String home(Model model) {
	PadderForm form = new PadderForm();
	form.setInput(lastPadded.getValue());
	model.addAttribute("padderForm", form);
	return "main";
    }
    
    @RequestMapping("/padding")
    public String doPadding(PadderForm form) {
	String input = form.getInput();
	lastPadded.setValue(input);
	form.setOutput(padderService.pad(input));
	return "main";
    }
}
