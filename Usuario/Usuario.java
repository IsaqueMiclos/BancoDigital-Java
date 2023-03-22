package Usuario;

import BancoBlueCon.Blue;
import ModeloDeConta.ModeloDeConta;

import java.util.Scanner;

public class Usuario {
    private ModeloDeConta modelo;
    private Scanner entrada = new Scanner(System.in);
    private final Blue banco = new Blue();

    {
        modelo = new ModeloDeConta("null","00000000000","00000000","xxxx@xxxx");
    }

    public void iniciar() {
        System.out.println("Olá bem-vindo(a), ao Blue!");
        this.sistemaDeLogin();
    }

    public void sistemaDeLogin () {
        System.out.println("Forma de login (LOGAR OU REGISTRAR)");
        System.out.println("Digite R para registrar e L para Login");

        char tipoDeLogin = entrada.nextLine().charAt(0);

        if (tipoDeLogin == 'L') {
            System.out.println("LOGIN AQUI!");
            System.out.println(tipoDeLogin);
        } else if (tipoDeLogin == 'R') {
            System.out.println("nome:");
            String nome = entrada.nextLine();

            System.out.println("email:");
            String email = entrada.nextLine();

            System.out.println("senha:");
            String senha = entrada.nextLine();

            System.out.println("cpf:");
            String cpf = entrada.nextLine();

            System.out.println("Seja bem-vindo " + nome + " ao seu banco Blue!");

            banco.criarConta(nome,cpf,senha,email);
        }
        else {
            System.out.println("[ERRO] VERIFIQUE AS INFORMAÇÕES!");
            System.out.println(tipoDeLogin);
        }
    }
}
