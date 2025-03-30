import java.io.*;

public class Registro {
    String arquivoRegistro;
    Usuario user = new Usuario();
    String tipo, modelo, cor, ano;

    Registro(String nomeArquivo) {
        arquivoRegistro = nomeArquivo;
    }


    boolean verificaRegistroPlaca(String placa) {

        String registro, info;
        int ch;

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoRegistro))) {
            do {
                ch = leitor.read();
                if (ch == '#') {
                    registro = leitor.readLine();
                    //System.out.println("Placa: " + registro);
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
            exc.printStackTrace();
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

        String nomeDoArquivo = "Registro\\Reg.txt";

        if(!verificaRegistroPlaca(placa)) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeDoArquivo, true))) {

                escritor.write("\n#" + placa + "\n");

                escritor.write("Placa: " + placa + "\n");

                System.out.print("Tipo de veículo: ");
                tipo = user.inputS();
                escritor.write("Tipo: " + tipo + "\n");

                System.out.print("Modelo: ");
                modelo = user.inputS();
                escritor.write("Modelo: " + modelo + "\n");

                System.out.print("Cor: ");
                cor = user.inputS();
                escritor.write("Cor: " + cor + "\n");

                System.out.print("Ano: ");
                ano = user.inputS();
                escritor.write("Ano: " + ano + "\n");

            } catch (IOException exc) {
                System.out.println("Erro ao tentar escrever no arquivo.");
                exc.printStackTrace();
            }
        } else {
            System.out.println("A placa " + placa + " já possui registro.");
        }

    }
}

