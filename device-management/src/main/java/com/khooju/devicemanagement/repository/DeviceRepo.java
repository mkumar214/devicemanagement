package com.khooju.devicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khooju.devicemanagement.repository.modal.Device;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Long> {

}
