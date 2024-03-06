public class trechosProcurados {
    private int num_pesquisa;
    private String nome_destino;

    public trechosProcurados(int num_pesquisa, String nome) {
        setNum_pesquisa(num_pesquisa);
        setNome_destino(nome);
    }
    
    public int getNum_pesquisa() {
        return num_pesquisa;
    }
    public void setNum_pesquisa(int num_pesquisa) {
        if (num_pesquisa > 0)
            this.num_pesquisa = num_pesquisa;
        else 
            this.num_pesquisa = 0;
    }
    public String getNome_destino() {
        return nome_destino;
    }
    public void setNome_destino(String nome_destino) {
        if (!nome_destino.isBlank() || !nome_destino.isEmpty())
            this.nome_destino = nome_destino;
    }

    
}
