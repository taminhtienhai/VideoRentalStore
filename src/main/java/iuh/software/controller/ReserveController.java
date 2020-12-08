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
import iuh.software.model.ReserveDetail;
import iuh.software.repository.ReserveDetailRepository;
import iuh.software.template.Response;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

	private final ReserveDetailRepository reserveRepo;
	
	public ReserveController(ReserveDetailRepository reserveRepo) {
		this.reserveRepo = reserveRepo;
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<Response> insert(@RequestBody ReserveDetail reserveDetail) {
	    this.reserveRepo.save(reserveDetail);
	    return CommonResponse.OK;
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
	    this.reserveRepo.deleteById(id);
	    return CommonResponse.OK;
	}

	@PostMapping(value = "/update/{id}")
	public ResponseEntity<Response> update(@PathVariable("id") Long id , @RequestBody ReserveDetail reserveDetail) {
		Optional<ReserveDetail> optionalReserve = reserveRepo.findById(id);
		if(optionalReserve.isPresent()) {
			ReserveDetail ReserveUpdate= optionalReserve.get();
			
			ReserveUpdate.setReserveDate(reserveDetail.getReserveDate());
			ReserveUpdate.setTitle(reserveDetail.getTitle());
			
			reserveRepo.save(ReserveUpdate);
			}else {
			System.out.println("Error Update");
		}
	    return CommonResponse.OK;
	}
		
}
