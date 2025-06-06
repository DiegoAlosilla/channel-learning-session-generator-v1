package com.alosilla.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.alosilla.model.SesionRequest;

@Path("/sesion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SesionApi {

    @POST
    Response generarSesion(SesionRequest request);
}