public class datasProcuradas {
    private Data data;
    private int num_pesquisa;
    
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public int getNum_pesquisa() {
        return num_pesquisa;
    }
    public void setNum_pesquisa(int num_pesquisa) { 
        if (num_pesquisa > 0)
            this.num_pesquisa = num_pesquisa;
        else this.num_pesquisa = 0;
    }

    public datasProcuradas(Data data, int num_pesquisa) {
        setData(data);
        setNum_pesquisa(num_pesquisa);
    }
    
}
