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

	@GetMapping("/vhclReg")
	public String showVhclRegdForm(Model model, @RequestParam("ownerID") int id) {
		VehicleRegdDetlsCmd vhclRegdCmd = null;
		vhclRegdCmd = new VehicleRegdDetlsCmd();
		model.addAttribute("vRegdModelCmd", vhclRegdCmd);
		model.addAttribute("ownerID", id);
		return "vehicle-regd";
	}// showVhclRegdForm

	@PostMapping("/vhclRegd")
	public String saveVhclRegdFormData(@RequestParam("ownerID") int id,
			@ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd) {

		VehicleRegdDetlsDTO vhclRegdDto = null;
		vhclRegdDto = new VehicleRegdDetlsDTO();
		BeanUtils.copyProperties(vhclRegdCmd, vhclRegdDto);
		// use service
		rtoService.insertVehicleRegDetails(vhclRegdDto, id);
		return "redirect:/result?ownerID=" + id + "&vRId=" + 0;
	}// saveVhclRegdFormData

	@GetMapping("/vhclRegUpdate")
	public String vhclRegdUpdateFormData(@RequestParam("ownerID") int id,
			@ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd, Model model) {

		VehicleRegdDetlsDTO vhclRegdDto = null;
		vhclRegdDto = new VehicleRegdDetlsDTO();
		VehicleRegdDetlsEntity vhclRegdEntity = rtoService.getVehicleRegdDtlsBy(id);
		BeanUtils.copyProperties(vhclRegdEntity, vhclRegdDto);
		BeanUtils.copyProperties(vhclRegdDto, vhclRegdCmd);
		model.addAttribute("vRegdModelCmd", vhclRegdCmd);
		model.addAttribute("ownerID", id);
		// vehicle-regdUpdate launch form
		return "vehicle-regdUpdate";
	}// vhclRegdUpdateFormData

	// redirect to next page
	// use service
	@PostMapping("/vhclRegdUpd")
	public String updateVhclRegdForm(@RequestParam("ownerID") int id, @ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd) {

		VehicleRegdDetlsDTO vhclRegdDto = null;
		vhclRegdDto = new VehicleRegdDetlsDTO();
		BeanUtils.copyProperties(vhclRegdCmd, vhclRegdDto);
		rtoService.updateVhclRegdDtls(vhclRegdDto, id);
		return "redirect:/result?ownerID=" + id + "&vRId=" + 0;
	}// updateVhclRegdForm

	// use service
	// redirect to result page
	@GetMapping("/showDetails")
	public String submitMethod(@RequestParam("vRId") int vhclId, @ModelAttribute VehicleRegdDetlsCmd vhclRegdCmd,
			Model model) {

		int id = rtoService.getVehicleRegdDtlsByVhclID(vhclId).getOwner().getPid();
		return "redirect:/result?ownerID=" + id + "&vRId=" + vhclId;
	}// submitMethod
}// class
