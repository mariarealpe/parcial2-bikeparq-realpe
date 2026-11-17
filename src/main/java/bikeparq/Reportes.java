package bikeparq;

import java.util.List;

public final class Reportes {

    private static final String CARRO = "carro";
    private static final String MOTO = "moto";

    private Reportes() {
    }

    public static Resumen resumenDelDia(List<Registro> registros) {
        int totalRecaudado = 0;
        int cantidadCarros = 0;
        int cantidadMotos = 0;
        for (Registro registro : registros) {
            if (esDeTipo(registro, CARRO)) {
                cantidadCarros++;
            }
            if (esDeTipo(registro, MOTO)) {
                cantidadMotos++;
            }
            if (esVehiculoCobrable(registro)) {
                totalRecaudado += registro.valor();
            }
        }
        return new Resumen(totalRecaudado, cantidadCarros, cantidadMotos);
    }

    private static boolean esDeTipo(Registro registro, String tipo) {
        return tipo.equals(registro.tipo());
    }

    private static boolean esVehiculoCobrable(Registro registro) {
        return esDeTipo(registro, CARRO) || esDeTipo(registro, MOTO);
    }

    public static int mayorCobro(List<Registro> registros) {
        int mayorValor = 0;
        for (Registro registro : registros) {
            mayorValor = Math.max(mayorValor, registro.valor());
        }
        return mayorValor;
    }
}
