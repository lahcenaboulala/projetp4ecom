package com.youcode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.OrderDetail;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {

}
