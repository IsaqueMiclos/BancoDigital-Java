package BancoBlueCon;

import ModeloDeConta.CriarConta;

public class Blue {
    //Jesus é o caminho, a verdade e a vida!!!

    private CriarConta[] contas;

    public void imprime() {
        System.out.println("------- Contas -------");
        for (CriarConta conta : contas) {
            System.out.println("Nome: " + conta.getNome());
            System.out.println("Cpf: " + conta.getCpf());
            System.out.println("Senha: " + conta.getSenhaDaConta());
            System.out.println("Saldo Atual: " + conta.getSaldo());
            System.out.println("----------------");
        }
    }

    public CriarConta[] getContas() {
        return contas;
    }

    public void setContas(CriarConta[] contas) {
        this.contas = contas;
    }
}
