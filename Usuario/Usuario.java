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
            System.out.println("Bem-vindo de volta!");
            System.out.println("------ LOGIN --------");
            System.out.println("Email: ");
            String emailDeLogin = entrada.nextLine();
            System.out.println("Senha: ");
            String senhaDeLogin = entrada.nextLine();
            while (emailDeLogin.length() < 8 || senhaDeLogin.length() < 8) {
                System.out.println("[ERRO] Faltando informações!");
                System.out.println("Digite novamente");

                System.out.println("Email: ");
                emailDeLogin = entrada.nextLine();
                System.out.println("Senha: ");
                senhaDeLogin = entrada.nextLine();

                boolean login = banco.loginDeContas(emailDeLogin,senhaDeLogin);
                if (login == false) {
                    System.out.println("Senha ou email inválidos, tente novamente");
                    login = banco.loginDeContas(emailDeLogin,senhaDeLogin);
                } else {
                    System.out.println("bem-vindo de volta ");
                }
            }


        } else if (tipoDeLogin == 'R') {
            System.out.println("nome Completo:");
            String nome = entrada.nextLine();
            while (nome == null || nome == " " || nome.length() < 16) {
                System.out.println("[ERRO] Nome vazio ou pequeno");
                System.out.println("Digite novamente");
                nome = entrada.nextLine();
            }

            System.out.println("email:");
            String email = entrada.nextLine();
            while (email == null || email == " " || email.length() < 8) {
                System.out.println("[ERRO] Email vazio ou pequeno");
                System.out.println("Digite novamente");
                email = entrada.nextLine();
            }

            System.out.println("senha:");
            String senha = entrada.nextLine();
            while (senha == null || senha == " " || senha.length() < 8) {
                System.out.println("[ERRO] Senha vazia ou pequena, favor criar uma senha de 8 dígitos");
                System.out.println("Digite novamente");
                senha = entrada.nextLine();
            }

            System.out.println("cpf:");
            String cpf = entrada.nextLine();
            while (cpf == null || cpf == " " || cpf.length() < 11 || cpf.length() > 11) {
                System.out.println("[ERRO] Cpf vazio ou faltando informações");
                System.out.println("Digite novamente");
                cpf = entrada.nextLine();
            }

            System.out.println("Seja bem-vindo " + nome + " ao seu banco Blue!");

            banco.criarConta(nome,cpf,senha,email);
        }
        else {
            System.out.println("[ERRO] VERIFIQUE AS INFORMAÇÕES!");
            System.out.println(tipoDeLogin);
        }
    }
}
