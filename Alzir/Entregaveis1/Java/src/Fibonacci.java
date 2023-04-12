import java.util.Scanner;

public class Fibonacci {
   public static void main(String[] args) {
      int n, a = 0, b = 1, c;
      Scanner input = new Scanner(System.in);
      System.out.print("Informe o número de termos da sequência: ");
      n = input.nextInt();
      System.out.print("Sequência de Fibonacci até " + n + " termos: ");
      for(int i = 1; i <= n; i++) {
         System.out.print(a + " ");
         c = a + b;
         a = b;
         b = c;
      }
   }
}