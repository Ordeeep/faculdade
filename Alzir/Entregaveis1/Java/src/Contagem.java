public class Contagem {
    public static void main(String[] args) {
        int primeiro = 3;
        int n = 10;

        int[] conjunto = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        int count = 0;
        for (int i = 0; i < conjunto.length; i++) {
            if (conjunto[i] >= primeiro && conjunto[i] <= n) {
                count++;
            }
        }

        System.out.println("Existem " + count + " valores inteiros entre " + primeiro + " e " + n);
    }
}