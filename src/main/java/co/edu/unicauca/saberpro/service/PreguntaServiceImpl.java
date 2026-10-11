package co.edu.unicauca.saberpro.service;

import java.util.List;

import co.edu.unicauca.saberpro.model.Pregunta;
import co.edu.unicauca.saberpro.pipeline.ValidadorPipeline;
import co.edu.unicauca.saberpro.repository.IPreguntaRepository;

public class PreguntaServiceImpl implements IPreguntaService {
    private final IPreguntaRepository repository;
    private final ValidadorPipeline pipeline;

    public PreguntaServiceImpl(IPreguntaRepository repository, ValidadorPipeline pipeline) {
        this.repository = repository;
        this.pipeline = pipeline;
    }
    // ERROR INTENCIONAL 3: Firma del método no coincide con la interfaz IPreguntaService
// La interfaz define 'registrarPregunta(Pregunta p)' pero aquí escribieron

//public boolean guardarPregunta(Pregunta pregunta) {
//if (pipeline.ejecutar(pregunta)) {
//return repository.guardar(pregunta);


    // CORRECCIÓN ERROR 3:se encontro el error en la linea 20 y Se corrigio el nombre acorde a la interfaz + @Override para no generar algun error de sintaxis
    @Override
    public boolean registrarPregunta(Pregunta pregunta) {
        if (pipeline.ejecutar(pregunta)) {
            boolean guardada = repository.guardar(pregunta);
            return guardada;
        }
        return false;
    }

    @Override
    public List<Pregunta> obtenerTodas() {
        return repository.listar();
    }

  

    @Override
    public boolean actualizarPregunta(Pregunta p) {
        if (p == null) {
            return false;
        }
        Pregunta existente = repository.buscarPorId(p.getId());
        if (existente == null) {
            System.out.println("No existe una pregunta con id " + p.getId());
            return false;
        }
        if (!"Borrador".equals(existente.getEstado())) {
            System.out.println("Actualización denegada: solo se pueden modificar preguntas en estado Borrador.");
            return false;
        }
        return repository.actualizar(p);
    }
}
