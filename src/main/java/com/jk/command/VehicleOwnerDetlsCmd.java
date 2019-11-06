package com.jk.command;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleOwnerDetlsCmd {

	private String first_name;
	private String last_name;
	private String gender;
	private String email;
	private Long  phno;
	private Date dob;
	private Long ssn;
	
}//class
