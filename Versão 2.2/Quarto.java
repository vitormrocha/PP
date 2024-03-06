public abstract class Quarto extends QuartosHotel{
    // ================================= Atributos
    private Data data;
    private int qntQuartosDisponiveis;
    private final TipoQuarto tipoQuarto;

    // ================================= Construtores

    public Quarto(Data data, int qntQuartosDisponiveis, TipoQuarto tipoQuarto) {
        this.data = data;
        this.qntQuartosDisponiveis = qntQuartosDisponiveis;
        this.tipoQuarto = tipoQuarto;
    }

    // ================================= Getters e Setters

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getQntQuartosDisponiveis() {
        return qntQuartosDisponiveis;
    }

    public void setQntQuartosDisponiveis(int qntQuartosDisponiveis) {
        this.qntQuartosDisponiveis = qntQuartosDisponiveis;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }
    // ================================= Outros Métodos

    public void ocupandoQuartos(int qntQuartos) {
        qntQuartosDisponiveis = qntQuartosDisponiveis - qntQuartos;
    }

    public void cancelarHospedagaemDia(int qntQuartos) {
        qntQuartosDisponiveis = qntQuartosDisponiveis + qntQuartos;
    }
}
