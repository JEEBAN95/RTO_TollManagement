package com.jk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;

@Repository
public interface VehicleOwnerAddrRegdRepository extends JpaRepository<VehicleOwnerAdderssDetlsEnitity, Serializable>{
	
	@Query(value="SELECT * FROM VEHICLE_OWNER_ADDRESS_DETLS WHERE owner_vehicle_owner_id=?1", nativeQuery = true)
	VehicleOwnerAdderssDetlsEnitity findByOwnerIdFk(int ownerID);
}
