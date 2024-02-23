/* CLASE: Comprobar                             Version 0.0.1

    Métodos:
            boolean esEnteroPositivo (String)   Comprueba entero positivo o cero
                                                con control de errores
                                                try { ... } catch (Exception e) { ... }
                                                Ojo captura cualquier tipo de excepción
 */

package reacumula;

public class Comprobar {
                                        // Comprueba entero positivo o cero ------------
    public boolean esEnteroPositivo(String tt) {

        boolean correcto = false;
        int n;

        try {
            n = Integer.parseInt(tt);
        }         //Control de errores
        catch (Exception e) {
            return false;
        }

        if (n >= 0) {
            correcto = true;
        }

        return correcto;
    }

}
