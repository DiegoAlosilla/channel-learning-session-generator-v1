package com.alosilla.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SesionRequest {
    private String docenteNombre;
    private String nivelEducativo;
    private String gradoEducativo;
    private String areaCurricular;
    private String temaPrincipalArea;
    private String contextoEspecificoTema;
    private String institucionEducativa;
    private int duracionEstimadaMinutos;
    private String competenciaCneb;
    private String capacidadesCneb;
    private String desempenioEspecifico;
    private String evidenciaDeAprendizaje;
    private String instrumentoDeEvaluacion;
    private String enfoquesTransversalesPrioritarios;
    private String observacionesAdicionales;
}