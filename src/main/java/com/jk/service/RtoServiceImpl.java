package com.jk.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class RtoServiceImpl implements RtoService {

	@Autowired
	private VehicleOwnerRegdRepository vhclOnrRepo;
	@Autowired
	private VehicleOwnerAddrRegdRepository vhclOnrAddrRepo;
	@Autowired
	private VehicleRegDetlsRepository vhclRegdDtlsRepo;
	@Autowired
	private VehicleDetailsRepository vhclDtlsRepo;

	@Override
	public int insertVehicleOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto) {
		
		VehicleOwnerDetlsEntity vhclOnrRegdEntity = null;
		vhclOnrRegdEntity = new VehicleOwnerDetlsEntity();
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdEntity);
		
		// save entity
		vhclOnrRegdEntity = vhclOnrRepo.save(vhclOnrRegdEntity);
		// get id value of Owner
		return vhclOnrRegdEntity.getPid();
	}

	@Override
	public void insertVehicleOnwerAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddRegDto, int ownerID) {
		
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrRegdEntity = null;
		vhclOnrAddrRegdEntity = new VehicleOwnerAdderssDetlsEnitity();	
		BeanUtils.copyProperties(vhclOnrAddRegDto, vhclOnrAddrRegdEntity);
		
		Optional<VehicleOwnerDetlsEntity> OptvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);
		if (OptvhclOnrRegdEntity.get() != null) {
			vhclOnrAddrRegdEntity.setOwner(OptvhclOnrRegdEntity.get());
			// save entity
			vhclOnrAddrRepo.save(vhclOnrAddrRegdEntity);
		} // if
	}// insertVehicleOnwerAddr

	@Override
	public void insertVehicleRegDetails(VehicleRegdDetlsDTO vhclRegdDto, int ownerID) {

		VehicleRegdDetlsEntity vhclRegdDtlsEntity = null;
		vhclRegdDtlsEntity = new VehicleRegdDetlsEntity();
		
		//costume Id generator
		Random rndmNo1,rndmNo2 ;
		rndmNo1= new Random();
		rndmNo2 = new Random();
		String vehiceRegdNum = "VRCTF"+rndmNo1.nextInt()+"RCVU"+rndmNo2.nextInt();
		vhclRegdDtlsEntity.setVehiceRegdNum(vehiceRegdNum);
		
		BeanUtils.copyProperties(vhclRegdDto, vhclRegdDtlsEntity);
		
		Optional<VehicleOwnerDetlsEntity> OptvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);
		if (OptvhclOnrRegdEntity.get() != null) {
			vhclRegdDtlsEntity.setOwner(OptvhclOnrRegdEntity.get());
			// save entity
			vhclRegdDtlsRepo.save(vhclRegdDtlsEntity);
		} // if
	}// insertVehicleRegDetails

	@Override
	public void insertVehicleDetails(VehicleDetlsDTO vhclDtlsDto, int ownerID) {
		VehicleDetlsEntity vhclDtlsEntity = new VehicleDetlsEntity();
		
		BeanUtils.copyProperties(vhclDtlsDto, vhclDtlsEntity);
		Optional<VehicleOwnerDetlsEntity> OptvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);
		if (OptvhclOnrRegdEntity.get() != null) {
			vhclDtlsEntity.setOwner(OptvhclOnrRegdEntity.get());
			// save entity
			vhclDtlsRepo.save(vhclDtlsEntity);
		} // if
	}// insertVehicleDetails

	@Override
	public VehicleOwnerDetlsEntity getOwnerByID(int ownerID) {
		return vhclOnrRepo.findByPid(ownerID);
	}

	@Override
	public VehicleDetlsEntity getVehicleDtlsBy(int ownerID) {
		return vhclDtlsRepo.findByOwnerIdFk(ownerID);
	}

	@Override
	public VehicleOwnerAdderssDetlsEnitity getVehicleOnrAddrDtlsBy(int ownerID) {
		return vhclOnrAddrRepo.findByOwnerIdFk(ownerID);
	}

	@Override
	public VehicleRegdDetlsEntity getVehicleRegdDtlsBy(int ownerID) {
		return vhclRegdDtlsRepo.findByOwnerIdFk(ownerID);
	}

	@Override
	public void updateOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto, int ownerID) {
	
		VehicleOwnerDetlsEntity  vhclOnrRegdEntity= vhclOnrRepo.findByPid(ownerID);
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdEntity);
		vhclOnrRepo.save(vhclOnrRegdEntity);
	}//updateOwner

	@Override
	public void updateVhclOnrAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO, int id) {
		
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtlsEntity=vhclOnrAddrRepo.findByOwnerIdFk(id);
		BeanUtils.copyProperties(vhclOnrAddrRegdDTO,vhclOnrAddrDtlsEntity);
		
		Optional<VehicleOwnerDetlsEntity> optvhclOnrRegdEntity = vhclOnrRepo.findById(id);
		if (optvhclOnrRegdEntity.get() != null) {
			vhclOnrAddrDtlsEntity.setOwner(optvhclOnrRegdEntity.get());
			// save entity
			vhclOnrAddrRepo.save(vhclOnrAddrDtlsEntity);
		} // if
	}//updateVhclOnrAddr

	@Override
	public void updateVhclDtls(VehicleDetlsDTO vhclDtlsDto, int ownerID) {
		
		VehicleDetlsEntity vhclDtlsEntity = vhclDtlsRepo.findByOwnerIdFk(ownerID);
		BeanUtils.copyProperties(vhclDtlsDto, vhclDtlsEntity);
		Optional<VehicleOwnerDetlsEntity> optvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);
		if(optvhclOnrRegdEntity.isPresent()) {
			vhclDtlsEntity.setOwner(optvhclOnrRegdEntity.get());
			// save entity
			vhclDtlsRepo.save(vhclDtlsEntity);
		}//updateVhclDtls
	}

	@Override
	public void updateVhclRegdDtls(VehicleRegdDetlsDTO vhclRegdDto, int ownerID) {
		
		VehicleRegdDetlsEntity vhclRegdDtlsEntity = null;
		vhclRegdDtlsEntity = vhclRegdDtlsRepo.findByOwnerIdFk(ownerID);
		VehicleOwnerDetlsEntity vhclOnrDtlsEntity= vhclRegdDtlsEntity.getOwner();
		BeanUtils.copyProperties(vhclRegdDto, vhclRegdDtlsEntity);
		vhclRegdDtlsEntity.setOwner(vhclOnrDtlsEntity);
		vhclRegdDtlsRepo.save(vhclRegdDtlsEntity);
	}

	@Override
	public List<Integer> getAllOwnersIDs() {
		return vhclOnrRepo.getAllVehicleOwnerID();
	}

	@Override
	public List<String> getAllOwnersNames() {
		return vhclOnrRepo.getAllVehicleOwnerName();
	}

	@Override
	public VehicleRegdDetlsEntity getVehicleRegdDtlsByVhclID(int vhclId) {
		return vhclRegdDtlsRepo.findByRegdId(vhclId);
	}
}
