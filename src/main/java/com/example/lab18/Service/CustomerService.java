package com.example.lab18.Service;


import com.example.lab18.Api.ApiException;
import com.example.lab18.Model.CustomerModel;
import com.example.lab18.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerModel> getCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(CustomerModel customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, CustomerModel customer){
        CustomerModel oldCustomer=customerRepository.findCustomerModelById(id);
        if(oldCustomer==null)
            throw new ApiException("Id not found");
        oldCustomer=customer;
        oldCustomer.setId(id);
        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id){
        CustomerModel customer=customerRepository.findCustomerModelById(id);
        if(customer==null)
            throw new ApiException("Id not found");
        customerRepository.delete(customer);
    }

}
