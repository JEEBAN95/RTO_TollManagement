package com.jk.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.commons.VhclRegNum;
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

	// save entity
	public VehicleOwnerDetlsEntity insertVehicleOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto) {

		VehicleOwnerDetlsEntity vhclOnrRegdEntity = null;
		vhclOnrRegdEntity = new VehicleOwnerDetlsEntity();
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdEntity);
		vhclOnrRegdEntity = vhclOnrRepo.save(vhclOnrRegdEntity);
		return vhclOnrRegdEntity;
	}// insertVehicleOwner()

	// save entity VehicleOwnerAdderssDetlsEnitity
	@Override
	public VehicleOwnerAdderssDetlsEnitity insertVehicleOnwerAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddRegDto, int ownerID) {

		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrRegdEntity = null;
		vhclOnrAddrRegdEntity = new VehicleOwnerAdderssDetlsEnitity();
		BeanUtils.copyProperties(vhclOnrAddRegDto, vhclOnrAddrRegdEntity);
		Optional<VehicleOwnerDetlsEntity> OptvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);

		if (OptvhclOnrRegdEntity.get() != null) {
			vhclOnrAddrRegdEntity.setOwner(OptvhclOnrRegdEntity.get());
			vhclOnrAddrRepo.save(vhclOnrAddrRegdEntity);
		} // if
		return vhclOnrAddrRegdEntity;
	}// insertVehicleOnwerAddr()

	// save entity VehicleRegdDetlsEntity
	// create custom vehicle registration number
	@Override
	public VehicleRegdDetlsEntity insertVehicleRegDetails(VehicleRegdDetlsDTO vhclRegdDto, int ownerID) {

		VehicleRegdDetlsEntity vhclRegdDtlsEntity = null;
		vhclRegdDtlsEntity = new VehicleRegdDetlsEntity();
		BeanUtils.copyProperties(vhclRegdDto, vhclRegdDtlsEntity);
		String vehiceRegdNum = "VRCTF" + VhclRegNum.getFirstGeneratedNum() + "RCVU"
				+ VhclRegNum.getSecondGeneratedNum();
		Optional<VehicleOwnerDetlsEntity> OptvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);
		vhclRegdDtlsEntity.setVehiceRegdNum(vehiceRegdNum);

		if (OptvhclOnrRegdEntity.isPresent()) {
			vhclRegdDtlsEntity.setOwner(OptvhclOnrRegdEntity.get());
			vhclRegdDtlsRepo.save(vhclRegdDtlsEntity);
		} // if
		return vhclRegdDtlsEntity;
	}// insertVehicleRegDetails()

	// save entity VehicleDetlsEntity
	@Override
	public VehicleDetlsEntity insertVehicleDetails(VehicleDetlsDTO vhclDtlsDto, int ownerID) {

		VehicleDetlsEntity vhclDtlsEntity = new VehicleDetlsEntity();
		BeanUtils.copyProperties(vhclDtlsDto, vhclDtlsEntity);
		Optional<VehicleOwnerDetlsEntity> OptvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);

		if (OptvhclOnrRegdEntity.isPresent()) {
			vhclDtlsEntity.setOwner(OptvhclOnrRegdEntity.get());
			vhclDtlsRepo.save(vhclDtlsEntity);
		} // if
		return vhclDtlsEntity;
	}// insertVehicleDetails

	@Override
	public VehicleOwnerDetlsEntity getOwnerByID(int ownerID) {
		return vhclOnrRepo.findByPid(ownerID);
	}// getOwnerByID()

	@Override
	public VehicleDetlsEntity getVehicleDtlsBy(int ownerID) {
		return vhclDtlsRepo.findByOwnerIdFk(ownerID);
	}// getVehicleDtlsBy()

	@Override
	public VehicleOwnerAdderssDetlsEnitity getVehicleOnrAddrDtlsBy(int ownerID) {
		return vhclOnrAddrRepo.findByOwnerIdFk(ownerID);
	}// getVehicleOnrAddrDtlsBy()

	@Override
	public VehicleRegdDetlsEntity getVehicleRegdDtlsBy(int ownerID) {
		return vhclRegdDtlsRepo.findByOwnerIdFk(ownerID);
	}// getVehicleRegdDtlsBy()

	// update VehicleOwnerDetlsEntity
	@Override
	public  VehicleOwnerDetlsEntity  updateOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto, int ownerID) {
		VehicleOwnerDetlsEntity vhclOnrRegdEntity = vhclOnrRepo.findByPid(ownerID);
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdEntity);
		return vhclOnrRepo.save(vhclOnrRegdEntity);
	}// updateOwner()

	// update VehicleOwnerAdderssDetlsEnitity
	@Override
	public VehicleOwnerAdderssDetlsEnitity updateVhclOnrAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO, int id) {

		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtlsEntity = vhclOnrAddrRepo.findByOwnerIdFk(id);
		BeanUtils.copyProperties(vhclOnrAddrRegdDTO, vhclOnrAddrDtlsEntity);
		Optional<VehicleOwnerDetlsEntity> optvhclOnrRegdEntity = vhclOnrRepo.findById(id);

		if (optvhclOnrRegdEntity.isPresent()) {
			vhclOnrAddrDtlsEntity.setOwner(optvhclOnrRegdEntity.get());
			vhclOnrAddrRepo.save(vhclOnrAddrDtlsEntity);
		} // if
		return vhclOnrAddrDtlsEntity;
	}// updateVhclOnrAddr()

	// update VehicleDetlsEntity
	@Override
	public VehicleDetlsEntity updateVhclDtls(VehicleDetlsDTO vhclDtlsDto, int ownerID) {

		VehicleDetlsEntity vhclDtlsEntity = vhclDtlsRepo.findByOwnerIdFk(ownerID);
		Optional<VehicleOwnerDetlsEntity> optvhclOnrRegdEntity = vhclOnrRepo.findById(ownerID);

		if (optvhclOnrRegdEntity.isPresent()) {
			BeanUtils.copyProperties(vhclDtlsDto, vhclDtlsEntity);
			vhclDtlsEntity.setOwner(optvhclOnrRegdEntity.get());
			vhclDtlsRepo.save(vhclDtlsEntity);
		} // if
		return vhclDtlsEntity;
	}// updateVhclDtls()

	// update VehicleRegdDetlsEntity
	@Override
	public VehicleRegdDetlsEntity updateVhclRegdDtls(VehicleRegdDetlsDTO vhclRegdDto, int ownerID) {

		VehicleRegdDetlsEntity vhclRegdDtlsEntity = null;
		vhclRegdDtlsEntity = vhclRegdDtlsRepo.findByOwnerIdFk(ownerID);
		VehicleOwnerDetlsEntity vhclOnrDtlsEntity = vhclRegdDtlsEntity.getOwner();
		BeanUtils.copyProperties(vhclRegdDto, vhclRegdDtlsEntity);
		vhclRegdDtlsEntity.setOwner(vhclOnrDtlsEntity);
		return vhclRegdDtlsRepo.save(vhclRegdDtlsEntity);
	}// updateVhclRegdDtls()

	@Override
	public VehicleRegdDetlsEntity getVehicleRegdDtlsByVhclID(int vhclId) {
		return vhclRegdDtlsRepo.findByRegdId(vhclId);
	}// getVehicleRegdDtlsByVhclID
}// class
