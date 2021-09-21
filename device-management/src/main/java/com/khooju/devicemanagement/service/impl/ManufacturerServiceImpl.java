package com.khooju.devicemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.khooju.devicemanagement.repository.ManufacturerRepo;
import com.khooju.devicemanagement.repository.modal.Manufacturer;
import com.khooju.devicemanagement.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepo manufacturerRepo;
	@Override
	public Manufacturer add(@Valid Manufacturer manufacturer) {
		return manufacturerRepo.save(manufacturer);
	}
	
	@Override
	public List<Manufacturer> findAll() {
		return manufacturerRepo.findAll();
	}
	
}
