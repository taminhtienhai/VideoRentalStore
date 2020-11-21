package iuh.software.service;

import java.time.LocalDateTime;

import iuh.software.model.DVD;
import iuh.software.model.DVD.DVDStatus;

public interface DVDService {
	DVD insertDvD(LocalDateTime createDate, DVDStatus status, int idRecord);
}
