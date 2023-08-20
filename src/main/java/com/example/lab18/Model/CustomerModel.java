package com.example.lab18.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerModel")
    @PrimaryKeyJoinColumn
    private DetailsModel detailsModel;
}
