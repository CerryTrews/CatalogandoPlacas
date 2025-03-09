import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Placa {
    public static void main(String[] args) {

        char l1, l2, l3;
        int n1, n2, n3, n4;
        char ms1, ms2, ms3, ms4;
        int msn1, msn2, msn3;
        long contadorBR = 0;
        long contadorMS = 0;

        /*
        -todo
            - função para criar um arquivo com try, e dar nome ao arquivo
            - função que escreve no arquivo
            - função que fecha o arquivo
         */

        for (l1 = 'A'; l1 <= 'Z'; l1++) {
            String nomeArquivo = "PlacaBr com inicial " + l1 + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (l2 = 'A'; l2 <= 'Z'; l2++) {
                    for (l3 = 'A'; l3 <= 'Z'; l3++) {
                        for (n1 = 0; n1 <= 9; n1++) {
                            for (n2 = 0; n2 <= 9; n2++) {
                                for (n3 = 0; n3 <= 9; n3++) {
                                    for (n4 = 0; n4 <= 9; n4++) {
                                        String placaBR = String.format("%c%c%c-%d%d%d%d", l1, l2, l3, n1, n2, n3, n4);
                                        //System.out.print(placaBR + "\t");
                                        writer.write(placaBR + "\t");
                                        contadorBR++;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException exc) {
                    System.out.println("Erro ao escrever lno arquivo: " + nomeArquivo);
                    exc.printStackTrace();
            }
        }
        String nomeArquivoMS = "PlacasMercosul.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivoMS))) {
            for (ms1 = 'A'; ms1 <= 'Z'; ms1++) {
                for (ms2 = 'A'; ms2 <= 'Z'; ms2++) {
                    for (ms3 = 'A'; ms3 <= 'Z'; ms3++) {
                        for (msn1 = 0; msn1 <= 9; msn1++) {
                            for (ms4 = 'A'; ms4 <= 'Z'; ms4++) {
                                for (msn2 = 0; msn2 <= 9; msn2++) {
                                    for (msn3 = 0; msn3 <= 9; msn3++) {
                                        String placaMS = String.format("%c%c%c%d%c%d%d", ms1, ms2, ms3, msn1, ms4, msn2, msn3);
                                        writer.write(placaMS + "\t");
                                        contadorMS++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + nomeArquivoMS);
            e.printStackTrace();
        }

        System.out.println("Contador final é de: " + contadorBR + " combinações para as placas padrão BR.");
        System.out.println("Contador final é de: " + contadorMS + " combinações para as placas padrão Mercosul.");
        System.out.println("Total de combinações possíveis entre placas padrão BR e Mercosul é de " + (contadorBR + contadorMS));
    }
}