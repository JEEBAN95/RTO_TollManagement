package com.jk.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleDetlsDTO implements Serializable{
	private static final long serialVersionUID = 5689405887922106595L;

	private String vtype;
	private int mfgYear;
	private String brandName;	//vehicle company name
	
}
