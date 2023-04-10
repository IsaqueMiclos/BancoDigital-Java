package BancoBlueCon;

import ModeloDeConta.ModeloDeConta;

public class Blue {
    //Jesus é o caminho, a verdade e a vida!!!

    public static ModeloDeConta[] contas = new ModeloDeConta[1];

    public Blue() {
        contas[0] = new ModeloDeConta("ISAQUE DA SILVA MICLOS","08648408105","doc167167","isaque15miclos@gmail.com");
    }

    public boolean loginDeContas (String email, String senha) {
        boolean acesso = false;

        for (ModeloDeConta conta : Blue.contas) {
            if (email.equals(conta.getEmail()) && senha.equals(conta.getSenhaDaConta())) {
                acesso = true;
                break;
            }
        }
        return acesso;
    }

    public ModeloDeConta criarConta(String nome, String cpf, String senha, String email) {
        Blue.contas = adicionaContas(Blue.contas,new ModeloDeConta(nome,cpf,senha,email));
        return new ModeloDeConta(nome, cpf,senha,email);
    }

    private ModeloDeConta[] adicionaContas (ModeloDeConta[] contas, ModeloDeConta conta) {
        ModeloDeConta[] novoContas = new ModeloDeConta[contas.length + 1];

        if (contas.length > 0) {
            for (int i = 0; i < contas.length; i++) {
                novoContas[i] = contas[i];
            }
        }

        novoContas[novoContas.length - 1] = conta;
        return novoContas;
    }

    public void imprimeSaldo (int id) {
        ModeloDeConta contaDaPessoa = new ModeloDeConta();
        for (ModeloDeConta conta : contas) {
            if (conta.getId() == id) {
                contaDaPessoa = conta;
                break;
            }
        }
        System.out.println("Saldo atual: " + contaDaPessoa.getSaldo());
    }

    public ModeloDeConta[] getContas() {
        return Blue.contas;
    }
}
