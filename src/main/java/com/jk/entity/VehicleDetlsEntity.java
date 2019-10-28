package com.jk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="VEHICLE_DETLS")
public class VehicleDetlsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VEHICLE_DTL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "VEHICLE_DTL_ID_SEQ")
	private int vid;
	@Column(name="VEHICLE_TYPE")
	private String vtype;
	@Column(name="MFG_YEAR")
	private int mfgYear;
	@Column(name="BRAND_NAME")
	private String brandName;	//vehicle company name
	
	@OneToOne(orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private VehicleOwnerDetlsEntity  owner;
	
}
