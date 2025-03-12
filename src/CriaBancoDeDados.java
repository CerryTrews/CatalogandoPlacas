import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriaBancoDeDados {
    char l1, l2, l3, ms1, ms2, ms3, ms4;
    int n1, n2, n3, n4, msn1, msn2, msn3;
    long contadorBR, contadorMS = 0;

    boolean bancoDeDadosJaExiste() {
        String pastaDoBanco = "Banco de Dados";
        File pasta = new File(pastaDoBanco);

        if(!pasta.exists() || !pasta.isDirectory()) {
            return false;
        }

        for(char letra = 'A'; letra <= 'Z'; letra++) {
            String nomeArquivoBR = pastaDoBanco + "/Placas Brasil com inicial " + letra + ".txt";
            File arquivoBR = new File(nomeArquivoBR);

            if(!arquivoBR.exists()) {
                return false;
            }
        }

        for(char letra = 'A'; letra <= 'Z'; letra++) {
            String nomeArquivoMS = pastaDoBanco + "/Placas Mercosul com inicial " + letra + ".txt";
            File arquivoMS = new File(nomeArquivoMS);

            if(!arquivoMS.exists()) {
                return false;
            }
        }
        return true;
    }

    void bancoDeDados() {

        String pastaDoBanco = "Banco de Dados";
        String caminhoDados = "Banco de Dados/";

        if(bancoDeDadosJaExiste()) {
            System.out.println("Banco de Dados já existe. Não é necessário criá-lo.");
            return;
        }

        File pasta = new File(pastaDoBanco);

        if(!pasta.exists()) {
            boolean criada = pasta.mkdir();

            if(criada) {
                System.out.println("Pasta do banco de dados foi criada!");
            } else {
                System.out.println("Falha ao criar a pasta do banco.");
                return;
            }
        }

        for (l1 = 'A'; l1 <= 'Z'; l1++) {
            System.out.println("Criando Placas Brasil com inicial " + l1 + ".txt");
            String nomeArquivo = caminhoDados + "Placas Brasil com inicial " + l1 + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (l2 = 'A'; l2 <= 'Z'; l2++) {
                    for (l3 = 'A'; l3 <= 'Z'; l3++) {
                        for (n1 = 0; n1 <= 9; n1++) {
                            for (n2 = 0; n2 <= 9; n2++) {
                                for (n3 = 0; n3 <= 9; n3++) {
                                    for (n4 = 0; n4 <= 9; n4++) {
                                        String placaBR = String.format("%c%c%c-%d%d%d%d", l1, l2, l3, n1, n2, n3, n4);
                                        writer.write(placaBR + "\t");
                                        if(contadorBR %5 == 0) {
                                            writer.newLine();
                                        }
                                        contadorBR++;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException exc) {
                System.out.println("Erro ao escrever no arquivo: " + nomeArquivo);
                exc.printStackTrace();
            }
            System.out.println("Banco de dados: Placas Brasil com inicial " + l1 + " criado!");
        }
        for (ms1 = 'A'; ms1 <= 'Z'; ms1++) {
            System.out.println("Criando Placas Mercosul com inicial " + ms1 + ".txt");
            String nomeArquivoMS = caminhoDados + "Placas Mercosul com inicial " + ms1 + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivoMS))) {
                for (ms2 = 'A'; ms2 <= 'Z'; ms2++) {
                    for (ms3 = 'A'; ms3 <= 'Z'; ms3++) {
                        for (msn1 = 0; msn1 <= 9; msn1++) {
                            for (ms4 = 'A'; ms4 <= 'Z'; ms4++) {
                                for (msn2 = 0; msn2 <= 9; msn2++) {
                                    for (msn3 = 0; msn3 <= 9; msn3++) {
                                        String placaMS = String.format("%c%c%c%d%c%d%d", ms1, ms2, ms3, msn1, ms4, msn2, msn3);
                                        writer.write(placaMS + "\t");
                                        if(contadorMS %5 == 0) {
                                            writer.newLine();
                                        }
                                        contadorMS++;
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
            System.out.println("Banco de dados: Placas Mercosul com inicial " + ms1 + " criado!");
        }
        System.out.println("Banco de dados criado!");
        System.out.println("Total de placas padrão BR criadas: " + contadorBR);
        System.out.println("Total de placas padrão Mercosul criadas; " + contadorMS);
        System.out.println("Total de placas criadas: " + (contadorMS + contadorBR));
    }
}