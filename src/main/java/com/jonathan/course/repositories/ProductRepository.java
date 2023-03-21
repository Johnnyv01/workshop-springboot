package com.jonathan.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonathan.course.entities.Category;
import com.jonathan.course.entities.Order;
import com.jonathan.course.entities.Product;
import com.jonathan.course.entities.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
