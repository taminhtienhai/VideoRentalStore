package iuh.software.controller;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.software.common.CommonResponse;
import iuh.software.model.RentalInfo;
import iuh.software.repository.RentalInfoRepository;
import iuh.software.template.Response;

@RestController
@RequestMapping("/rentalInfo")
public class RentalInfoController {

	private final RentalInfoRepository rentalInfoRepo;
	public RentalInfoController(RentalInfoRepository rentalInfoRepo) {
		this.rentalInfoRepo= rentalInfoRepo;
	}
	@PostMapping(value = "/insert")
	public ResponseEntity<Response> insert(@RequestBody RentalInfo rentalInfo){
		this.rentalInfoRepo.save(rentalInfo);
		
		return CommonResponse.OK;
	}
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
	    this.rentalInfoRepo.deleteById(id);
	    return CommonResponse.OK;
	}

	@PostMapping(value = "/update/{id}")
	public ResponseEntity<Response> update(@PathVariable("id") Long id , @RequestBody RentalInfo rentalInfo) {
		Optional<RentalInfo> optionalRentalInfo = rentalInfoRepo.findById(id);
		if(optionalRentalInfo.isPresent()) {
			RentalInfo RentalUpdate= optionalRentalInfo.get();
			
			RentalUpdate.setReturnDate(LocalDateTime.now());
	
			rentalInfoRepo.save(RentalUpdate);
			}else {
			System.out.println("Error Update");
		}
	    return CommonResponse.OK;
	}
}
