package com.alosilla.service;

import com.alosilla.builder.SesionBuilder;
import com.alosilla.dao.SesionDao;
import com.alosilla.model.SesionRequest;
import com.alosilla.model.SesionResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SesionServiceImpl implements SesionService {

    private final SesionDao sesionDao;
    private final SesionBuilder sesionBuilder;

    @Inject
    public SesionServiceImpl(SesionDao sesionDao, SesionBuilder sesionBuilder) {
        this.sesionDao = sesionDao;
        this.sesionBuilder = sesionBuilder;
    }

    @Override
    public SesionResponse generarSesion(SesionRequest request) {
        String contenidoGenerado = sesionDao.generarContenido(request,true);
        return sesionBuilder.buildResponse(contenidoGenerado);
    }
}