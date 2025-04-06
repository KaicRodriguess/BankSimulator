import java.util.Scanner;

public class Bank {

    public double saldo;
    public String nomeUsuario;
    public String tipoConta;

    Scanner leitor = new Scanner(System.in);

    Bank(double saldoInicial, String nomeUsuario, String tipoConta)
    {
        this.saldo = saldoInicial;
        this.nomeUsuario = nomeUsuario;
        this.tipoConta = tipoConta;
    }

    public void interfaceBank()
    {
        String tela = """
                ************************************************
                
                Nome : %s
                
                Tipo de conta : %s
                
                Saldo : %.2f
                
                ************************************************
                """.formatted(nomeUsuario, tipoConta, saldo);
        System.out.println(tela);
    }

    public void menuBank()
    {
        while(opcao != 4)
        {
            String menu = """
                    Digite qual operação você deseja realizar :
                    
                    1 - Consultar saldo
                    2 - Receber transferência
                    3 - Transferência bancária
                    4 - Sair
                    
                    """;
            System.out.println(menu);
            int opcao = leitor.nextInt();
            switch (opcao)
            {
                case 1:
                    consultarSaldo();
                    break;

                case 2:
                    receberTransferencia();
                    break;

                case 3:
                    transferenciaaBancaria();
                    break;

                case 4:
                    System.out.println("Encerrando aplicativo...");
                    break;

                default:
                    System.out.println("Nenhuma opção inserida");
                    break;

            }
           if(opcao == 4)
           {
               break;
           }
        }
    }

    public void consultarSaldo()
    {
        System.out.println("Saldo atual : R$ " + saldo);
    }

    public void receberTransferencia()
    {
        System.out.println("Digite o valor a ser recebido");
        double valorTransferencia = leitor.nextDouble();

        if(valorTransferencia > 0) {
            saldo += valorTransferencia;
        }
        else{
            System.out.println("Não foi possível receber este valor, insira um valor válido");
        }
    }

    public void transferenciaaBancaria()
    {
        System.out.println("Digite o valor a ser transferido");
        double valorTransferencia = leitor.nextDouble();

        if(valorTransferencia > 0 && valorTransferencia <= saldo) {
            saldo -= valorTransferencia;
        }
        else{
            System.out.println("Não foi possível receber este valor, insira um valor válido");
        }
    }
}
