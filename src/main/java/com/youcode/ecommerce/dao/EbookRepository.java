package com.youcode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Ebook;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {

}
