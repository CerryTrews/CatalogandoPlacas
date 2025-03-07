import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Placa {
    public static void main(String[] args) {

        char l1, l2, l3;
        int n1, n2, n3, n4;
        char ms1, ms2, ms3, ms4;
        int msn1, msn2, msn3;
        long contadorBR = 0;
        long contadorMS = 0;
        String caminhoArquivo = "Placas.txt";

        try {

            File arquivo = new File(caminhoArquivo);
            if(arquivo.createNewFile()) {
                System.out.println("Arquivo criado: " + arquivo.getName());
            } else {
                System.out.println("Arquivo já existe.");
            }

            FileWriter escritor = new FileWriter(arquivo);
            BufferedWriter bufferEscrita = new BufferedWriter(escritor);

            bufferEscrita.write("Placa do modelo padrão Brasileiro:");
            bufferEscrita.newLine();

            for (l1 = 'A'; l1 <= 'Z'; l1++) {
                for (l2 = 'A'; l2 <= 'Z'; l2++) {
                    for (l3 = 'A'; l3 <= 'Z'; l3++) {
                        for (n1 = 0; n1 <= 9; n1++) {
                            for (n2 = 0; n2 <= 9; n2++) {
                                for (n3 = 0; n3 <= 9; n3++) {
                                    for (n4 = 0; n4 <= 9; n4++) {
                                        String placaBR = String.valueOf(l1) + String.valueOf(l2) + String.valueOf(l3) + "-" +
                                                String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4);
                                        //System.out.print(placaBR + "\t");
                                        bufferEscrita.write(placaBR + "\t");
                                        contadorBR++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("\nContador final é de: " + contadorBR + " combinações para as placas padrão BR.");

            bufferEscrita.write("Placa do modelo padrão Brasileiro:");
            bufferEscrita.newLine();

            for (ms1 = 'A'; ms1 <= 'Z'; ms1++) {
                for (ms2 = 'A'; ms2 <= 'Z'; ms2++) {
                    for (ms3 = 'A'; ms3 <= 'Z'; ms3++) {
                        for (msn1 = 0; msn1 <= 9; msn1++) {
                            for (ms4 = 'A'; ms4 <= 'Z'; ms4++) {
                                for (msn2 = 0; msn2 <= 9; msn2++) {
                                    for (msn3 = 0; msn3 <= 9; msn3++) {
                                        String placaMS = String.valueOf(ms1) + String.valueOf(ms2) + String.valueOf(ms3) +
                                                String.valueOf(msn1) + String.valueOf(ms4) + String.valueOf(msn2) +
                                                String.valueOf(msn3);
                                    /*
                                    System.out.print(placa + "\t");

                                     */
                                        bufferEscrita.write(placaMS + "\t");
                                        contadorMS++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            bufferEscrita.close();
            System.out.println("Dados escritos no arquivo com sucesso!");

        } catch(IOException exc ) {
            System.out.println("Ocorreu um erro!");
            exc.printStackTrace();
        }

        System.out.println("\nContador final é de: " + contadorMS + " combinações para as placas padrão Mercosul.");
        System.out.println();
        System.out.println("Total de combinações possíveis entre placas padrão BR(" + contadorBR + ") e Mercosul(" + contadorMS + ") é de " + contadorBR + contadorMS);
    }
}
