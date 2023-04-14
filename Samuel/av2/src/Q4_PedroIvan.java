import java.util.Scanner;

public class Q4_PedroIvan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite uma palavra: ");
        String str = input.nextLine();
        String[] tokens = str.split(" ");
        for (String token : tokens) {
            if (token.toLowerCase().startsWith("s")) {
                System.out.println(token);
            }else{
              System.out.print("Não foi digitado nenhuma palavra começando com s");
            }
        }
        input.close();
    }
}