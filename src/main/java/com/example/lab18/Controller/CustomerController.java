package com.example.lab18.Controller;


import com.example.lab18.Api.ApiResponse;
import com.example.lab18.Model.CustomerModel;
import com.example.lab18.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getCustomers(){
        return  ResponseEntity.status(200).body(customerService.getCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid CustomerModel customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("Customer added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@RequestBody @Valid CustomerModel customer, @PathVariable Integer id) {
        customerService.updateCustomer(id,customer);
        return ResponseEntity.status(200).body(new ApiResponse("Customer updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("Customer deleted"));
    }
}