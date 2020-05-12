package com.youcode.ecommerce.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.youcode.ecommerce.entities.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> findAll(Pageable pageable);

}
