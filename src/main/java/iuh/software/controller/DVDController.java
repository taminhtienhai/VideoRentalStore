package iuh.software.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.software.common.CommonResponse;
import iuh.software.model.DVD;
import iuh.software.model.Title;
import iuh.software.repository.DVDRepository;
import iuh.software.template.Response;

@RestController
@RequestMapping("/dvd")
public class DVDController {
private final DVDRepository dvdRepo;

public DVDController(DVDRepository dvdRepo) {
	this.dvdRepo= dvdRepo;
}
@PostMapping(value = "/insert")
public ResponseEntity<Response> insert(@RequestBody DVD dvd) {
    this.dvdRepo.save(dvd);
    return CommonResponse.OK;
}

@GetMapping(value = "/delete/{id}")
public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
    this.dvdRepo.deleteById(id);
    return ResponseEntity.ok(true);
}

@PostMapping(value = "/update/{id}")
public ResponseEntity<Response> update(@PathVariable("id") Long id , @RequestBody DVD dvd) {
	Optional<DVD> optionalDVD = dvdRepo.findById(id);
	if(optionalDVD.isPresent()) {
		DVD DVDUpdate= optionalDVD.get();
		
		DVDUpdate.setCreateDate(dvd.getCreateDate());
		DVDUpdate.setTitle(dvd.getTitle());
		}else {
		System.out.println("Error Update");
	}
    return CommonResponse.OK;
}
	
}
