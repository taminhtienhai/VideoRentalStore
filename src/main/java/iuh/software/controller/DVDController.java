package iuh.software.controller;

import iuh.software.common.CommonResponse;
import iuh.software.model.DVD;
import iuh.software.repository.DVDRepository;
import iuh.software.template.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {

        this.dvdRepo.deleteById(id);
        return CommonResponse.OK;
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Response> update(@PathVariable("id") Long id, @RequestBody DVD dvd) {
        Optional<DVD> optionalDVD = dvdRepo.findById(id);
        if (optionalDVD.isPresent()) {
            DVD DVDUpdate = optionalDVD.get();

            DVDUpdate.setCreateDate(dvd.getCreateDate());
            DVDUpdate.setTitle(dvd.getTitle());

            dvdRepo.save(DVDUpdate);
        } else {
            System.out.println("Error Update");
        }
        return CommonResponse.OK;
    }

}
