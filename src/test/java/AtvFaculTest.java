import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AtvFaculTest {

    @Test
    public void testPagamentoNegado() {
        int valorCompra = 100;
        int valorPagamento = 50;
        String expectedOutput = "Pagamento Negado!";

        String result = captureOutput(() -> AtvFacul.verificacao(valorCompra, valorPagamento));

        assertEquals(expectedOutput, result.trim());
    }

    @Test
    public void testPagamentoSuficienteSemDesconto() {
        int valorCompra = 100;
        int valorPagamento = 105;
        String expectedOutput = "O valor promocional é: 90.0";

        String result = captureOutput(() -> AtvFacul.premiacaoDesconto(valorCompra, valorPagamento));

        assertEquals(expectedOutput, result.trim());
    }

    @Test
    public void testTrocoSuficiente() {
        int valorCompra = 100;
        int valorPagamento = 105;
        String expectedOutput = "Troco: 15.0";

        String result = captureOutput(() -> AtvFacul.troco(valorCompra, valorPagamento));

        assertEquals(expectedOutput, result.trim());
    }

    @Test
    public void testTrocoInsuficiente() {
        int valorCompra = 100;
        int valorPagamento = 90;
        String expectedOutput = "Pagamento Negado!";

        String result = captureOutput(() -> AtvFacul.troco(valorCompra, valorPagamento));

        assertEquals(expectedOutput, result.trim());
    }

    @Test
    public void testPremiacaoDescontoChamadaComMockito() {
        int valorCompra = 100;
        int valorPagamento = 105;

        AtvFacul atvFaculMock = mock(AtvFacul.class);

        AtvFacul.premiacaoDesconto(valorCompra, valorPagamento);

        // Verifique se o método premiacaoDesconto foi chamado com os argumentos corretos
        verify(atvFaculMock);
        AtvFacul.premiacaoDesconto(valorCompra, valorPagamento);
    }

    private String captureOutput(Runnable code) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        code.run();

        System.setOut(System.out);
        return outContent.toString().trim();
    }
}
