import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ContaBancariaServer {
    public static void main(String[] args) {
        try {
            ContaBancariaImpl conta = new ContaBancariaImpl();
            LocateRegistry.createRegistry(2004);
            Naming.rebind("rmi://localhost:2004/Calc", conta);
            System.out.println("Servidor RMI iniciado...");
        } catch (Exception e) {
            System.out.println("Erro ao iniciar servidor RMI: " + e.getMessage());
        }
    }
}