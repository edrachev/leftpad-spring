package leftpad.persistence;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PadderHistoryRepository extends Repository<PadderHistory, Long> {
	public List<PadderHistory> findAll();
	public PadderHistory save(PadderHistory item);
	public PadderHistory findById(Long id);
}