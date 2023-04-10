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

    public void iniciar () {
        System.out.println("Olá bem-vindo(a), ao Blue!");
        System.out.println("Forma de login (LOGAR OU REGISTRAR)");
        System.out.println("Digite R para registrar e L para Login");

        char tipoDeLogin = entrada.nextLine().charAt(0);

        while (tipoDeLogin != 'L' && tipoDeLogin != 'R' && tipoDeLogin != 'l' && tipoDeLogin != 'r'){
            System.out.println("[ERRO] VERIFIQUE AS INFORMAÇÕES!");
            tipoDeLogin = entrada.nextLine().charAt(0);
        }

        if (tipoDeLogin == 'L' || tipoDeLogin == 'l') {
            System.out.println("Bem-vindo de volta!");
            System.out.println("------ LOGIN --------");
            this.login();
        } else {
            System.out.println("Olá Seja bem-vindo novo usuário!");
            this.registrar();
        }
    }

    private void login () {
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
        }

        boolean login = banco.loginDeContas(emailDeLogin,senhaDeLogin);
        int contador = 1;

        while (!login) {
            contador++;
            System.out.println("Senha ou email inválidos, tente novamente");

            System.out.println("Email: ");
            emailDeLogin = entrada.nextLine();
            System.out.println("Senha: ");
            senhaDeLogin = entrada.nextLine();

            login = banco.loginDeContas(emailDeLogin,senhaDeLogin);

            if (contador == 3) {
                System.out.println("Deseja se registrar");
                String resposta = entrada.nextLine();
                if (resposta.equals("SIM")) {
                    this.registrar();
                    break;
                } else {
                    contador = 1;
                }
            }
        }

        if (contador == 3) {
            return;
        }

        ModeloDeConta contaDoLogado = new ModeloDeConta();

        for (ModeloDeConta conta : Blue.contas) {
            if (conta.getEmail().equals(emailDeLogin)) {
                contaDoLogado = conta;
                break;
            }
        }
        System.out.println("bem-vindo de volta " + contaDoLogado.getNome());

    }

    private void registrar () {
        System.out.println("nome Completo:");
        String nome = entrada.nextLine();
        boolean nomeJaExiste = false;

        for (ModeloDeConta conta : Blue.contas) {
            if (conta.getNome().equals(nome)) {
                nomeJaExiste = true;
                break;
            }
        }

        while (nomeJaExiste || nome == null || nome.equals(" ") || nome.length() < 16) {
            System.out.println("[ERRO] Nome vazio, faltando informações ou já existente!");
            System.out.println("Digite novamente");
            nome = entrada.nextLine();

            nomeJaExiste = false;
            for (ModeloDeConta conta : Blue.contas) {
                if (conta.getNome().equals(nome)) {
                    nomeJaExiste = true;
                    break;
                }
            }
        }

        System.out.println("email:");
        String email = entrada.nextLine();
        boolean emailJaExiste = false;

        for (ModeloDeConta conta : Blue.contas) {
            if (conta.getEmail().equals(email)) {
                emailJaExiste = true;
                break;
            }
        }

        while (emailJaExiste || email == null || email.equals(" ") || email.length() < 8) {
            System.out.println("[ERRO] Email vazio, faltando informações ou já existente!");
            System.out.println("Digite novamente");
            email = entrada.nextLine();

            emailJaExiste = false;
            for (ModeloDeConta conta : Blue.contas) {
                if (conta.getEmail().equals(email)) {
                    emailJaExiste = true;
                    break;
                }
            }
        }

        System.out.println("senha:");
        String senha = entrada.nextLine();

        while (senha == null || senha.equals(" ") || senha.length() < 8) {
            System.out.println("[ERRO] Senha vazia ou pequena, favor criar uma senha de 8 dígitos");
            System.out.println("Digite novamente");
            senha = entrada.nextLine();
        }

        System.out.println("cpf:");
        String cpf = entrada.nextLine();
        boolean cpfJaExiste = false;

        for (ModeloDeConta conta : Blue.contas) {
            if (conta.getCpf().equals(cpf)) {
                cpfJaExiste = true;
                break;
            }
        }

        while (cpfJaExiste || cpf == null || cpf.equals(" ") || cpf.length() < 11 || cpf.length() > 12) {
            System.out.println("[ERRO] Cpf vazio, faltando informações ou já existente!");
            System.out.println("Digite novamente");
            cpf = entrada.nextLine();

            cpfJaExiste = false;
            for (ModeloDeConta conta : Blue.contas) {
                if (conta.getCpf().equals(cpf)) {
                    cpfJaExiste = true;
                    break;
                }
            }
        }

        System.out.println("Seja bem-vindo " + nome + " ao seu banco Blue!");

        banco.criarConta(nome,cpf,senha,email);
    }
}
