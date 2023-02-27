package Usuario;

import BancoBlueCon.Blue;
import ModeloDeConta.CriarConta;

public class ContaTest01 {
    //Jesus é o caminho, a verdade e a vida!!!
    public static void main(String[] args) {
        CriarConta contaTest01 = new CriarConta("ISAQUE DA SILVA","99999999909","0000167");
        contaTest01.depositar(1000);
        contaTest01.pagarConta(600);

        Blue blueBanco = new Blue();
        blueBanco.setContas(new CriarConta[]{contaTest01});
        blueBanco.imprime();

        CriarConta conta02 = new CriarConta("Caleb","99999999901","2334445555");
        conta02.depositar(1999);
        System.out.println(conta02.getSaldo());

        blueBanco.setContas(new CriarConta[]{conta02,contaTest01});
        blueBanco.imprime();
    }
}
