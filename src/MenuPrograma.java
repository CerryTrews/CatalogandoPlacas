import java.util.Scanner;

public class MenuPrograma {
    BancoDeDados bd = new BancoDeDados();
    Registro registro = new Registro();
    Scanner input = new Scanner(System.in);

    void chamaMenu() {

            System.out.println(" *** Escolha a opção desejada: *** ");
            System.out.println();
            System.out.println("    1. Verifica diretório do banco de dados.");
            System.out.println("    2. Verifica diretório de registro.");
            System.out.println("    3. Cria banco de dados.");
            System.out.println("    4. Cria diretório de registros.");

            acaoUsuario();
    }

    void acaoUsuario() {

        int escolhaUsuario = input.nextInt();

        switch(escolhaUsuario) {
            case 0:
                System.out.println("Programa finalizado.");
                break;
            case 1:
                System.out.println("Procurando diretório do Banco de Dados...\n");
                bd.verificaBD();
                break;
            case 2:
                System.out.println("Procurando diretório de Registro...\n");
                bd.verificaRegistro();
                break;
            case 3:
                System.out.println("Criando Banco de Dados...\n");
                bd.criaBD();
                break;
            case 4:
                System.out.println("Criando diretório de Registros.");
                bd.criaDirRegistro();
                break;

            default:
                System.out.println("opção inválida.\n");
                chamaMenu();
                break;
        }
        input.close();
    }
}
