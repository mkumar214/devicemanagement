package com.khooju.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.khooju.auth.db.model.LoginHistory;

public interface LoginHistoryRepo extends CrudRepository<LoginHistory, Long> {

}
