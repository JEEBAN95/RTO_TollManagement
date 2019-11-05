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

import com.jk.command.VehicleOwnerDetlsCmd;
import com.jk.dto.VehicleOwnerDetlsDTO;
import com.jk.entity.VehicleDetlsEntity;
import com.jk.entity.VehicleOwnerAdderssDetlsEnitity;
import com.jk.entity.VehicleOwnerDetlsEntity;
import com.jk.entity.VehicleRegdDetlsEntity;
import com.jk.service.RtoService;

@Controller
@SessionAttributes({ "vOwnerDtlsModelCmd" })
public class VehicleOwnerController {

	@Autowired
	private RtoService rtoService;

	// display homePage
	@GetMapping("/home")
	public String showHome() {

		return "home";
	}// showHome

	// display owner registration form
	@GetMapping("/register")
	public String showOwnerRegdForm(Model model) {
		VehicleOwnerDetlsCmd vhclOnrRegdCmd = null;
		vhclOnrRegdCmd = new VehicleOwnerDetlsCmd();
		model.addAttribute("vOwnerDtlsModelCmd", vhclOnrRegdCmd);
		return "vehicle_owner_regd";
	}// showOwnerRegdForm

	// get owner data
	// use service
	// redirect to next form
	@PostMapping("/vhclOnrRegister")
	public String saveOwnerRegdFormData(@ModelAttribute VehicleOwnerDetlsCmd vhclOnrRegdCmd) {

		VehicleOwnerDetlsDTO vhclOnrRegdDto = null;
		vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		BeanUtils.copyProperties(vhclOnrRegdCmd, vhclOnrRegdDto);
		int id = rtoService.insertVehicleOwner(vhclOnrRegdDto);
		return "redirect:/vhclOnrAddReg?ownerID=" + id;
	}// saveOwnerRegdFormData

	// use service
	// launch vehicle_owner_update Form
	@GetMapping("/updateVhclOnr")
	public String vehicleOwnerShowUpdateFormWithData(@ModelAttribute VehicleOwnerDetlsCmd vhclOnrRegdCmd,
			@RequestParam("ownerID") int id, Model model){

		VehicleOwnerDetlsDTO vhclOnrRegdDto = null;
		vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		VehicleOwnerDetlsEntity vhclOnrDtlsEntity = null;
		vhclOnrDtlsEntity = rtoService.getOwnerByID(id);
		BeanUtils.copyProperties(vhclOnrDtlsEntity, vhclOnrRegdDto);
		BeanUtils.copyProperties(vhclOnrRegdDto, vhclOnrRegdCmd);
		model.addAttribute("vOwnerDtlsModelCmd", vhclOnrRegdCmd);
		model.addAttribute("ownerID", id);
		return "vehicle_owner_update";
	}// vehicleOwnerShowUpdateFormWithData

	// use service
	// redirect to next
	@PostMapping("/vhclOnrRegdUpdt")
	public String updateVehicleOwner(@ModelAttribute VehicleOwnerDetlsCmd vhclOnrRegdCmd,
			@RequestParam("ownerID") int id) {

		VehicleOwnerDetlsDTO vhclOnrRegdDto = null;
		vhclOnrRegdDto = new VehicleOwnerDetlsDTO();
		BeanUtils.copyProperties(vhclOnrRegdCmd, vhclOnrRegdDto);
			rtoService.updateOwner(vhclOnrRegdDto, id);
		return "redirect:/vhclOnrAddReg?ownerID=" + id;
	}// updateVehicleOwner

	// use service
	// show details
	@GetMapping("/result")
	public String getDetails(Model model, @RequestParam("ownerID") int id, @RequestParam("vRId") int vhclId) {

		VehicleDetlsEntity vhclDtls = null;
		VehicleRegdDetlsEntity vhclRegdDtls = null;
		VehicleOwnerAdderssDetlsEnitity vhclOnrAddrDtls = null;

		vhclDtls = rtoService.getVehicleDtlsBy(id);
		vhclOnrAddrDtls = rtoService.getVehicleOnrAddrDtlsBy(id);
		vhclRegdDtls = rtoService.getVehicleRegdDtlsBy(id);
		model.addAttribute("vhclDtls", vhclDtls);
		model.addAttribute("vhclOnrAddrDtls", vhclOnrAddrDtls);
		model.addAttribute("vhclRegdDtls", vhclRegdDtls);
		model.addAttribute("ownerID", id);

		if (vhclId != 0) {
			model.addAttribute("success", "Successfully Registered");
			model.addAttribute("vhclRegdNum", rtoService.getVehicleRegdDtlsByVhclID(vhclId).getVehiceRegdNum());
			return "result";
		} // if
		return "result";
	}// getDetails

}// class
