package com.alosilla.builder;

import com.alosilla.model.SesionResponse;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SesionBuilder {

    public SesionResponse buildResponse(String contenido) {
        return new SesionResponse(contenido);
    }
}