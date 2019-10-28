package com.jk.inputDTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleDetlsDTO implements Serializable{
	
	private String vtype;
	private int mfgYear;
	private String brandName;	//vehicle company name
	
}
