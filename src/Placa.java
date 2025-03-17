public class Placa {
    public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        MenuPrograma programa = new MenuPrograma();
        Registro registro = new Registro();

        //bd.criaBD();

        //registro.procuraPlaca("Brasil", "EYL-4251");

        // bd.registroExiste();
        programa.chamaMenu();
    }
}
