import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaBancariaImpl extends UnicastRemoteObject implements ContaBancaria {
    private double saldo;

    public ContaBancariaImpl() throws RemoteException {
        super();
        this.saldo = 0.0;
    }

    public synchronized void deposita(double valor) throws RemoteException {
        this.saldo += valor;
    }

    public synchronized void retira(double valor) throws RemoteException {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            throw new RemoteException("Saldo insuficiente");
        }
    }

    public synchronized double saldo() throws RemoteException {
        return this.saldo;
    }
}
