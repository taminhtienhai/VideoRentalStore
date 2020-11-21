package iuh.software.service.impl;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.software.model.DVD;
import iuh.software.model.DVD.DVDStatus;
import iuh.software.model.Record;
import iuh.software.repository.DVDRepository;
import iuh.software.repository.RecordRepository;
import iuh.software.service.DVDService;
import lombok.NonNull;

@Service
public class DvDServiceImpl implements DVDService{

	@Autowired
	private DVDRepository dvdRepository;
	
	@Autowired
	private RecordRepository recordRepository;

	@Override
	public DVD insertDvD(LocalDateTime createDate, DVDStatus status, int idRecord) {
		// TODO Auto-generated method stub
		
		DVD dvd= new DVD();
		Record title= recordRepository.findRecordById(idRecord);
		
		dvd.setCreateDate(createDate);
		dvd.setStatus(status);
		dvd.setRecords((@NonNull Set<Record>) title);
		
		dvdRepository.save(dvd);
		return dvd;
	}
	


}
