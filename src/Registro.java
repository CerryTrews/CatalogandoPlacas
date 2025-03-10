import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Registro {

    void registraPlaca() {
        /*
        todo
            deverá marcar no banco de dados na placa como AAA-0000(registrada)
         */
    }

    void procuraPlaca(String padrao, String placaProcurada) {
        if (padrao.equals("Mercosul")) {
            String caminhoDoArquivo = "Banco de Dados/PlacasMercosul com inicial " + placaProcurada.charAt(0) + ".txt";

            try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo))) {
                String linha;

                while ((linha = leitor.readLine()) != null) {
                    if (linha.contains(placaProcurada)) {
                        System.out.println("Placa encontrada!");
                    }
                }
            } catch (IOException exc) {
                System.err.println("Erro ao ler o arquivo: " + caminhoDoArquivo);
                exc.printStackTrace();
            }
        }

        if (padrao.equals("Brasil")) {
            String caminhoDoArquivo = "Banco de Dados/PlacaBr com inicial " + placaProcurada.charAt(0) + ".txt";

            try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo))) {
                String linha;

                while ((linha = leitor.readLine()) != null) {
                    if (linha.contains(placaProcurada)) {
                        System.out.println("Placa encontrada!");}
                }
            } catch (IOException exc) {
                System.err.println("Erro ao ler o arquivo: " + caminhoDoArquivo);
                exc.printStackTrace();
            }
        }
    }
}
