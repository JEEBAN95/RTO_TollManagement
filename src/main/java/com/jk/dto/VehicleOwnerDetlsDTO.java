package com.jk.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleOwnerDetlsDTO implements Serializable{
	private static final long serialVersionUID = 8932634700182948057L;
	
	private String first_name;
	private String last_name;
	private String gender;
	private String email;
	private long  phno;
	private Date dob;
	private long ssn;	//adhar no
}//class
