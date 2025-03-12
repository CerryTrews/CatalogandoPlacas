public class Placa {
    public static void main(String[] args) {

        CriaBancoDeDados criar = new CriaBancoDeDados();
        Registro bd = new Registro();

        criar.bancoDeDados();
        bd.procuraPlaca("Mercosul", "ABC0A00");
        bd.procuraPlaca("Brasil", "ABC-1234");
        bd.procuraPlaca("Mercosul", "ABC-1234");
        bd.procuraPlaca("Brasil", "ACD2B90");
    }
}
