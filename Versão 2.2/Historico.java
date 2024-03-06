public class Historico {
    private Endereco origem;
    private Endereco destino;
    private Data data_ida;
    private Data data_volta;
    
    public Endereco getOrigem() {
        return origem;
    }
    public void setOrigem(Endereco origem) {
        this.origem = origem;
    }
    public Endereco getDestino() {
        return destino;
    }
    public void setDestino(Endereco destino) {
        this.destino = destino;
    }
    public Data getData_ida() {
        return data_ida;
    }
    public void setData_ida(Data data_ida) {
        this.data_ida = data_ida;
    }
    public Data getData_volta() {
        return data_volta;
    }
    public void setData_volta(Data data_volta) {
        this.data_volta = data_volta;
    }

    public Historico (Endereco endereco, Endereco destino, Data data_ida, Data data_volta) {
        setOrigem(destino);
        setDestino(destino);
        setData_ida(data_ida);
        setData_volta(data_volta);
    }
    
}
