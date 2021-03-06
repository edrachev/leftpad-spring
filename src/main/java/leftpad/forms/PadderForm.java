package leftpad.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PadderForm {
    	@NotNull
	@NotEmpty
	private String input;
	private String output;
	
	public PadderForm() {
	}
	
	public PadderForm(String input, String output) {
		this.input = input;
		this.output = output;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
}
