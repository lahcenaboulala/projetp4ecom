package com.youcode.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Client;
import com.youcode.ecommerce.entities.OrderDetail;

@Repository
public interface OrderRepo extends PagingAndSortingRepository<OrderDetail, Long> {

	List<OrderDetail> findByClient(Client client, Pageable pageable);

}
