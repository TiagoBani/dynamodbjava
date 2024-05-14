package com.tiagobani.dynamodbjava.dtos.response;

public record PatientResponse(
        String id,
        String name,
        String cost
) {
}
