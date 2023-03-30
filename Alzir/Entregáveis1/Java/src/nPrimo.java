import java.util.Scanner;

public class nPrimo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int num = input.nextInt();
        boolean primo = true;
        if (num < 2) {
            primo = false;
          } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
              if (num % i == 0) {
                primo = false;
                break;
              }
            }
          }
          if (primo) {
            System.out.println(num + " é primo.");
          } else {
            System.out.println(num + " não é primo.");
          }   
          input.close();
        }
    }