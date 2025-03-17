import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BancoDeDados {

    boolean verificaBD() {
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

    boolean verificaRegistro() {
        String pastaDoRegistro = "Registro";
        File pasta = new File(pastaDoRegistro);

        if(!pasta.exists() || !pasta.isDirectory()) {
            System.out.println("Diretório de registros não existe!");
            return false;
        }
        System.out.println("Diretório de registro existente.");
        return true;
    }

    void criaBD() {

        char l1, l2, l3, l4, l5, l6, l7;
        int n1, n2, n3, n4, n5, n6, n7;
        long contadorBR = 0, contadorMS = 0;

        String pastaDoBanco = "Banco de Dados";
        String caminhoDados = "Banco de Dados/";

        if(verificaBD()) {
            System.out.println("Banco de Dados encontrado.");
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
        for (l4 = 'A'; l4 <= 'Z'; l4++) {
            System.out.println("Criando Placas Mercosul com inicial " + l4 + ".txt");
            String nomeArquivoMS = caminhoDados + "Placas Mercosul com inicial " + l4 + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivoMS))) {
                for (l5 = 'A'; l5 <= 'Z'; l5++) {
                    for (l6 = 'A'; l6 <= 'Z'; l6++) {
                        for (n5 = 0; n5 <= 9; n5++) {
                            for (l7 = 'A'; l7 <= 'Z'; l7++) {
                                for (n6 = 0; n6 <= 9; n6++) {
                                    for (n7 = 0; n7 <= 9; n7++) {
                                        String placaMS = String.format("%c%c%c%d%c%d%d", l4, l5, l6, n5, l7, n6, n7);
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
            System.out.println("Banco de dados: Placas Mercosul com inicial " + l4 + " criado!");
        }
        System.out.println("Banco de dados criado!");
        System.out.println("Total de placas padrão BR criadas: " + contadorBR);
        System.out.println("Total de placas padrão Mercosul criadas; " + contadorMS);
        System.out.println("Total de placas criadas: " + (contadorMS + contadorBR));
    }

    void criaDirRegistro() {
        String pastaDoRegistro = "Registro";

        File pasta = new File(pastaDoRegistro);
        if(!verificaRegistro()) {
            pasta.mkdir();
        }

    }
}