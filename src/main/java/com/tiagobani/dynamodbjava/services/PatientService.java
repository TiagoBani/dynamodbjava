package com.tiagobani.dynamodbjava.services;

import com.tiagobani.dynamodbjava.dtos.request.PostPatientRequest;
import com.tiagobani.dynamodbjava.dtos.request.QueryPatientRequest;
import com.tiagobani.dynamodbjava.dtos.response.PatientResponse;
import com.tiagobani.dynamodbjava.mappers.IPatientMapper;
import com.tiagobani.dynamodbjava.models.PatientModel;
import com.tiagobani.dynamodbjava.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public record PatientService(
        PatientRepository patientRepository,
        IPatientMapper patientMapper
) implements IPatientService {

    @Override
    public PatientResponse create(PostPatientRequest patient) {
        PatientModel model = patientMapper.map(patient);

        patientRepository.save(model);

        return patientMapper.map(model);
    }

    @Override
    public List<PatientResponse> findAll() {
        var patients = patientRepository.findAll();
        return StreamSupport.stream(patients.spliterator(), true).map(patientMapper::map).toList();
    }

    @Override
    public Optional<PatientResponse> findById(String id) {
        return patientRepository.findById(id).map(patientMapper::map);
    }

    @Override
    public List<PatientResponse> findByParams(QueryPatientRequest params) {
        if(params.hasAll()) {
            return patientRepository.findByNameAndCost(params.getName(), params.getCost())
                    .stream().map(patientMapper::map).toList();
        }

        if(params.hasCost()) {
            return patientMapper.map(patientRepository.findByCost(params.getCost()));
        }

        if(params.hasName()) {
            return patientRepository.findByName(params.getName()).stream().map(patientMapper::map).toList();
        }

        return findAll();
    }
}
