import java.util.Scanner;

public class SomaConjuntoNumeros {
   public static void main(String[] args) {
      int n, soma = 0;
      Scanner input = new Scanner(System.in);
      System.out.print("Informe a quantidade de números: ");
      n = input.nextInt();
      int numeros[] = new int[n];
      System.out.println("Informe os números: ");
      for(int i = 0; i < n; i++) {
         numeros[i] = input.nextInt();
         soma += numeros[i];
      }
      System.out.println("A soma total é: " + soma);
   }
}