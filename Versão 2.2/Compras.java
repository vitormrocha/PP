import java.util.ArrayList;

public class Compras {
    private Cliente cliente; 
    private Data hora_busca;
    private Data hora_compra;
    private ArrayList <Historico> historico;

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ArrayList<Historico> getHistorico() {
        return historico;
    }
    public void setHistorico(ArrayList<Historico> historico) {
        this.historico = historico;
    }
    public Data getHora_busca() {
        return hora_busca;
    }
    public void setHora_busca(Data hora_busca) {
        this.hora_busca = hora_busca;
    }
    public Data getHora_compra() {
        return hora_compra;
    }
    public void setHora_compra(Data hora_compra) {
        this.hora_compra = hora_compra;
    }

    public void AddEndereco (Historico historico) {
        this.historico.add(historico);
    }

    public Compras(Cliente cliente, Data hora_busca, Data hora_compra) {
        setCliente(cliente);
        setHora_busca(hora_busca);
        setHora_compra(hora_compra);
    } 
    
   public void comprar_passagem(PassagemAerea passagem) {
        if (!cliente.getVip().getEh_VIP()) {
            if (cliente.getSaldo() > passagem.)
        }
   }

    
}
