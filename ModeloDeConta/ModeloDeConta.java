package ModeloDeConta;

//Jesus é o caminho, a verdade e a vida!!!
public class ModeloDeConta {
    private String nome;
    private String cpf;
    private String senhaDaConta;

    private String email;

    private double saldo = 0.0;

    public static int id = 100;

    public ModeloDeConta(){

    }

    public ModeloDeConta(String nome, String cpf, String senhaDaConta, String email) {
        this.nome = nome;
        this.senhaDaConta = senhaDaConta;
        this.cpf = cpf;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenhaDaConta() {
        return senhaDaConta;
    }

    public void setSenhaDaConta(String senhaDaConta) {
        this.senhaDaConta = senhaDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
