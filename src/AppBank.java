import java.util.Scanner;

public class AppBank {

        public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o nome de usuário");
        String nome = ler.nextLine();
        System.out.println("Digite o tipo de conta");
        String conta = ler.nextLine();

        Bank userBank = new Bank();

        userBank.setSaldo(0);
        userBank.setNomeUsuario(nome);
        userBank.setTipoConta(conta);

        userBank.interfaceBank();
        userBank.menuBank();

    }
}
