import java.io.*;

public class BancoDeDados {

    boolean verificaBD() {

        verificaRegFile();

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

    boolean verificaRegFile() {

        String pastaDoRegistro = "Registro";
        File pastaReg = new File(pastaDoRegistro);

        if(!(pastaReg.exists() || pastaReg.isDirectory())) {
            return false;
        } else {
            return true;
        }
    }

    void criaBD() {

        char l1, l2, l3, l4, l5, l6, l7;
        int n1, n2, n3, n4, n5, n6, n7;
        long contadorBR = 0, contadorMS = 0;

        if(verificaRegFile()) {
            criaRegFile();
        }

        String pastaDoBanco = "Banco de Dados";
        String caminhoDados = "Banco de Dados/";

        if(verificaBD()) {
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

    void criaRegFile() {
        String pastaReg = "Registro";
        String caminhoReg = "Registro/";

        File pasta = new File(pastaReg);

        if(!pasta.exists()) {
            boolean criada = pasta.mkdir();

            if(criada) {
                System.out.println("Pasta de registros foi criada!");
            } else {
                System.out.println("Falha ao criar pasta de registros.");
                return;
            }
        }

        String caminhoArquivoReg = pasta + "Reg.txt";

        if(caminhoArquivoReg.isEmpty()) {
            System.out.println("Criando arquivo de registros.");
            String nomeArquivo = caminhoReg + "Reg.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                writer.write("\n");
            } catch (IOException exc) {
                System.out.println("?Erro ao criar o arquivo?.");
                exc.printStackTrace();
            }
        }
    }

    boolean procuraPlaca(String placaProcurada) {

        String caminhoDoArquivo;

        if (placaProcurada.contains("-")) {
            caminhoDoArquivo = "Banco de Dados/Placas Brasil com inicial " + placaProcurada.charAt(0) + ".txt";
        } else {
            caminhoDoArquivo = "Banco de Dados/Placas Mercosul com inicial " + placaProcurada.charAt(0) + ".txt";
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.contains(placaProcurada)) {
                    System.out.println("Placa procurada: " + placaProcurada);
                    System.out.println("Arquivo: " + caminhoDoArquivo);
                    System.out.println("Linha: " + linha);
                    return true;
                }
            }
        } catch (IOException exc) {
            System.err.println("Erro ao ler o arquivo: " + caminhoDoArquivo);
            exc.printStackTrace();
        }
        System.out.println("Placa não encontrada.");
        return false;
    }
}