import java.rmi.Naming;
import java.rmi.RemoteException;

public class ContaBancariaClient {
    public static void main(String[] args) {
        try {
            ContaBancaria conta = (ContaBancaria) Naming.lookup("rmi://localhost:2004/Calc");
            System.out.println("Saldo inicial: " + conta.saldo());
            conta.deposita(100.0);

            System.out.println("Saldo após depósito: " + conta.saldo());
            conta.retira(50.0);

            System.out.println("Saldo após retirada: " + conta.saldo());

        } catch (Exception e) {
            System.out.println("Erro ao acessar conta remota: " + e.getMessage());
        }
    }
}
