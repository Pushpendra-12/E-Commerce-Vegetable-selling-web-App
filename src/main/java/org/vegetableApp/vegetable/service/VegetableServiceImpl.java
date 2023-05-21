package org.vegetableApp.vegetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetableApp.vegetable.model.VegetableDTO;
import org.vegetableApp.vegetable.repository.VegetableRepository;
@Service("vegetableService")
public class VegetableServiceImpl implements VegetableService{
	
	@Autowired
	private VegetableRepository vegetableRepository;

	@Override
	public VegetableDTO addVegetable(VegetableDTO vegetable) {
		// TODO Auto-generated method stub
		return vegetableRepository.save(vegetable);
	}

	@Override
	public VegetableDTO updateVegetable(VegetableDTO vegetable) {
		// TODO Auto-generated method stub
		return vegetableRepository.save(vegetable);
	}

	@Override
	public VegetableDTO removeVegetable(Integer vegId) {
		VegetableDTO veg = vegetableRepository.findById(vegId).get();
		vegetableRepository.deleteById(vegId);
		return veg;
	}

	@Override
	public List<VegetableDTO> viewAllVegetable() {
		// TODO Auto-generated method stub
		return vegetableRepository.findAll();
	}

	@Override
	public VegetableDTO viewVegetableById(Integer vegId){
		// TODO Auto-generated method stub
		Optional<VegetableDTO> opt = vegetableRepository.findById(vegId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

}
