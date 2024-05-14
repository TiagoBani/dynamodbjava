package com.tiagobani.dynamodbjava.services;

import com.tiagobani.dynamodbjava.dtos.request.PostPatientRequest;
import com.tiagobani.dynamodbjava.dtos.request.QueryPatientRequest;
import com.tiagobani.dynamodbjava.dtos.response.PatientResponse;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    PatientResponse create(PostPatientRequest model);
    List<PatientResponse> findAll();
    Optional<PatientResponse> findById(String id);
    List<PatientResponse> findByParams(QueryPatientRequest params);
}
