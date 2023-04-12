import java.util.Scanner;

public class mdc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor de A: ");
        int a = input.nextInt();
        System.out.println("Digite o valor de B: ");
        int b = input.nextInt();
        int mdc = calcularMDC(a, b);
        System.out.println("O MDC de " + a + " e " + b + " é " + mdc);
    }
    public static int calcularMDC(int a, int b) {
        int resto;
        
        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        
        return a;
    }
}