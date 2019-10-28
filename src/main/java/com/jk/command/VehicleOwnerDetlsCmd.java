package com.jk.command;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleOwnerDetlsCmd {
	
	private int pid;
	private String first_name;
	private String last_name;
	private String gender;
	private String email;
	private long  phno;
	private Date dob;
	private long ssn;	//adhar no
	
}//class
