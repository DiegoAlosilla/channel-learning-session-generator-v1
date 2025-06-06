package com.alosilla.service;


import com.alosilla.model.SesionRequest;
import com.alosilla.model.SesionResponse;

public interface SesionService {
    SesionResponse generarSesion(SesionRequest request);
}
