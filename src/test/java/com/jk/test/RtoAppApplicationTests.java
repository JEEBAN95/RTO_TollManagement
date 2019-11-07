package com.jk.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jk.dto.VehicleOwnerAddressDetlsDTO;
import com.jk.dto.VehicleOwnerDetlsDTO;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.entity.VehicleOwnerDetlsEntity;
import com.jk.repository.VehicleOwnerAddrRegdRepository;
import com.jk.repository.VehicleOwnerRegdRepository;
import com.jk.service.RtoService;

@SpringBootTest
class RtoAppApplicationTests {

	@Autowired
	RtoService service;
	@MockBean
	VehicleOwnerRegdRepository vhclOnrRegdRepo;
	@MockBean
	VehicleOwnerAddrRegdRepository vhclOnrAddrRepo;

	@Test
	// Vehicle Owner Details Save Test
	public void saveVehicleOwnerDetailsSaveTest1() {

		VehicleOwnerDetlsDTO vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		vhclOnrRegdDto.setFirst_name("Alaxa");
		vhclOnrRegdDto.setLast_name("pari");
		vhclOnrRegdDto.setEmail("alaxa@gmail.com");
		vhclOnrRegdDto.setGender("female");
		vhclOnrRegdDto.setPhno(7418526310L);
		vhclOnrRegdDto.setDob(new Date(0));
		vhclOnrRegdDto.setSsn(74185296385L);
		VehicleOwnerDetlsEntity vhclOnrRegdEntity = new VehicleOwnerDetlsEntity();
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdEntity);
		vhclOnrRegdEntity.setPid(1);

		when(vhclOnrRegdRepo.save(vhclOnrRegdEntity)).thenReturn(vhclOnrRegdEntity);
		assertEquals(vhclOnrRegdEntity, service.insertVehicleOwner(vhclOnrRegdDto));
	}

	@Test
	public void saveVehicleOwnerDetailsSaveTest2() {

		VehicleOwnerDetlsDTO vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		vhclOnrRegdDto.setFirst_name("Alaxa");
		vhclOnrRegdDto.setLast_name("pari");
		vhclOnrRegdDto.setEmail("alaxa@gmail.com");
		vhclOnrRegdDto.setGender("female");
		vhclOnrRegdDto.setPhno(7418526310L);
		vhclOnrRegdDto.setDob(new Date(0));
		vhclOnrRegdDto.setSsn(74185296385L);
		VehicleOwnerDetlsEntity vhclOnrRegdEntity = new VehicleOwnerDetlsEntity();
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdEntity);
		vhclOnrRegdEntity.setPid(1);
		when(vhclOnrRegdRepo.save(vhclOnrRegdEntity)).thenReturn(vhclOnrRegdEntity);
		assertEquals(vhclOnrRegdEntity, vhclOnrRegdEntity);
	}
	
	@Test
	// Vehicle Owner Details Save Test
	public void saveVehicleOwnerAdddressDetailsSaveTest1() {
		VehicleOwnerAddressDetlsDTO vhclOnrAddRegDto = new VehicleOwnerAddressDetlsDTO();
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddDtlsEntity = new VehicleOwnerAdderssDetlsEnitity();
		vhclOnrAddRegDto.setCity("abc");
		vhclOnrAddRegDto.setHNo("Markko Road HN-25");
		vhclOnrAddRegDto.setStreetName("Markko HB Galary");
		vhclOnrAddRegDto.setZipCode(74185);
		BeanUtils.copyProperties(vhclOnrAddRegDto, vhclOnrAddDtlsEntity);
		when(vhclOnrAddrRepo.save(vhclOnrAddDtlsEntity)).thenReturn(vhclOnrAddDtlsEntity);
		assertEquals(vhclOnrAddDtlsEntity, service.insertVehicleOnwerAddr(vhclOnrAddRegDto, 1));
	}
	@Test
	// Vehicle Owner Details Save Test
	public void saveVehicleOwnerAdddressDetailsSaveTest2() {
		VehicleOwnerAddressDetlsDTO vhclOnrAddRegDto = new VehicleOwnerAddressDetlsDTO();
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddDtlsEntity = new VehicleOwnerAdderssDetlsEnitity();
		vhclOnrAddRegDto.setCity("abc");
		vhclOnrAddRegDto.setHNo("Markko Road HN-25");
		vhclOnrAddRegDto.setStreetName("Markko HB Galary");
		vhclOnrAddRegDto.setZipCode(74185);
		BeanUtils.copyProperties(vhclOnrAddRegDto, vhclOnrAddDtlsEntity);
		Optional<VehicleOwnerDetlsEntity> vhclOnrRegdEntity = vhclOnrRegdRepo.findById(1);
		vhclOnrAddDtlsEntity.setOwner(vhclOnrRegdEntity.get());
		System.out.println("--------------------"+service.insertVehicleOnwerAddr(vhclOnrAddRegDto, 1));
		when(vhclOnrAddrRepo.save(vhclOnrAddDtlsEntity)).thenReturn(vhclOnrAddDtlsEntity);
		assertEquals(vhclOnrAddDtlsEntity,service.insertVehicleOnwerAddr(vhclOnrAddRegDto, vhclOnrRegdEntity.get().getPid()));
	}
}
