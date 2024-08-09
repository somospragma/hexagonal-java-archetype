package com.pragma.clean_architecture.driven_adapters.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.pragma.clean_architecture.driven_adapters.jpa"})
public class JpaConfig {
}
