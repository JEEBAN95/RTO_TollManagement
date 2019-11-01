package com.jk.restApi;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jk.dto.VehicleDetlsDTO;
import com.jk.dto.VehicleOwnerAddressDetlsDTO;
import com.jk.dto.VehicleOwnerDetlsDTO;
import com.jk.dto.VehicleRegdDetlsDTO;
import com.jk.entity.VehicleDetlsEntity;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.entity.VehicleOwnerDetlsEntity;
import com.jk.entity.VehicleRegdDetlsEntity;
import com.jk.repository.VehicleDetailsRepository;
import com.jk.repository.VehicleOwnerAddrRegdRepository;
import com.jk.repository.VehicleOwnerRegdRepository;
import com.jk.repository.VehicleRegDetlsRepository;

@RestController
public class VehicleDtlsOwnerDtlsRestApi {

	@Autowired
	private VehicleDetailsRepository vhclDtlsRepo;
	@Autowired
	private VehicleOwnerAddrRegdRepository vhclOnrAddrRegdRepo;
	@Autowired
	private VehicleOwnerRegdRepository vhclOnrRegdRepo;
	@Autowired
	private VehicleRegDetlsRepository vhclRegdDtlsRepo;

	@GetMapping(value = "/vhclDtlsOnrdtls", produces = { "application/json"})
	public VehicleDetailsOwnerDetails getAllDetails(@RequestParam("ownerID") int id) {

		VehicleDetailsOwnerDetails vhDtOnDt = new VehicleDetailsOwnerDetails();

		// call repository methods
		// VehicleOwnerAdderssDetlsEnitity
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtlsEntity = null;
		VehicleOwnerAddressDetlsDTO vhclOnrAddrDtlsDTO = null;
		vhclOnrAddrDtlsEntity = vhclOnrAddrRegdRepo.findByOwnerIdFk(id);
		vhclOnrAddrDtlsDTO = new VehicleOwnerAddressDetlsDTO();
		// copy entity class to dto class
		BeanUtils.copyProperties(vhclOnrAddrDtlsEntity, vhclOnrAddrDtlsDTO);
		
		// VehicleDetlsEntity
		VehicleDetlsEntity vhclDtlsEntity = null;
		VehicleDetlsDTO vhclDtlsDTO = null;
		vhclDtlsEntity = vhclDtlsRepo.findByOwnerIdFk(id);
		vhclDtlsDTO = new VehicleDetlsDTO();
		// copy entity class to dto class
		BeanUtils.copyProperties(vhclDtlsEntity, vhclDtlsDTO);
		
		// VehicleOwnerDetlsEntity
		Optional<VehicleOwnerDetlsEntity> optvhclOnrDtlsEntity = null;
		VehicleOwnerDetlsDTO vhclOnrDtlsDTO = null;
		optvhclOnrDtlsEntity = vhclOnrRegdRepo.findById(id);
		if (optvhclOnrDtlsEntity.isPresent()) {
			vhclOnrDtlsDTO = new VehicleOwnerDetlsDTO();
			// copy entity class to dto class
			BeanUtils.copyProperties(optvhclOnrDtlsEntity.get(), vhclOnrDtlsDTO);
		}//if
		
		VehicleRegdDetlsEntity vhclRegdDtlsEntity = null;
		VehicleRegdDetlsDTO vhclRegdDtlsDTO = null;
		vhclRegdDtlsEntity = vhclRegdDtlsRepo.findByOwnerIdFk(id);
		vhclRegdDtlsDTO = new VehicleRegdDetlsDTO();
		// copy entity class to dto class
		BeanUtils.copyProperties(vhclRegdDtlsEntity, vhclRegdDtlsDTO);
		// set all dto class to VehicleDetailsOwnerDetails
		vhDtOnDt.setVhclDto(vhclDtlsDTO);
		vhDtOnDt.setVhclOnrAddrDtlsDto(vhclOnrAddrDtlsDTO);
		vhDtOnDt.setVhclOnrDtlsDto(vhclOnrDtlsDTO);
		vhDtOnDt.setVhclRegdDtlsDto(vhclRegdDtlsDTO);
		return vhDtOnDt;
	}// getAllDetails()
}//class
