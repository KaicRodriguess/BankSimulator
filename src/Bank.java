import java.util.Scanner;

public class Bank{

    private double saldo = 0;
    private String nomeUsuario;
    private String tipoConta;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    Scanner leitor = new Scanner(System.in);

    public void interfaceBank()
    {
        String tela = """
                ************************************************
                
                Nome : %s
                
                Tipo de conta : %s
                
                Saldo : %.2f
                
                ************************************************
                """.formatted(getNomeUsuario(), getTipoConta(), getSaldo());
        System.out.println(tela);
    }

    public void menuBank()
    {
        int opcao = 0;
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
            opcao = leitor.nextInt();
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
                    break;
                default:
                    System.out.println("Nenhuma opção inserida");
                    break;

            }

        }
    }

    public void consultarSaldo()
    {
        System.out.println("Saldo atual : R$ " + getSaldo());
    }

    public void receberTransferencia()
    {
        System.out.println("Digite o valor a ser recebido");
        double valorTransferencia = leitor.nextDouble();

        if (!(valorTransferencia > 0)) {
            System.out.println("Não foi possível receber este valor, insira um valor válido");
        } else {
            setSaldo(valorTransferencia);
        }
    }

    public void transferenciaaBancaria()
    {
        System.out.println("Digite o valor a ser transferido");
        double valorTransferencia = leitor.nextDouble();

        if(valorTransferencia > 0 && valorTransferencia <= getSaldo()) {
             setSaldo(getSaldo()-valorTransferencia);
        }
        else{
            System.out.println("Não foi possível transferir este valor este valor, insira um valor válido");
        }
    }
}
