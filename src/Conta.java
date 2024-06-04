public abstract class Conta implements IConta{
    private static final int AGENCIA = 1;
    private static int NUMERO_CONTA = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA;
        this.numero = NUMERO_CONTA++;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        if (this.saldo >= valor) {
            saldo-=valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo+=valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if(this.saldo>=valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println("Titular: "+this.cliente.getNome());
        System.out.println("Agencia: "+this.agencia);
        System.out.println("Numero: "+ this.numero);
        System.out.println("Saldo: "+ this.saldo);
    }


}
