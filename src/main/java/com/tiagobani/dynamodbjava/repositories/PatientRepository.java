package com.tiagobani.dynamodbjava.repositories;

import com.tiagobani.dynamodbjava.models.PatientModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface PatientRepository extends CrudRepository<PatientModel, String> {
    Optional<PatientModel> findById(String id);
    Optional<PatientModel> findByName(String name);
    List<PatientModel> findByCost(String cost);
    Optional<PatientModel> findByNameAndCost(String name, String cost);
}
