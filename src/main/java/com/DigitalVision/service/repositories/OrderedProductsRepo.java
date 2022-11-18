package com.DigitalVision.service.repositories;

import com.DigitalVision.service.models.OrderedProducts;
import jdk.jfr.Enabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories

public interface OrderedProductsRepo extends JpaRepository<OrderedProducts,Long>{
}
