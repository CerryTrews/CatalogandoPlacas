package Estrutura;

public class Esqueleto {
    private final BancoDeDados bd = new BancoDeDados();
    private final Registro reg = new Registro();
    private final Usuario user = new Usuario();


    public void chamaMenu() {

        System.out.println(" *** Insira o número da opção desejada: *** \n");
        System.out.println("    1. Verifica diretório do banco de dados.");
        System.out.println("    2. Cria banco de dados.");
        System.out.println("    3. Procurar placa.");
        System.out.println("    4. Verifica registro da placa.");
        System.out.println("    5. Registra uma placa.");
        System.out.println("    0. Finaliza o programa.\n");

        userEscolhe();
    }

    void userEscolhe() {
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
                if(!bd.verificaBD()) {
                    bd.criaBD();
                } else {
                    System.out.println("Banco de dados encontrado, cancelando.");
                }
                break;
            case 3:
                user.inputS();
                System.out.print("Insira a placa desejada (Ex. AAA-0000 ,aaa-0000 ou AAA0A00, aaa0a00): ");
                bd.procuraPlaca(user.inputS());
                break;
            case 4:
                String topic;
                user.inputS();
                topic = reg.getPlaca();
                if(!reg.verificaRegistroPlaca(topic)) {
                    System.out.println("");
                }
                break;
            case 5:
                user.inputS();
                System.out.println(" *** Registro de veículo *** ");
                System.out.print("Insira a placa que será registrada: ");
                reg.registraPlaca(user.inputS());
                break;
            default:
                System.out.println("opção inválida.\n");
                chamaMenu();
                break;
        }
    }
}
