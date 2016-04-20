package leftpad.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PadderHistory {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String input;

	@Column
	private String output;

	public PadderHistory() {
	}

	public PadderHistory(String input, String output) {
		this.input = input;
		this.output = output;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "PadderHistory [id=" + id + ", input=" + input + ", output=" + output + "]";
	}

}