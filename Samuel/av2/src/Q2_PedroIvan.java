import java.util.Scanner;

public class Q2_PedroIvan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de inteiros que deseja somar: ");
        int n = input.nextInt();
        
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Digite o " + i + "º inteiro: ");
            int num = input.nextInt();
            soma += num;
        }
        
        System.out.println("A soma dos " + n + " inteiros digitados é " + soma + ".");
        
        input.close();
    }
}