package com.jk.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jk.entity.VehicleDetlsEntity;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetlsEntity, Serializable>  {
	
	@Query(value="SELECT * FROM VEHICLE_DETLS WHERE owner_vehicle_owner_id=?1", nativeQuery = true)
	VehicleDetlsEntity findByOwnerIdFk(int id);
}
