package bikeparq;

public final class Recargo {

    private static final int RECARGO_NOCTURNO = 2000;
    private static final int INICIO_NOCHE = 20;
    private static final int FIN_NOCHE = 5;

    private Recargo() {
    }

    public static int aplicarRecargoNocturno(int tarifa, int horaEntrada) {
        if (horaEntrada < 0 || horaEntrada > 23) {
            throw new IllegalArgumentException("La hora de entrada debe estar entre 0 y 23");
        }
        if (tarifa != 0 && esHorarioNocturno(horaEntrada)) {
            return tarifa + RECARGO_NOCTURNO;
        }
        return tarifa;
    }

    private static boolean esHorarioNocturno(int horaEntrada) {
        return horaEntrada >= INICIO_NOCHE || horaEntrada <= FIN_NOCHE;
    }
}
