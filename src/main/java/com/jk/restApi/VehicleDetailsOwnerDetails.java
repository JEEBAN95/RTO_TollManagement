package com.jk.restApi;

import com.jk.dto.VehicleDetlsDTO;
import com.jk.dto.VehicleOwnerAddressDetlsDTO;
import com.jk.dto.VehicleOwnerDetlsDTO;
import com.jk.dto.VehicleRegdDetlsDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class VehicleDetailsOwnerDetails {
	
	//Configure all dto classes
	private VehicleDetlsDTO vhclDto;
	private VehicleOwnerAddressDetlsDTO vhclOnrAddrDtlsDto;
	private VehicleOwnerDetlsDTO vhclOnrDtlsDto;
	private VehicleRegdDetlsDTO vhclRegdDtlsDto;
	
	
}
