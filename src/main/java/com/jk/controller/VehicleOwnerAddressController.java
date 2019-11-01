package com.jk.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jk.command.VehicleOwnerAdderssDetlsCmd;
import com.jk.dto.VehicleOwnerAddressDetlsDTO;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.service.RtoService;

@Controller
@SessionAttributes({ "vOwnerAddrDtlsModelCmd" })
public class VehicleOwnerAddressController {

	@Autowired
	private RtoService rtoService;

	private VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd;
	private VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO;

	// display vehicleOwnerAddressRegistrationForm
	@GetMapping("/vhclOnrAddReg")
	public String showVhclOnrAddrRegForm(Model model, @RequestParam("ownerID") int id) {
		vhclOnrAddrRegdCmd = new VehicleOwnerAdderssDetlsCmd();
		model.addAttribute("vOwnerAddrDtlsModelCmd", vhclOnrAddrRegdCmd);
		model.addAttribute("ownerID", id);
		return "vehicle_owner_adderss_regd";
	}//showVhclOnrAddrRegForm

	@PostMapping("/vhclOnrAddrRegd")
	public String saveVhclOnrAddrRegFormData(@ModelAttribute VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd,
			@RequestParam("ownerID") int id) {
		
		vhclOnrAddrRegdDTO = new VehicleOwnerAddressDetlsDTO();
		// copy cmd to dto
		BeanUtils.copyProperties(vhclOnrAddrRegdCmd, vhclOnrAddrRegdDTO);
		//use service
		rtoService.insertVehicleOnwerAddr(vhclOnrAddrRegdDTO, id);
		//redirect to next form
		return "redirect:/vhclDtls?ownerID="+id;
	}//getVhclOnrAddrRegFormData
	
	@GetMapping("/vhclOnrAddUpdtReg")
	public String updateVhclOwnrAddrRegShowFormData(@ModelAttribute VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd,
			@RequestParam("ownerID")int id, Model model) {
		vhclOnrAddrRegdDTO = new VehicleOwnerAddressDetlsDTO();
		//use service
		//get owner  address
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtlsEntity = rtoService.getVehicleOnrAddrDtlsBy(id);
		BeanUtils.copyProperties(vhclOnrAddrDtlsEntity,vhclOnrAddrRegdDTO);
		BeanUtils.copyProperties(vhclOnrAddrRegdDTO, vhclOnrAddrRegdCmd);
		model.addAttribute("vOwnerAddrDtlsModelCmd", vhclOnrAddrRegdCmd);		
		model.addAttribute("ownerID",id); 
		return "vehicle_owner_adderss_update";
	}
	
	
	@PostMapping("/vhclOnrAddrRegdUpdt")
	public String updateVhclOwnrAddr(@ModelAttribute VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd,
			@RequestParam("ownerID")int id) {
		vhclOnrAddrRegdDTO = new VehicleOwnerAddressDetlsDTO();
		BeanUtils.copyProperties(vhclOnrAddrRegdCmd, vhclOnrAddrRegdDTO);
		//use service
		rtoService.updateVhclOnrAddr(vhclOnrAddrRegdDTO,id);
		return "redirect:/vhclDtls?ownerID="+id;
	}
}
