package Estrutura;

import java.io.*;

public class Registro {
    private final String arquivoRegistro = "C:\\Users\\Cerry\\IdeaProjects\\CatalogandoPlacas\\src\\Estrutura\\Registro\\Reg.txt";
    private final Usuario user = new Usuario();

    public boolean verificaRegistroPlaca(String placa) {

        String registro, info;
        int ch;

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoRegistro))) {
            do {
                ch = leitor.read();
                if (ch == '#') {
                    registro = leitor.readLine();
                    if (placa.compareTo(registro) == 0) {
                        do {
                            info = leitor.readLine();
                            if (info != null) {
                                System.out.println(info);
                            }
                        }
                        while ((info != null) && (info.compareTo("") != 0));
                        return true;
                    }
                }
            }
            while (ch != -1);
        } catch (IOException exc) {
            System.out.println("Erro ao ler o arquivo de registro.");
            return false;
        }
        return false;
    }

    String getPlaca() {
        String topic = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insira a placa: ");

        try {
            topic = br.readLine().toUpperCase().trim();
        } catch (IOException exc) {
            System.out.println("Erro ao ler o arquivo.");
        }
        return topic;
    }

    void registraPlaca(String placa) {

        if(!verificaRegistroPlaca(placa)) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoRegistro, true))) {

                escritor.write("\n#" + placa + "\n");

                escritor.write("Placa: " + placa + "\n");

                System.out.print("Tipo de veículo: ");
                escritor.write("Tipo: " + user.inputS() + "\n");

                System.out.print("Marca: ");
                escritor.write("Marca: " + user.inputS() + "\n");

                System.out.print("Modelo: ");
                escritor.write("Modelo: " + user.inputS() + "\n");

                System.out.print("Cor: ");
                escritor.write("Cor: " + user.inputS() + "\n");

                System.out.print("Ano: ");
                escritor.write("Ano: " + user.inputS() + "\n");

            } catch (IOException exc) {
                System.out.println("Erro ao tentar escrever no arquivo Reg.txt.");
            }
        } else {
            System.out.println("A placa " + placa + " já possui registro.");
        }

    }
}

