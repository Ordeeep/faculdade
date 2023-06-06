import java.util.Scanner;

public class Q1_PedroIvan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o primeiro inteiro: ");
        int num1 = input.nextInt();
        
        System.out.print("Digite o segundo inteiro: ");
        int num2 = input.nextInt();
        
        int resultado = num1 + num2;
        System.out.println(resultado);
        input.close();
    }
}