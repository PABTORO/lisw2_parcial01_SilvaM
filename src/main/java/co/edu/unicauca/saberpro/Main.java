package co.edu.unicauca.saberpro;

import java.util.Arrays;

import co.edu.unicauca.saberpro.model.Pregunta;
import co.edu.unicauca.saberpro.pipeline.FiltroEnunciado;
import co.edu.unicauca.saberpro.pipeline.FiltroOpciones;
import co.edu.unicauca.saberpro.pipeline.ValidadorPipeline;
import co.edu.unicauca.saberpro.repository.IPreguntaRepository;
import co.edu.unicauca.saberpro.repository.PreguntaRepositoryImpl;
import co.edu.unicauca.saberpro.service.IPreguntaService;
import co.edu.unicauca.saberpro.service.PreguntaServiceImpl;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== BANCO DE PREGUNTAS SABER PRO ===");

        // Configuración de dependencias (DIP)
        IPreguntaRepository repository = new PreguntaRepositoryImpl();

        ValidadorPipeline pipeline = new ValidadorPipeline();
        pipeline.addFiltro(new FiltroEnunciado());
        pipeline.addFiltro(new FiltroOpciones());

        // Inyección del repository y pipeline
        IPreguntaService service =
                new PreguntaServiceImpl(repository, pipeline);

        // Crear pregunta
        Pregunta p1 = new Pregunta(
                1,
                "¿Cuál es el objetivo principal del patrón Pipes and Filters?",
                Arrays.asList(
                        "A. Dividir proceso en etapas",
                        "B. Crear BD",
                        "C. Usar MVC",
                        "D. Ninguna"
                ),
                "A. Dividir proceso en etapas",
                "Borrador"
        );

        // ==========================
        // REGISTRAR PREGUNTA
        // ==========================

        boolean exito = service.registrarPregunta(p1);

        if (exito) {
            System.out.println(
                "Pregunta registrada con éxito. Total en banco: "
                + service.obtenerTodas().size()
            );
        } else {
            System.out.println(
                "No se pudo registrar la pregunta debido a fallos en el pipeline."
            );
        }

        // ==========================
        // ACTUALIZAR PREGUNTA
        // ==========================

        System.out.println("\n=== ACTUALIZAR PREGUNTA ===");

        // Creamos una versión modificada de la pregunta
        Pregunta preguntaActualizada = new Pregunta(
                1,
                "¿Cuál es el objetivo principal del patrón Pipes and Filters en software?",
                Arrays.asList(
                        "A. Dividir un proceso en etapas",
                        "B. Crear una base de datos",
                        "C. Implementar MVC",
                        "D. Ninguna de las anteriores"
                ),
                "A. Dividir un proceso en etapas",
                "Borrador"
        );

        boolean actualizada = service.actualizarPregunta(preguntaActualizada);
        Pregunta existente = repository.buscarPorId(preguntaActualizada.getId());
System.out.println("DEBUG estado existente: [" + existente.getEstado() + "]");

        if (actualizada) {
            System.out.println("Pregunta actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar la pregunta.");
        }

 
      
    }
}
