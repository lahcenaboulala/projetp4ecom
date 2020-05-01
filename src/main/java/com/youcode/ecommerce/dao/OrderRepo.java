package com.youcode.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Client;
import com.youcode.ecommerce.entities.OrderDetail;

@Repository
public interface OrderRepo extends PagingAndSortingRepository<OrderDetail, Long> {

	Page<OrderDetail> findAllByClient(Client client, Pageable pageable);

	Page<OrderDetail> findAllByPhone(String phone, Pageable pageable);

}
