public class Placa {
    public static void main(String[] args) {

        CriaBancoDeDados criar = new CriaBancoDeDados();
        Registro bd = new Registro();

        criar.bancoDeDados();
        bd.procuraPlaca("Mercosul", "AAB0A00");
        bd.procuraPlaca("Brasil", "EYL-4251");
    }
}