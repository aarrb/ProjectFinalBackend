package edu.iu.aurabaza.C322FinalBackend.repository;

import edu.iu.aurabaza.C322FinalBackend.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository
        extends CrudRepository<Order, Integer>
        , QueryByExampleExecutor<Order> {
    List<Order> findAllByCustomerUserName(String customerUserName);
}