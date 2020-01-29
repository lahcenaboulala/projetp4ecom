package com.youcode.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {

}
