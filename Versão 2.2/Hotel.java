/*
HOTÉIS
{
    - CNPJ
            - Nome oficial
        - Nome de divulgação
    - Endereço completo
        - Ano de criação
    - Número de estrelas
    - Se aceita pets
    - Número de quartos
    - Horário do Check-in e Check-out
        - Frase de divulgação
    - Descrição do Hotel
        - Cidade do Hotel
        - Quanto paga para UdiDecola por diária vendida

    - Para cada data mostrar o número de quartos disponíveis
    {
        Para quartos standard:
    {
        Existem quartos:
        {
                * Single
                * Duplos
                * Triplos
        }


        - Valor da diária de cada quarto
        {
                * Sem desconto
                * Valor do desconto
                * Valor com desconto
        }
    }

        Para quartos de luxo:
        {
            - Valor da diária do quarto
            {
                * Sem desconto
                * Valor do desconto
                    * Valor com desconto
            }
        }

    }

    - A depender da data escolhida o hotel deve ter a liberdade de aceitar ou não o cancelamento
}
*/

public class Hotel extends Empresa{
    // ================================= Atributos
    private Endereco endereco;
    private int numeroEstrelas;
    private boolean aceitaPets;
    private QuartosHotel quartosHotel;
    private Horario check_in;
    private Horario check_out;
    private String fraseDivulgacao;
    private String descricaoHotel;
    private int remuneracaoPagaPorDiaria;

    // ================================= Construtores
    public Hotel(String cpnj, String nomeOficial, String nomeCriacao, Data dataCriacao, Endereco endereco, int numeroEstrelas, boolean aceitaPets, QuartosHotel quartosHotel, Horario check_in, Horario check_out, String fraseDivulgacao, String descricaoHotel, int remuneracaoPagaPorDiaria) {
        super(cpnj, nomeOficial, nomeCriacao, dataCriacao, endereco);
        this.endereco = endereco;
        this.numeroEstrelas = numeroEstrelas;
        this.aceitaPets = aceitaPets;
        this.quartosHotel = quartosHotel;
        this.check_in = check_in;
        this.check_out = check_out;
        this.fraseDivulgacao = fraseDivulgacao;
        setDescricaoHotel(descricaoHotel);
        this.remuneracaoPagaPorDiaria = remuneracaoPagaPorDiaria;
    }

    // ================================= Getters e Setters
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getNumeroEstrelas() {
        return numeroEstrelas;
    }

    public void setNumeroEstrelas(int numeroEstrelas) {
        this.numeroEstrelas = numeroEstrelas;
    }

    public boolean isAceitaPets() {
        return aceitaPets;
    }

    public void setAceitaPets(boolean aceitaPets) {
        this.aceitaPets = aceitaPets;
    }


    public QuartosHotel getQuartosHotel() {
        return quartosHotel;
    }

    public void setQuartosHotel(QuartosHotel quartosHotel) {
        this.quartosHotel = quartosHotel;
    }

    public Horario getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Horario check_in) {
        this.check_in = check_in;
    }

    public Horario getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Horario check_out) {
        this.check_out = check_out;
    }

    public String getFraseDivulgacao() {
        return fraseDivulgacao;
    }

    public void setFraseDivulgacao(String fraseDivulgacao) {
        this.fraseDivulgacao = fraseDivulgacao;
    }

    public String getDescricaoHotel() {
        return descricaoHotel;
    }

    public void setDescricaoHotel(String descricaoHotel) {
        if (!descricaoHotel.isEmpty())
            this.descricaoHotel = descricaoHotel;
        else
            System.out.println("\nDESCRICAO INVALIDA.\n");
    }

    public int getRemuneracaoPagaPorDiaria() {
        return remuneracaoPagaPorDiaria;
    }

    public void setRemuneracaoPagaPorDiaria(int remuneracaoPagaPorDiaria) {
        if (remuneracaoPagaPorDiaria > 0)
            this.remuneracaoPagaPorDiaria = remuneracaoPagaPorDiaria;
        else this.remuneracaoPagaPorDiaria = 0;
    }



    // ================================= Outros Métodos
    public void exibirHotel(){
        System.out.println("\n> Empresa:");
        System.out.println("- CNPJ           : " + getCnpj());
        System.out.println("- Nome Oficial   : " + getNomeOficial());
        System.out.println("- Nome Marketing : " + getNomeMarketing());
        System.out.print("- Data criacao   : ");
        getDataCriacao().exibeData();

        System.out.println("\n");

        System.out.println("> Informações do Hotel: ");
        endereco.exibeEndereco();
        System.out.println("\n- Numero de estrelas: " + getNumeroEstrelas());

        if (isAceitaPets()){
            System.out.println("- ACEITA pet! ");
        } else System.out.println("- NAO aceita pet! ");

        System.out.print("\n");
        System.out.println("  -> Lista das reservas: ");
        getQuartosHotel().mostrarArrayQuartos();
        System.out.print("\n");

        //check in e checkout

        System.out.println("- Nosso lema eh     : " + getFraseDivulgacao());
        System.out.println("- Descricao         : " + getDescricaoHotel());
        System.out.println("- Remuneracao diaria: " + getRemuneracaoPagaPorDiaria());
    }
}
