package iuh.software.controller;

import iuh.software.common.CommonResponse;
import iuh.software.model.Title;
import iuh.software.repository.TitleRepository;
import iuh.software.template.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/title")
public class TitleController {

    private final TitleRepository titleRepo;

    public TitleController(TitleRepository titleRepo) {
        this.titleRepo = titleRepo;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Response> insert(@RequestBody Title dvd) {
        this.titleRepo.save(dvd);
        return CommonResponse.OK;
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        this.titleRepo.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping(value = "/update")
    public ResponseEntity<Response> update(@PathVariable("id") Title dvd) {
        return CommonResponse.OK;
    }
}
