package com.pragma.clean_architecture.driven_adapters.jpa.repository;

import com.pragma.clean_architecture.driven_adapters.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
