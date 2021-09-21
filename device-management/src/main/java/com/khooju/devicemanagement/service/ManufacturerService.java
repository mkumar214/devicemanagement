package com.khooju.devicemanagement.service;

import java.util.List;

import javax.validation.Valid;

import com.khooju.devicemanagement.repository.modal.Manufacturer;

/**
 * This intefaces exposes services of the devices 
 * @author mukesh
 *
 */
public interface ManufacturerService {

	Manufacturer add(@Valid Manufacturer manufacturer);

	List<Manufacturer> findAll();

}
