package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RecargoTest {

    @Test
    void entradaDeNocheSumaRecargoDe2000() {
        assertEquals(5000, Recargo.aplicarRecargoNocturno(3000, 22));
    }
}
