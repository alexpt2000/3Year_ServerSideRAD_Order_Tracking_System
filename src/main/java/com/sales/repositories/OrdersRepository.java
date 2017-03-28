package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Order;

@Repository
public interface OrdersRepository extends CrudRepository<Order, Long> {

}
