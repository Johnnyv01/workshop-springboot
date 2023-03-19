package com.jonathan.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonathan.course.entities.Order;
import com.jonathan.course.entities.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
