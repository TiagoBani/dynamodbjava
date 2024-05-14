package com.tiagobani.dynamodbjava.dtos.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class QueryPatientRequest {

    private String name;
    private String cost;

    public boolean hasName(){
        return name != null && !name.isEmpty();
    }

    public boolean hasCost(){
        return cost != null && !cost.isEmpty();
    }

    public boolean hasAll(){
        return hasName() && hasCost();
    }
}
