package com.jk.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleRegdDetlsDTO implements Serializable{
	private static final long serialVersionUID = -3201751647597457644L;
	
	private Date regdDate;
	private String regCenter;
	private String vehiceRegdNum;
	
}
