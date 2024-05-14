package com.tiagobani.dynamodbjava.mappers;

import com.tiagobani.dynamodbjava.dtos.request.PostPatientRequest;
import com.tiagobani.dynamodbjava.dtos.response.PatientResponse;
import com.tiagobani.dynamodbjava.models.PatientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPatientMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    PatientModel map(PostPatientRequest postPatientRequest);
    PatientResponse map(PatientModel patientModel);

    List<PatientResponse> map(List<PatientModel> patientModels);
}
