import java.io.*;

public class Registro {
    String arquivoRegistro;

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
                    System.out.println("Placa: " + registro);
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
        System.out.println("Placa " + placa + " não possui registro.");
        return false;
    }

    String getPlaca() {
        String topic = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insira a placa: ");

        try {
            topic = br.readLine().toUpperCase().trim();
        } catch (IOException exc) {
            System.out.println("Erro no console.");
        }
        return topic;
    }
}

