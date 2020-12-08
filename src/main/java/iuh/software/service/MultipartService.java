package iuh.software.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface MultipartService {
    Optional<String> store(MultipartFile file);
}
