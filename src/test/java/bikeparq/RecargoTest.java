package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RecargoTest {

    @Test
    void entradaDeNocheSumaRecargoDe2000() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 22));
    }

    @Test
    void entradaDeDiaNoCambiaLaTarifa() {
        assertEquals(3000, Recargo.aplicarRecargoNocturno(3000, 10));
    }

    @Test
    void tarifaCeroDeNocheNoTieneRecargo() {
        assertEquals(0, Recargo.aplicarRecargoNocturno(0, 23));
    }

    @Test
    void horaFueraDeRangoLanzaError() {
        assertThrows(IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, 24));
    }

    @Test
    void horaNegativaLanzaError() {
        assertThrows(IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, -1));
    }

    @Test
    void limiteALas20EmpiezaLaNoche() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 20));
    }

    @Test
    void limiteALas19TodaviaEsDeDia() {
        assertEquals(3000, Recargo.aplicarRecargoNocturno(3000, 19));
    }

    @Test
    void limiteALas5TodaviaEsDeNoche() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 5));
    }

    @Test
    void limiteALas6EmpiezaElDia() {
        assertEquals(3000, Recargo.aplicarRecargoNocturno(3000, 6));
    }
}
