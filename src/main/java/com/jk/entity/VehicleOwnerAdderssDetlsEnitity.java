package com.jk.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="VEHICLE_OWNER_ADDRESS_DETLS")
public class VehicleOwnerAdderssDetlsEnitity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator ="ADDRESS_ID_SEQ")
	private int addrId;
	@Column(name="HNO")
	private String hNo;
	@Column(name="STREET_NAME")
	private String streetName;
	@Column(name="CITY")
	private String city;
	@Column(name="ZIP_CODE")
	private int zipCode;
	
	@Column(name="CREATE_DT",updatable=false)
	@CreationTimestamp
	private Timestamp createdDate;
	
	@Column(name = "UPDATE_DT")
	@UpdateTimestamp
	private Timestamp updateDate;
	
	@OneToOne(orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private VehicleOwnerDetlsEntity  owner;
}
