import com.github.mybank.domain.Corrente;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Corrente contaCorrente = new Corrente(4L, 11);
        Corrente contaCorrente2 = new Corrente(5L, 12);
        contaCorrente.setBalance(BigDecimal.valueOf(100));
        System.out.println(contaCorrente);
        System.out.println(contaCorrente2);
        contaCorrente.transfer(BigDecimal.TEN, contaCorrente2);
        System.out.println(contaCorrente);
        System.out.println(contaCorrente2);
    }
}