import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Registro {

    boolean verificaRegistro() {
        String pastaDoRegistro = "Registro";
        File pasta = new File(pastaDoRegistro);

        if(!pasta.exists() || !pasta.isDirectory()) {
            System.out.println("Diretório de registros não existe!");
            return false;
        }
        System.out.println("Diretório de registro existente.");
        return true;
    }

    void criaDirRegistro() {
        String pastaDoRegistro = "Registro";

        File pasta = new File(pastaDoRegistro);
        if(!verificaRegistro()) {
            pasta.mkdir();
        }

    }
}
