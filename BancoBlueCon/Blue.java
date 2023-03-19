package BancoBlueCon;

import ModeloDeConta.ModeloDeConta;

public class Blue {
    //Jesus é o caminho, a verdade e a vida!!!

    private static ModeloDeConta[] contas = new ModeloDeConta[0];

    public ModeloDeConta criarConta(String nome, String cpf, String senha, String email) {
        if (nome == null || cpf == null || senha == null || email == null) {
            return new ModeloDeConta(null,null,null,null);
        }
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

    public ModeloDeConta[] getContas() {
        return Blue.contas;
    }
}
