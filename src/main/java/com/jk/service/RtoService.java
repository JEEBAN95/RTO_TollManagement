package com.jk.service;


import com.jk.dto.VehicleDetlsDTO;
import com.jk.dto.VehicleOwnerAddressDetlsDTO;
import com.jk.dto.VehicleOwnerDetlsDTO;
import com.jk.dto.VehicleRegdDetlsDTO;
import com.jk.entity.VehicleDetlsEntity;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.entity.VehicleOwnerDetlsEntity;
import com.jk.entity.VehicleRegdDetlsEntity;

public interface RtoService {

	public VehicleOwnerDetlsEntity insertVehicleOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto);

	public VehicleOwnerAdderssDetlsEnitity insertVehicleOnwerAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddRegDto, int ownerID);

	public VehicleRegdDetlsEntity insertVehicleRegDetails(VehicleRegdDetlsDTO vhclRegdDto, int ownerID);

	VehicleDetlsEntity insertVehicleDetails(VehicleDetlsDTO vhclDtlsDto, int ownerID);

	public VehicleOwnerDetlsEntity getOwnerByID(int ownerID);

	public VehicleDetlsEntity getVehicleDtlsBy(int ownerID);

	public VehicleOwnerAdderssDetlsEnitity getVehicleOnrAddrDtlsBy(int ownerID);

	public VehicleRegdDetlsEntity getVehicleRegdDtlsBy(int ownerID);

	public VehicleOwnerDetlsEntity updateOwner(VehicleOwnerDetlsDTO vhclOnrRegdDto, int ownerID);

	public VehicleOwnerAdderssDetlsEnitity updateVhclOnrAddr(VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO, int ownerID);

	public VehicleDetlsEntity updateVhclDtls(VehicleDetlsDTO vhclDtlsDto, int ownerID);

	public VehicleRegdDetlsEntity updateVhclRegdDtls(VehicleRegdDetlsDTO vhclRegdDto, int ownerID); 
	
	public VehicleRegdDetlsEntity getVehicleRegdDtlsByVhclID(int vhclId);
}
