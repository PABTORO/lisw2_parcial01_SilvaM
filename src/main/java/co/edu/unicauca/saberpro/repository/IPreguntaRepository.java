package co.edu.unicauca.saberpro.repository;

import java.util.List;

import co.edu.unicauca.saberpro.model.Pregunta;

public interface IPreguntaRepository {
    boolean guardar(Pregunta pregunta);
    List<Pregunta> listar();
    Pregunta buscarPorId(int id);
    boolean actualizar(Pregunta pregunta); 
}
