package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderEntity;

import antlr.collections.List;

@Repository
public interface IOrderDAO extends JpaRepository<OrderEntity, Integer> {



	
		@Query(value="select * from order c where c.type=?1",nativeQuery=true)
		List findAllOrdersByType(String type);

 
}