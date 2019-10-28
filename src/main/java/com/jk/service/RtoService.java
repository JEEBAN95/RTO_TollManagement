package com.jk.service;

import java.util.List;

import com.jk.dto.VehicleDetlsDTO;
import com.jk.dto.VehicleOwnerAddressDetlsDTO;
import com.jk.dto.VehicleOwnerDetlsDTO;
import com.jk.dto.VehicleRegdDetlsDTO;
import com.jk.entity.VehicleDetlsEntity;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.entity.VehicleOwnerDetlsEntity;
import com.jk.entity.VehicleRegdDetlsEntity;

public interface RtoService {

	public int insertVehicleOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto);

	public void insertVehicleOnwerAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddRegDto, int ownerID);

	public void insertVehicleRegDetails(VehicleRegdDetlsDTO vhclRegdDto, int ownerID);

	void insertVehicleDetails(VehicleDetlsDTO vhclDtlsDto, int ownerID);

	public VehicleOwnerDetlsEntity getOwnerByID(int ownerID);

	public VehicleDetlsEntity getVehicleDtlsBy(int ownerID);

	public VehicleOwnerAdderssDetlsEnitity getVehicleOnrAddrDtlsBy(int ownerID);

	public VehicleRegdDetlsEntity getVehicleRegdDtlsBy(int ownerID);

	public void updateOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto, int ownerID);

	public void updateVhclOnrAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO, int ownerID);

	public void updateVhclDtls(VehicleDetlsDTO vhclDtlsDto, int ownerID);

	public void updateVhclRegdDtls(VehicleRegdDetlsDTO vhclRegdDto, int ownerID); 
	
	public List<Integer> getAllOwnersIDs();
	
	public List<String>getAllOwnersNames();
}
