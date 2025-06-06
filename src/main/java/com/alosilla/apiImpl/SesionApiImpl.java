package com.alosilla.apiImpl;

import com.alosilla.api.SesionApi;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import com.alosilla.model.SesionRequest;
import com.alosilla.model.SesionResponse;
import com.alosilla.service.SesionService;

@RequestScoped
public class SesionApiImpl implements SesionApi {

    @Inject
    SesionService sesionService;


    @Override
    public Response generarSesion(SesionRequest request) {
        SesionResponse response = sesionService.generarSesion(request);
        return Response.ok(response).build();
    }
}