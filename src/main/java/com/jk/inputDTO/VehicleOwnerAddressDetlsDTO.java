package com.jk.inputDTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class VehicleOwnerAddressDetlsDTO implements Serializable{
	private String hNo;
	private String streetName;
	private String city;
	private int zipCode;
}
