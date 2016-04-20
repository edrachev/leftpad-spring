package leftpad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import leftpad.forms.PadderForm;

@Controller
public class ApplicationController {
	@RequestMapping("")
	public String home(Model model) {
		PadderForm form = new PadderForm();
		model.addAttribute("padderForm", form);
		return "main";
	}

	@RequestMapping("/padding")
	public String doPadding(PadderForm form) {
		form.setOutput("Ooops!");
		return "main";
	}
}
