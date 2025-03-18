public class Programa {
    BancoDeDados bd = new BancoDeDados();
    Registro reg = new Registro();
    Usuario user = new Usuario();


    void chamaMenu() {

        System.out.println(" *** Insira o número da opção desejada: *** \n");
        System.out.println("    1. Verifica diretório do banco de dados.");
        System.out.println("    2. Verifica diretório de registro.");
        System.out.println("    3. Cria banco de dados.");
        System.out.println("    4. Cria diretório de registros.");
        System.out.println("    5. Procurar placa.");
        System.out.println("    0. Finaliza o programa.\n");

        switch (user.inputI()) {
            case 0:
                System.out.println("Programa finalizado.");
                break;
            case 1:
                System.out.println("Procurando diretório do Banco de Dados...\n");
                bd.verificaBD();
                break;
            case 2:
                System.out.println("Procurando diretório de Registro...\n");
                reg.verificaRegistro();
                break;
            case 3:
                System.out.println("Criando Banco de Dados...\n");
                bd.criaBD();
                break;
            case 4:
                System.out.println("Criando diretório de Registros.");
                reg.criaDirRegistro();
                break;
            case 5:
                user.inputS();
                System.out.print("Insira a placa desejada (Ex. AAA-0000 ou AAA0A00): ");
                bd.procuraPlaca(user.inputS());
                break;
            default:
                System.out.println("opção inválida.\n");
                chamaMenu();
                break;
        }
    }
}
