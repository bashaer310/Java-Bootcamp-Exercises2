package com.example.lab18.Repository;

import com.example.lab18.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Integer> {
CustomerModel findCustomerModelById(Integer id);
}

