package com.jk.inputDTO;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleRegdDetlsDTO implements Serializable{

	private Date regdDate;
	private String regCenter;
	private long vehiceRegdNum;
	
	public VehicleRegdDetlsDTO() {
		System.out.println("Vehicle_Regd_Detls_Cmd.Vehicle_Regd_Detls_Cmd()");
	}
}
