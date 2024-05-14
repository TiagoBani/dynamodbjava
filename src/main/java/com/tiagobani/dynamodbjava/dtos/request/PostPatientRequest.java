package com.tiagobani.dynamodbjava.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record PostPatientRequest(
        @NotBlank String name,
        @NotBlank String cost
) {
}
