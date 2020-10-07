package com.spring.boot.notification.client.b.dao;

import com.spring.boot.notification.client.b.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

}
