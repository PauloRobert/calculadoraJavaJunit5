package br.com.automacao.runner;

import br.com.automacao.Calculadora;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    static Calculadora calculadora;

    //Calculadora myCalc = new Calculadora();

    @Test
    public void testaSomaMenosIngenuo() {
        Calculadora myCalc = new Calculadora();

        boolean temErro = false;
        if (myCalc.soma(2, 2) != 4) {
            temErro = true;
        }
        if (myCalc.soma(2, -2) != 0) {
            temErro = true;
        }
        if (myCalc.soma(-2, 2) != 0) {
            temErro = true;
        }
        if (myCalc.soma(-2, -2) != -4) {
            temErro = true;
        }
        if (myCalc.soma(0, 0) != 0) {
            temErro = true;
        }
        if (temErro) {
            fail("Houve um erro na validação da soma.");
        }
    }
    @Test
    public void deveResultarQuatroAoSomarDoisEDois() {
        // Calculadora calculadora = new Calculadora();
        assertEquals(4.0, calculadora.soma(2, 2));
    }

    @Test
    public void deveResultarZeroAoSomarDoisEMenosDois() {
        // Calculadora calculadora = new Calculadora();
        assertEquals(0.0, calculadora.soma(2, -2));
    }

    @BeforeAll
    public static void setup() {
        calculadora = new Calculadora();
    }
    // Outros: @BeforeEach, @AfterEach, @AfterAll

    @Disabled
    @DisplayName("Valida múltiplas somas com informações em CSV")
    @ParameterizedTest
    @CsvSource({ "1.0, 1.0, 2.0", "2.0, 3.0, 6.0" })
    void validaMultiplasSomasCSV(double parcela1, double parcela2, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.soma(parcela1, parcela2));
    }

    @DisplayName("Valida múltiplas somas com informações em arquivo CSV")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void validaMultiplasSomasArqCSV(double parcela1, double parcela2, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.soma(parcela1, parcela2));
    }

    @Test
    public void divisaoPorZeroGeraExcecao() {
        assertThrows(ArithmeticException.class, () -> {
            int resultado = calculadora.restoDivisaoInteira(4, 0);
            System.out.println(resultado);
        });
    }
}
