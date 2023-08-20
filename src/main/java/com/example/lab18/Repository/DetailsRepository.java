package com.example.lab18.Repository;


import com.example.lab18.Model.DetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<DetailsModel,Integer> {

    DetailsModel findDetailsModelById(Integer id);

}
