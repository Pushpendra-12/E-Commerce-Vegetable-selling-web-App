package org.vegetableApp.vegetable.service;

import java.util.List;

import org.vegetableApp.vegetable.model.VegetableDTO;


public interface VegetableService {
	public VegetableDTO addVegetable(VegetableDTO vegetable);
	public VegetableDTO updateVegetable(VegetableDTO vegetable);
	public VegetableDTO removeVegetable(Integer vegId);
	public List<VegetableDTO> viewAllVegetable();
	public VegetableDTO viewVegetableById(Integer vegId);
}
