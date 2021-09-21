package com.khooju.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.khooju.auth.db.model.UserProfile;

public interface UserProfileRepo extends CrudRepository<UserProfile, Long> {

}
