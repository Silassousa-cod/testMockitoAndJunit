import java.util.Scanner;

public class AtvFacul {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor da sua compra: ");
        int valorCompra = teclado.nextInt();
        System.out.println("Digite o valor que você irá pagar sua compra: ");
        int valorPagamento = teclado.nextInt();

        // Chamando funções
        verificacao(valorCompra, valorPagamento);
        premiacaoDesconto(valorCompra, valorPagamento);
        troco(valorCompra, valorPagamento);
    }

    // Criar uma função para verificar se o valor da compra é maior que o valor do pagamento
    static void verificacao(int valorCompra, int valorPagamento) {
        if (valorPagamento < valorCompra) {
            System.out.println("Pagamento Negado!");
        }
    }

    // Criar uma função para calcular o valor promocional de acordo com o valor de compra
    static void premiacaoDesconto(int valorCompra, int valorPagamento) {
        if (valorPagamento >= valorCompra && valorCompra % 2 == 0 && valorCompra % 3 != 0) {
            System.out.println("O valor promocional é: " + (valorCompra - valorCompra * 0.10));
        } else {
            System.out.println("O valor do pagamento é: " + valorCompra);
        }
    }

    // Criar uma função para calcular o troco e a quantidade de notas para devolver ao cliente
    static void troco(int valorCompra, int valorPagamento) {
        if (valorPagamento >= valorCompra && valorCompra % 2 == 0 && valorCompra % 3 != 0) {
            System.out.println("Troco: " + (valorPagamento - (valorCompra - valorCompra * 0.10)));
        } else if (valorPagamento < valorCompra) {
            System.out.println("Pagamento Negado!");
        } else {
            System.out.println("Troco: " + (valorPagamento - valorCompra));
        }
    }

}
