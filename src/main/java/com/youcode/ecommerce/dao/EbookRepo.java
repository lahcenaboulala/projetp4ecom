package com.youcode.ecommerce.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Ebook;

@Repository
public interface EbookRepo extends PagingAndSortingRepository<Ebook, Long> {

}
