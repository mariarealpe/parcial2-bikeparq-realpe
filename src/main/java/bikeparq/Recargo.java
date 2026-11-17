package bikeparq;

public final class Recargo {

    private static final int RECARGO_NOCTURNO = 2000;
    private static final int TARIFA_EN_GRACIA = 0;
    private static final int INICIO_NOCHE = 20;
    private static final int FIN_NOCHE = 5;
    private static final int HORA_MINIMA = 0;
    private static final int HORA_MAXIMA = 23;

    private Recargo() {
    }

    public static int aplicarRecargoNocturno(int tarifa, int horaEntrada) {
        validarHora(horaEntrada);
        boolean estuvoEnGracia = tarifa == TARIFA_EN_GRACIA;
        if (!estuvoEnGracia && esHorarioNocturno(horaEntrada)) {
            return tarifa + RECARGO_NOCTURNO;
        }
        return tarifa;
    }

    private static void validarHora(int horaEntrada) {
        if (horaEntrada < HORA_MINIMA || horaEntrada > HORA_MAXIMA) {
            throw new IllegalArgumentException("La hora de entrada debe estar entre 0 y 23");
        }
    }

    private static boolean esHorarioNocturno(int horaEntrada) {
        return horaEntrada >= INICIO_NOCHE || horaEntrada <= FIN_NOCHE;
    }
}
