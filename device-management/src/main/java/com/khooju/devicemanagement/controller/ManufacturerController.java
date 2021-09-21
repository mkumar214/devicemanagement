package com.khooju.devicemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khooju.devicemanagement.repository.modal.Manufacturer;
import com.khooju.devicemanagement.service.ManufacturerService;

@RestController
@RequestMapping(value = "/api/device/manufacturer")
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;
	
	@PostMapping("/add")
	@ResponseBody
	public Manufacturer addManufacturer(@Valid @RequestBody Manufacturer manufacturer) {
		Manufacturer addedManu = manufacturerService.add(manufacturer);
		return addedManu;
	}
	
	@GetMapping("/findall")
	@ResponseBody
	public List<Manufacturer> findAllManufcturer() {
		List<Manufacturer> maunfactures = manufacturerService.findAll();
		return maunfactures;
	}
	
}
