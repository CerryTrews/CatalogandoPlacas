import java.util.Scanner;

class Usuario {
    private Scanner input = new Scanner(System.in);

    public int inputI() {
        return input.nextInt();
    }

    public String inputS() {
        return input.nextLine().trim().toUpperCase();
    }
}
