package iuh.software.controller;

import java.util.List;
import java.util.Optional;

import iuh.software.service.MultipartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.software.common.CommonResponse;
import iuh.software.model.Title;
import iuh.software.repository.TitleRepository;
import iuh.software.template.Response;

@RestController
@RequestMapping("/title")
public class TitleController {

	private final TitleRepository titleRepo;
	private final MultipartService multipartSer;

	public TitleController(TitleRepository titleRepo, MultipartService multipartSer) {
		this.titleRepo = titleRepo;
		this.multipartSer = multipartSer;
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Title> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.titleRepo.findById(id).orElse(null));
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Title>> findAllTitle() {
		List<Title> titles = this.titleRepo.findAll();
		return ResponseEntity.ok(titles);
	}

	@PostMapping(value = "/insert")
	public ResponseEntity<Response> insert(@RequestBody Title title) {
		this.titleRepo.save(title);
		return CommonResponse.OK;
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		this.titleRepo.deleteById(id);
		return ResponseEntity.ok(true);
	}

	@PostMapping(value = "/update/{id}")
	public ResponseEntity<Response> update(@PathVariable("id") Long id, @RequestBody Title title) {
		Optional<Title> optionalTitle = titleRepo.findById(id);
		if (optionalTitle.isPresent()) {
			Title titleUpdate = optionalTitle.get();

			titleUpdate.setName(title.getName());
			titleUpdate.setImageUrl(title.getImageUrl());
			titleUpdate.setDescription(title.getDescription());
		titleUpdate.setTitleStatus(title.getTitleStatus());

			titleRepo.save(titleUpdate);	
		} else {
			System.out.println("Error Update");
		}
		return CommonResponse.OK;
	}
}
