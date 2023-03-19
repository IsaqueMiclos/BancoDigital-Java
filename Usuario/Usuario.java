package Usuario;

import BancoBlueCon.Blue;
import ModeloDeConta.ModeloDeConta;

public class Usuario {
    private ModeloDeConta modelo;
    private final Blue banco = new Blue();

    {
        modelo = new ModeloDeConta("null","00000000000","00000000","xxxx@xxxx");
    }

    public void iniciar() {
        System.out.println("Olá bem-vindo(a), ao Blue!");
        banco.criarConta("ISaque","222","99999","aa@gmail.com");
    }
}
