package com.pragma.hexagonal_archetype.driven_adapters.jpa.repository;

import com.pragma.hexagonal_archetype.driven_adapters.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
