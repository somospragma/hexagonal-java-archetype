package com.pragma.hexagonal_archetype.driven_adapters.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.pragma.hexagonal_archetype.driven_adapters.jpa"})
public class JpaConfig {
}
