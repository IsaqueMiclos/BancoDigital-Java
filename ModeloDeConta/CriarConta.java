package ModeloDeConta;

//Jesus é o caminho, a verdade e a vida!!!
public class CriarConta {
    private String nome;
    private String cpf;
    private String senhaDaConta;
    private double saldo = 0.0;

    public CriarConta(String nome, String cpf, String senhaDaConta) {
        this.nome = nome;
        this.senhaDaConta = senhaDaConta;
        this.cpf = cpf;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depositando..." + " " + "O seu saldo atual é de " + this.saldo);
    }

    public void pagarConta(double valor) {
        this.saldo -= valor;
        System.out.println("Pagando..." + " " + "O seu saldo atual é de " + this.saldo);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getSenhaDaConta() {
        return this.senhaDaConta;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
