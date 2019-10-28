package com.jk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jk.command.VehicleOwnerDetlsCmd;
import com.jk.dto.VehicleOwnerDetlsDTO;
import com.jk.entity.VehicleDetlsEntity;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.entity.VehicleRegdDetlsEntity;
import com.jk.service.RtoService;

@Controller
@SessionAttributes({ "vOwnerDtlsModelCmd" })
public class VehicleOwnerController {

	@Autowired
	private RtoService rtoService;

	private VehicleOwnerDetlsCmd vhclOnrRegdCmd;
	private VehicleOwnerDetlsDTO vhclOnrRegdDto;

	// display owner registration form
	@GetMapping("/register")
	public String showOwnerRegistrationForm(Model model) {
		vhclOnrRegdCmd = new VehicleOwnerDetlsCmd();
		model.addAttribute("vOwnerDtlsModelCmd", vhclOnrRegdCmd);
		return "vehicle_owner_regd";
	}

	// get owner data
	@PostMapping("/vhclOnrRegister")
	public String getOwnerRegistrationFormData(@ModelAttribute VehicleOwnerDetlsCmd vhclOnrRegdCmd) {
		vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		BeanUtils.copyProperties(vhclOnrRegdCmd, vhclOnrRegdDto);

		// use service
		int id = rtoService.insertVehicleOwner(vhclOnrRegdDto);
		return "redirect:/vhclOnrAddReg?ownerID="+id;
	}

	@GetMapping("/result")
	public String showResult(Model model, @RequestParam("ownerID") int id) {
		
		// use service
		VehicleDetlsEntity vhclDtls = rtoService.getVehicleDtlsBy(id);
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtls = rtoService.getVehicleOnrAddrDtlsBy(id);
		VehicleRegdDetlsEntity vhclRegdDtls = rtoService.getVehicleRegdDtlsBy(id);
		
		model.addAttribute("vhclDtls", vhclDtls);
		model.addAttribute("vhclOnrAddrDtls",vhclOnrAddrDtls);
		model.addAttribute("vhclRegdDtls", vhclRegdDtls);
		model.addAttribute("ownerID",id);
		return "result";
	}
	
	@GetMapping("/updateVhclOnr")
	public String updateVehicleOwnerShowFormWithData(@ModelAttribute VehicleOwnerDetlsCmd vhclOnrRegdCmd,
			@RequestParam("ownerID")int id, Model model) {
		
		vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		//use service
		BeanUtils.copyProperties(rtoService.getOwnerByID(id), vhclOnrRegdDto);
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdCmd);
		model.addAttribute("vOwnerDtlsModelCmd",vhclOnrRegdCmd);
		model.addAttribute("ownerID",id);
		return "vehicle_owner_update";
	}
	
	@PostMapping("/vhclOnrRegdUpdt")
	public String updateVehicleOwner(@ModelAttribute VehicleOwnerDetlsCmd vhclOnrRegdCmd, @RequestParam("ownerID")int id) {
		
		vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		BeanUtils.copyProperties(vhclOnrRegdCmd, vhclOnrRegdDto);
		//use service
		rtoService.updateOwner(vhclOnrRegdDto,id);
		return "redirect:/vhclOnrAddReg?ownerID="+id;
	}
}