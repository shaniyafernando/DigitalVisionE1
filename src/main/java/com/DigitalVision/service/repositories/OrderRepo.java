package com.DigitalVision.service.repositories;

import com.DigitalVision.service.models.Order;
import jdk.jfr.Enabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories

public interface OrderRepo extends JpaRepository<Order,Long> {
}