import java.util.Scanner;

public class Q3_PedroIvan {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Digite a quantidade de números: ");
    int n = input.nextInt();
    
    int soma = 0;
    for (int i = 1; i <= n; i++) {
        System.out.print("Digite o número " + i + ": ");
        int num = input.nextInt();
        soma += num;
    }
    soma = soma + n;
    System.out.println("a soma da quantidades dos numeros mais os numeros digitados são: "+soma);
    
    input.close();
}
}