package iuh.software.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.software.model.Record;
import iuh.software.model.RecordStatus;
import iuh.software.repository.RecordRepository;
import iuh.software.repository.RecordStatusRepository;
import iuh.software.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;

	@Autowired
	private RecordStatusRepository recordStatusRepository;

	@Override
	public boolean insertRecord(String name, String imageUrl, String description, int idStatus) {
		// TODO Auto-generated method stub
		
		Record record = new Record();
		RecordStatus status = recordStatusRepository.findById(idStatus).get();
		
		record.setName(name);
		record.setImageUrl(imageUrl);
		record.setDescription(description);
		record.setRecordStatus(status);

		recordRepository.save(record);
		return true;
	}

}
