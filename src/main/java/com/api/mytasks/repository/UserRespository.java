package com.api.mytasks.repository;

import com.api.mytasks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRespository extends JpaRepository<User, UUID> {

}
