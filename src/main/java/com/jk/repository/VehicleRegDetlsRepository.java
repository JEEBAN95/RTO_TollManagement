package com.jk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jk.entity.VehicleRegdDetlsEntity;
@Repository
public interface VehicleRegDetlsRepository extends JpaRepository<VehicleRegdDetlsEntity, Serializable> {
	
	@Query(value="SELECT * FROM VEHICLE_REGD_DTLS WHERE OWNER_VEHICLE_OWNER_ID=?1", nativeQuery = true)
	VehicleRegdDetlsEntity findByOwnerIdFk(int ownerID);
	
	@Query(value="SELECT * FROM VEHICLE_REGD_DTLS WHERE VEHICLE_REGD_ID=?1", nativeQuery = true)
	VehicleRegdDetlsEntity findByRegdId(int vhclId);
}
