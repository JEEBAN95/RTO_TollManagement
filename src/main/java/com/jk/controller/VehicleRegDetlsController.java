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

import com.jk.command.VehicleRegdDetlsCmd;
import com.jk.dto.VehicleRegdDetlsDTO;
import com.jk.entity.VehicleRegdDetlsEntity;
import com.jk.service.RtoService;

@Controller
@SessionAttributes({ "vRegdModelCmd" })
public class VehicleRegDetlsController {

	@Autowired
	private RtoService rtoService;

	// command class
	private VehicleRegdDetlsCmd vhclRegdCmd;

	private VehicleRegdDetlsDTO vhclRegdDto;

	@GetMapping("/vhclReg")
	public String showVhclRegdForm(Model model, @RequestParam("ownerID") int id) {

		vhclRegdCmd = new VehicleRegdDetlsCmd();
		model.addAttribute("vRegdModelCmd", vhclRegdCmd);
		model.addAttribute("ownerID", id);
		return "vehicle-regd";
	}// showVhclRegdForm

	@PostMapping("/vhclRegd")
	public String saveVhclRegdFormData(@RequestParam("ownerID") int id,
			@ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd) {
		vhclRegdDto = new VehicleRegdDetlsDTO();
		// copy cmd to dto
		BeanUtils.copyProperties(vhclRegdCmd, vhclRegdDto);
		// use service
		rtoService.insertVehicleRegDetails(vhclRegdDto, id);
		return "redirect:/result?ownerID=" + id + "&vRId=" + 0;
	}// saveVhclRegdFormData

	@GetMapping("/vhclRegUpdate")
	public String updateVhclRegdFormData(@RequestParam("ownerID") int id,
			@ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd, Model model) {

		vhclRegdDto = new VehicleRegdDetlsDTO();
		VehicleRegdDetlsEntity vhclRegdEntity = rtoService.getVehicleRegdDtlsBy(id);
		BeanUtils.copyProperties(vhclRegdEntity, vhclRegdDto);
		BeanUtils.copyProperties(vhclRegdDto, vhclRegdCmd);
		model.addAttribute("vRegdModelCmd", vhclRegdCmd);
		model.addAttribute("ownerID", id);
		// vehicle-regdUpdate launch form
		return "vehicle-regdUpdate";
	}// updateVhclRegdFormData

	@PostMapping("/vhclRegdUpd")
	public String updateVhclRegdForm(@RequestParam("ownerID") int id, @ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd) {

		vhclRegdDto = new VehicleRegdDetlsDTO();
		BeanUtils.copyProperties(vhclRegdCmd, vhclRegdDto);
		// use service
		rtoService.updateVhclRegdDtls(vhclRegdDto, id);
		// after update redirect to next page
		return "redirect:/result?ownerID=" + id + "&vRId=" + 0;
	}// updateVhclRegdForm

	@GetMapping("/showDetails")
	public String submitMethod(@RequestParam("vRId") int vhclId, @ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd,
			Model model) {

		// use service
		int id = rtoService.getVehicleRegdDtlsByVhclID(vhclId).getOwner().getPid();
		// after submit redirect to result page
		return "redirect:/result?ownerID=" + id + "&vRId=" + vhclId;
	}// submitMethod
}// class 
