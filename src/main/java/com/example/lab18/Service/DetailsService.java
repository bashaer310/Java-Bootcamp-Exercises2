package com.example.lab18.Service;

import com.example.lab18.Api.ApiException;
import com.example.lab18.DTO.DetailsDTO;
import com.example.lab18.Model.CustomerModel;
import com.example.lab18.Model.DetailsModel;
import com.example.lab18.Repository.CustomerRepository;
import com.example.lab18.Repository.DetailsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class DetailsService {
    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;

    public List<DetailsModel> getAllDetails(){
        return detailsRepository.findAll();
    }
    public void addDetails(DetailsDTO detailsDTO){
        CustomerModel customer= customerRepository.findCustomerModelById(detailsDTO.getCustomer_id());
        if (customer==null)
            throw new ApiException("Id not found");

        DetailsModel detailsModel=new DetailsModel(null,detailsDTO.getGender(),detailsDTO.getEmail(),detailsDTO.getAge(),customer);
    detailsRepository.save(detailsModel);
    }
    public void updateDetails(DetailsDTO detailsDTO,Integer id){
        DetailsModel oldDetails= detailsRepository.findDetailsModelById(id);
        if (oldDetails==null)
            throw new ApiException("Id not found");

        oldDetails.setGender(detailsDTO.getGender());
        oldDetails.setAge(detailsDTO.getAge());
        oldDetails.setEmail(detailsDTO.getEmail());
        detailsRepository.save(oldDetails);
    }
    public void deleteDetails(Integer id){
        DetailsModel details= detailsRepository.findDetailsModelById(id);
        CustomerModel customer= customerRepository.findCustomerModelById(id);

        if (details==null)
            throw new ApiException("Id not found");

        customer.setDetailsModel(null);
        customerRepository.save(customer);
        detailsRepository.delete(details);

    }
}
