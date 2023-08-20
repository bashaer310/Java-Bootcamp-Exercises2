package com.example.lab18.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsDTO {
    private Integer customer_id;
    private String gender;
    private Integer age;
    private String email;
}
