package com.example.lab18.Controller;


import com.example.lab18.Api.ApiResponse;
import com.example.lab18.DTO.DetailsDTO;
import com.example.lab18.Model.CustomerModel;
import com.example.lab18.Service.CustomerService;
import com.example.lab18.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/details")
@RequiredArgsConstructor
public class DetailsController {

    private final DetailsService detailsService;

    @GetMapping("/get")
    public ResponseEntity getAllDetails(){

        return  ResponseEntity.status(200).body(detailsService.getAllDetails());
    }

    @PostMapping("/add")
    public ResponseEntity addDetails(@RequestBody @Valid DetailsDTO details){
        detailsService.addDetails(details);
        return ResponseEntity.status(200).body(new ApiResponse("Details added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDetails(@RequestBody @Valid DetailsDTO details, @PathVariable Integer id) {
        detailsService.updateDetails(details, id);
        return ResponseEntity.status(200).body(new ApiResponse("Details updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        detailsService.deleteDetails(id);
        return ResponseEntity.status(200).body(new ApiResponse("Details deleted"));
    }
}
