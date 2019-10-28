package com.jk.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleDetlsDTO implements Serializable{
	private static final long serialVersionUID = -2817844343566271467L;
	
	private String vtype;
	private int mfgYear;
	private String brandName;	//vehicle company name
	
}
