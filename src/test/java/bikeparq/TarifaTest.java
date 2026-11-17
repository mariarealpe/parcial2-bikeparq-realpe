package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TarifaTest {

    @Test
    void cp01CarroQuePermaneceUnaHoraPaga3000() {
        assertEquals(3000, Tarifa.calcularTarifa(60, "carro"));
    }

    @Test
    void cp02MotoEnElUltimoMinutoDeGraciaNoPaga() {
        assertEquals(0, Tarifa.calcularTarifa(10, "moto"));
    }

    @Test
    void cp03TipoDeVehiculoInvalidoLanzaError() {
        assertThrows(IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(60, "bicicleta"));
    }

    @Test
    void minutosNegativosLanzanError() {
        assertThrows(IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(-1, "carro"));
    }

    @Test
    void minutosMayoresA1440LanzanError() {
        assertThrows(IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(1441, "moto"));
    }

    @Test
    void carroNuncaPagaMasDelTopeDiario() {
        assertEquals(25_000, Tarifa.calcularTarifa(1440, "carro"));
    }
}
