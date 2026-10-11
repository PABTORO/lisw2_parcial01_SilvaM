package co.edu.unicauca.saberpro.model;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private int id;
    private String enunciado;
    private List<String> opciones; // Debe contener 4 opciones
    private String respuestaCorrecta;
    private String estado; // "Borrador", "Publicada"
    

    public Pregunta(int id, String enunciado, List<String> opciones, String respuestaCorrecta, String estado) {
        this.id = id;
        this.enunciado = enunciado;
        // ERROR INTENCIONAL 1: Si opciones llega nulo o vacío, debe garantizarse la
//inicialización
//this.opciones = opciones;
        // CORRECCIÓN ERROR 1: Se encontro la correccion en laa linea 19 y se garantizo la inicializacion aunque los valores de opciones sean null o vacio se garantiza la inicialización si opciones es nulo o vacío
        this.opciones = (opciones == null || opciones.isEmpty())
                ? new ArrayList<>()
                : new ArrayList<>(opciones);
        this.respuestaCorrecta = respuestaCorrecta;
        this.estado = estado;
    }

   

    public int getId() { return id; }
    public String getEnunciado() { return enunciado; }
    public List<String> getOpciones() { return opciones; }
    public String getRespuestaCorrecta() { return respuestaCorrecta; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
   
}
