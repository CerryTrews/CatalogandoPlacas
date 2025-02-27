public class Placa {
    public static void main(String[] args) {

        char l1, l2, l3;
        int n1, n2, n3, n4;
        long contador = 0;

        for(l1 = 'A'; l1 <= 'Z'; l1++) {
            for(l2 = 'A'; l2 <= 'Z'; l2++) {
                for(l3 = 'A'; l3 <= 'Z'; l3++) {
                    for(n1 = 0; n1 <= 9; n1++) {
                        for(n2 = 0; n2 <= 9; n2++) {
                            for(n3 = 0; n3 <= 9; n3++) {
                                for(n4 = 0; n4 <= 9; n4++) {
                                    String letrasDaPlaca = String.valueOf(l1) +  String.valueOf(l2) + String.valueOf(l3);
                                    String numerosDaPlaca = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4);
                                    System.out.print(letrasDaPlaca + "-" + numerosDaPlaca + "\t");
                                    contador++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\nContador final é de: " + contador + " combinações para as placas veículares.");
    }
}
