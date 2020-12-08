package iuh.software.service.impl;

import iuh.software.service.MultipartService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class MultipartServiceImpl implements MultipartService {

    @Override
    public Optional<String> store(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        try {
            File newFile = new File("/src/main/resources/images/" + uuid + ".png");
            newFile.mkdir();
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(uuid);
    }
}
