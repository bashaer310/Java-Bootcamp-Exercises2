package com.example.lab18.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Gender must not be empty")
    @Pattern(regexp = "m|f",message = "Gender must be m or f")
    @Column(columnDefinition = "varchar(1) not null check(gender='m' or gender='f')")
    private String gender;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid format")
    @Column(columnDefinition = "varchar(30) not null CHECK(email REGEXP '([a-zA-Z0-9]{6,})(@)([a-zA-Z]{6,})(\\.)([a-zA-Z]{2,})')")
    private String email;

    @NotNull(message = "Age must not be empty")
    @Positive
    @Column(columnDefinition = "int UNSIGNED not null")
    private Integer age;

    @OneToOne
    @MapsId
    @JsonIgnore
    private CustomerModel customerModel;
}
