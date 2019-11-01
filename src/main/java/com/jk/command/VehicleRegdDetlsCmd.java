package com.jk.command;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleRegdDetlsCmd {

	private Date regdDate;
	private String regCenter;
	private String vehiceRegdNum;
	
}
