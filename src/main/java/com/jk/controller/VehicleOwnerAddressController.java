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

	// launch vehicleOwnerAddressRegistrationForm
	@GetMapping("/vhclOnrAddReg")
	public String showVhclOnrAddrRegForm(Model model, @RequestParam("ownerID") int id) {

		VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd = null;
		vhclOnrAddrRegdCmd = new VehicleOwnerAdderssDetlsCmd();
		model.addAttribute("vOwnerAddrDtlsModelCmd", vhclOnrAddrRegdCmd);
		model.addAttribute("ownerID", id);
		return "vehicle_owner_adderss_regd";
	}// showVhclOnrAddrRegForm

	// use service
	// redirect to next form
	@PostMapping("/vhclOnrAddrRegd")
	public String saveVhclOnrAddrRegFormData(@ModelAttribute VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd,
			@RequestParam("ownerID") int id) {

		VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO = null;
		vhclOnrAddrRegdDTO = new VehicleOwnerAddressDetlsDTO();
		BeanUtils.copyProperties(vhclOnrAddrRegdCmd, vhclOnrAddrRegdDTO);
		rtoService.insertVehicleOnwerAddr(vhclOnrAddrRegdDTO, id);
		return "redirect:/vhclDtls?ownerID=" + id;
	}// saveVhclOnrAddrRegFormData

	// use service
	// get owner address
	// launch vehicle_owner_adderss_update Form
	@GetMapping("/vhclOnrAddUpdtReg")
	public String vhclOwnrAddrRegShowUpdateForm(@ModelAttribute VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd,
			@RequestParam("ownerID") int id, Model model) {

		VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO = null;
		vhclOnrAddrRegdDTO = new VehicleOwnerAddressDetlsDTO();
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtlsEntity = null;
		vhclOnrAddrDtlsEntity = rtoService.getVehicleOnrAddrDtlsBy(id);
		BeanUtils.copyProperties(vhclOnrAddrDtlsEntity, vhclOnrAddrRegdDTO);
		BeanUtils.copyProperties(vhclOnrAddrRegdDTO, vhclOnrAddrRegdCmd);
		model.addAttribute("vOwnerAddrDtlsModelCmd", vhclOnrAddrRegdCmd);
		model.addAttribute("ownerID", id);
		return "vehicle_owner_adderss_update";
	}// vhclOwnrAddrRegShowUpdateForm

	// use service
	// redirect to next form
	@PostMapping("/vhclOnrAddrRegdUpdt")
	public String updateVhclOwnrAddr(@ModelAttribute VehicleOwnerAdderssDetlsCmd vhclOnrAddrRegdCmd,
			@RequestParam("ownerID") int id){

		VehicleOwnerAddressDetlsDTO vhclOnrAddrRegdDTO;
		vhclOnrAddrRegdDTO = new VehicleOwnerAddressDetlsDTO();
		BeanUtils.copyProperties(vhclOnrAddrRegdCmd, vhclOnrAddrRegdDTO);
			rtoService.updateVhclOnrAddr(vhclOnrAddrRegdDTO, id);
		return "redirect:/vhclDtls?ownerID=" + id;
	}// updateVhclOwnrAddr

}// class
