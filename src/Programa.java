public class Programa {
    private final BancoDeDados bd = new BancoDeDados();
    private final Registro reg = new Registro();
    private final Usuario user = new Usuario();


    void chamaMenu() {

        System.out.println(" *** Insira o número da opção desejada: *** \n");
        System.out.println("    1. Verifica diretório do banco de dados.");
        System.out.println("    2. Cria banco de dados.");
        System.out.println("    3. Procurar placa.");
        System.out.println("    0. Finaliza o programa.\n");

        switch (user.inputI()) {
            case 0:
                System.out.println("Programa finalizado.");
                break;
            case 1:
                System.out.println("Procurando dados do Banco de Dados...\n");
                if(bd.verificaBD()) {
                    System.out.println("Banco de dados encontrado.");
                } else {
                    System.out.println("Banco de dados não foi encontrado.");
                }
                break;
            case 2:
                System.out.println("Criando Banco de Dados...\n");
                bd.criaBD();
                if(bd.verificaBD()) {
                    System.out.println("Banco de dados encontrado, não é necessária a criação do mesmo.");
                }
                break;
            case 3:
                user.inputS();
                System.out.print("Insira a placa desejada (Ex. AAA-0000 ,aaa-0000 ou AAA0A00, aaa0a00): ");
                bd.procuraPlaca(user.inputS());
                break;
            default:
                System.out.println("opção inválida.\n");
                chamaMenu();
                break;
        }
    }
}
