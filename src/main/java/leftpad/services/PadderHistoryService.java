package leftpad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leftpad.persistence.PadderHistory;
import leftpad.persistence.PadderHistoryRepository;

@Service
public class PadderHistoryService {

	private final PadderHistoryRepository repository;

	@Autowired
	public PadderHistoryService(PadderHistoryRepository repository) {
		super();
		this.repository = repository;
	}

	public void log(String input, String output) {
		PadderHistory item = new PadderHistory(input, output);
		repository.save(item);
	}

	public List<PadderHistory> findAll() {
		return repository.findAll();
	}

	public PadderHistory findById(Long id) {
		return repository.findById(id);
	}
}
