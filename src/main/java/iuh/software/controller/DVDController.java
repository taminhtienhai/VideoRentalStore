package iuh.software.controller;

import iuh.software.common.CommonResponse;
import iuh.software.model.DVD;
import iuh.software.repository.DVDRepository;
import iuh.software.template.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dvd")
public class DVDController {

    private final DVDRepository dvdRepo;

    public DVDController(DVDRepository dvdRepo) {
        this.dvdRepo = dvdRepo;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Response> insert(@RequestBody DVD dvd) {
        this.dvdRepo.save(dvd);
        return CommonResponse.OK;
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") UUID id) {
        this.dvdRepo.deleteById(id);
        return CommonResponse.OK;
    }

    @GetMapping(value = "/update")
    public ResponseEntity<Response> update(@PathVariable("id") DVD dvd) {
        this.dvdRepo.saveAndFlush(dvd);
        return CommonResponse.OK;
    }
}