package org.vegetableApp.vegetable.vegetableController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.vegetableApp.vegetable.model.VegetableDTO;
import org.vegetableApp.vegetable.service.VegetableService;

@Controller
@RequestMapping("/vegetable")
public class VegetableController {
	@Autowired
	private VegetableService vegetableService;
	
	@GetMapping("/addvegetable")
	public String addVegetable(Model model) {
		VegetableDTO vegetable = new VegetableDTO();
		model.addAttribute("vegetable",vegetable);
		return "vegetable/addvegetable";
	}

	
	@PostMapping("/addvegetableprocess")
	public String addVegetableProcess(@ModelAttribute("vegetable") VegetableDTO vegetable) {
		VegetableDTO veg = vegetableService.addVegetable(vegetable);
		if(veg == null ) {
			return "vegetable/vegetableaddunsuccess";
		}else {
			return "vegetable/vegetableaddsuccess";
		}
	}
	
	@GetMapping("/updatevegetable")
	public String updateVegetable(Model model) {
		VegetableDTO vegetable = new VegetableDTO();
		model.addAttribute("vegetable",vegetable);
		return "vegetable/updatevegetable";
	}
	
	@GetMapping("/vegetablesearchforupdate")
	public String searchForUpdate(@ModelAttribute("vegetable") VegetableDTO vegetable,Model model) {
		VegetableDTO veg = vegetableService.viewVegetableById(vegetable.getVegId());
		if(veg == null) {
			return "vegetable/vegetablenotfound";
		}else {
			model.addAttribute("vegetable",veg);
			return "vegetable/vegetableupdatesearch";
		}
	}
	
	
	@PostMapping("/updatevegetableprocess")
	public String updateVegetableProcess(@ModelAttribute("vegetable") VegetableDTO vegetable){
		 vegetable = vegetableService.updateVegetable(vegetable);
		if(vegetable == null) {
			return "vegetable/vegetableupdateunsuccess";
		}else {
			return "vegetable/vegetableupdatesuccess";
		}
	}
	
	
	@GetMapping("/deletevegetable")
	public String deleteVegetable(Model model) {
		VegetableDTO vegetable = new VegetableDTO();
		model.addAttribute("vegetable",vegetable);
		return "vegetable/deletevegetable";
	}
	
	@GetMapping("/delvegetable")
	public String delVegetable(@RequestParam("vegetableid") Integer vegId, Model model) {
		VegetableDTO veg = vegetableService.viewVegetableById(vegId);
		if(veg == null) {
			return "vegetable/vegetablenotfound";
		}else {
			model.addAttribute("vegetable",veg);
			return "vegetable/vegetabledeletesearch";
		}
	}
	

	
	@GetMapping("/vegetablesearchfordelete")
	public String searchForDelete(@ModelAttribute("vegetable") VegetableDTO vegetable,Model model) {
		VegetableDTO veg = vegetableService.viewVegetableById(vegetable.getVegId());
		if(veg == null) {
			return "vegetable/vegetablenotfound";
		}else {
			model.addAttribute("vegetable",veg);
			return "vegetable/vegetabledeletesearch";
		}
	}
	
	
	@PostMapping("/deletevegetableprocess")
	public String deleteVegetableProcess(@ModelAttribute("vegetable") VegetableDTO vegetable){
		 vegetable = vegetableService.removeVegetable(vegetable.getVegId());
		if(vegetable == null) {
			return "vegetable/vegetabledeleteunsuccess";
		}else {
			return "vegetable/vegetabledeletesuccess";
		}
	}
	
	@GetMapping("/listvegetable")
	public String listVegetable(Model model) {
		
		List<VegetableDTO> list = vegetableService.viewAllVegetable();
		model.addAttribute("vegetables",list);
		return "vegetable/listvegetable";
		
	}
	
	
	@GetMapping("/viewvegetable")
	public String viewVegetable(@RequestParam("vegetableid") Integer vegId, Model model) {
		
		VegetableDTO vegetable = vegetableService.viewVegetableById(vegId);
		model.addAttribute("vegetable", vegetable);
		return "vegetable/viewvegetable";
	}
	
}
