package com.khooju.devicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khooju.devicemanagement.repository.modal.Device;
import com.khooju.devicemanagement.repository.modal.Manufacturer;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {

}
