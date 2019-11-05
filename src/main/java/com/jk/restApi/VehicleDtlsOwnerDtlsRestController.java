package com.jk.restApi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jk.entity.VehicleDetlsEntity;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.entity.VehicleOwnerDetlsEntity;
import com.jk.entity.VehicleRegdDetlsEntity;
import com.jk.exception.CustomeExceptionHandler;
import com.jk.repository.VehicleDetailsRepository;
import com.jk.repository.VehicleOwnerAddrRegdRepository;
import com.jk.repository.VehicleOwnerRegdRepository;
import com.jk.repository.VehicleRegDetlsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class VehicleDtlsOwnerDtlsRestController {

	@Autowired
	private VehicleDetailsRepository vhclDtlsRepo;
	@Autowired
	private VehicleOwnerAddrRegdRepository vhclOnrAddrRegdRepo;
	@Autowired
	private VehicleOwnerRegdRepository vhclOnrRegdRepo;
	@Autowired
	private VehicleRegDetlsRepository vhclRegdDtlsRepo;

	@GetMapping(value = "/getDetails", produces = { "application/json" })
	@ApiOperation(value = "RestApi", response = VehicleDetailsOwnerDetails.class)

	// call repository methods
	// configure all entity
	public VehicleDetailsOwnerDetails getAllDetails(@RequestParam("ownerID") int id) throws CustomeExceptionHandler {

		VehicleDetailsOwnerDetails vhDtOnDt = new VehicleDetailsOwnerDetails();

		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtlsEntity = null;
		VehicleRegdDetlsEntity vhclRegdDtlsEntity = null;
		VehicleDetlsEntity vhclDtlsEntity = null;
		VehicleOwnerDetlsEntity vhclOnrDtlsEntity = null;
		Optional<VehicleOwnerDetlsEntity> optvhclOnrDtlsEntity = null;

			vhclOnrAddrDtlsEntity = vhclOnrAddrRegdRepo.findByOwnerIdFk(id);
			vhclDtlsEntity = vhclDtlsRepo.findByOwnerIdFk(id);
			vhclRegdDtlsEntity = vhclRegdDtlsRepo.findByOwnerIdFk(id);
			
			if(vhclDtlsEntity==null && vhclOnrAddrDtlsEntity==null && vhclRegdDtlsEntity==null ) {
				throw new CustomeExceptionHandler();
			}
			optvhclOnrDtlsEntity = vhclOnrRegdRepo.findById(id);
			if (optvhclOnrDtlsEntity.isPresent()) {
				vhclOnrDtlsEntity = optvhclOnrDtlsEntity.get();
			} // if
		
		vhDtOnDt.setVhclDtlsEntity(vhclDtlsEntity);
		vhDtOnDt.setVhclOnrAddrDtlsEntity(vhclOnrAddrDtlsEntity);
		vhDtOnDt.setVhclOnrDtlsEntity(vhclOnrDtlsEntity);
		vhDtOnDt.setVhclRegdDtlsEntity(vhclRegdDtlsEntity);

		return vhDtOnDt;
	}// getAllDetails()
}// class
