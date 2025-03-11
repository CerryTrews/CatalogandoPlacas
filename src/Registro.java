import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Registro {

    private static final String PADRAO_BRASIL = "Brasil";
    private static final String PADRAO_MERCOSUL = "Mercosul";

    void registraPlaca() {
        /*
        todo
            deverá marcar no banco de dados na placa como AAA-0000(registrada)
         */
    }

    boolean procuraPlaca(String padrao, String placaProcurada) {

        if(placaProcurada == null || placaProcurada.isEmpty()) {
            System.out.println("A placa procurada não pode ser nula ou vazia.");
            return false;
        }

        String caminhoDoArquivo;

        if (padrao.equals(PADRAO_MERCOSUL)) {
            caminhoDoArquivo = "Banco de Dados/Placas Mercosul com inicial " + placaProcurada.charAt(0) + ".txt";
        } else if (padrao.equals(PADRAO_BRASIL)) {
            caminhoDoArquivo = "Banco de Dados/Placas Brasil com inicial " + placaProcurada.charAt(0) + ".txt";
        } else {
            System.err.println("Padrão inválido. Use 'Mercosul' ou 'Brasil'.");
            return false;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.contains(placaProcurada)) {
                    System.out.println("Placa encontrada no arquivo: " + caminhoDoArquivo);
                    System.out.println("Placa encontrada na linha: " + linha);
                    return true;
                }
            }
        } catch (IOException exc) {
            System.err.println("Erro ao ler o arquivo: " + caminhoDoArquivo);
            exc.printStackTrace();
        }
        System.out.println("Placa não encontrada no arquivo: "  + caminhoDoArquivo);
        return false;
    }
}
