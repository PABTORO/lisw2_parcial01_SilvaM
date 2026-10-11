package co.edu.unicauca.saberpro.pipeline;

import co.edu.unicauca.saberpro.model.Pregunta;

public class FiltroOpciones implements IFiltroPregunta {
    @Override
    public boolean procesar(Pregunta pregunta) {
        if (pregunta == null || pregunta.getOpciones() == null) {
            return false;
        }
        // SE ENCONTRO EL ERROR EN LA PARTE
        //// ERROR INTENCIONAL 2: Lógica invertida en la validación de opciones (HU03)
// Debe ser exactamente 4 opciones para retornar true.
//if (pregunta.getOpciones().size() == 4) {
//return false; // BUG: Retorna false si tiene 4 opciones!

        //  CORRECCIÓN ERROR 2: lógica invertida. Debe ser exactamente 4 opciones para retornar true.Se devuelve la comparacion, si el tamaño es 4 devuelve positivo
        return pregunta.getOpciones().size() == 4;
    }
}
