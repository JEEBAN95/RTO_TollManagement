package com.jk.inputDTO;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleOwnerDetlsDTO implements Serializable{
	
	private String first_name;
	private String last_name;
	private String gender;
	private String email;
	private long  phno;
	private Date dob;
	private long ssn;	//adhar no
		
	public VehicleOwnerDetlsDTO() {
		System.out.println("Vehicle_Owner_Detls_Cmd.Vehicle_Owner_Detls_Cmd()");
	}
}//class
