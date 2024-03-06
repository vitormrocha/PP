public class PassagemAerea {
    // ================================= Atributos:
    private CompanhiaAerea companhiaResponsavel;    // Garanta já ter instanciado uma companhia
    private Voo vooParaComprar;                     // ISSO DAQUI, INSTANCIE VOOS!
    private VIP clienteVip;                         // Para dar descontos
    private int desconto;                           // No cadastro da passagem a companhia atribui isso
    private int numeroAssentosPrimeiraClasseUDI;    // qtd liberada para o site
    private int numeroAssentosClasseExecutivaUDI;   // qtd liberada para o site
    private int numeroAssentosClasseEconomicaUDI;   // qtd liberada para o site


    // ================================= Construtor:

    public PassagemAerea(CompanhiaAerea companhiaResponsavel, Voo vooParaComprar, VIP clienteVip,  int desconto,
                         int numeroAssentosPrimeiraClasseUDI, int numeroAssentosClasseExecutivaUDI,int numeroAssentosClasseEconomicaUDI){

        this.companhiaResponsavel = companhiaResponsavel;
        this.vooParaComprar = vooParaComprar;
        this.clienteVip = clienteVip;
        this.desconto = desconto;
        this.numeroAssentosPrimeiraClasseUDI= numeroAssentosPrimeiraClasseUDI;
        this.numeroAssentosClasseExecutivaUDI= numeroAssentosClasseExecutivaUDI;
        this.numeroAssentosClasseEconomicaUDI= numeroAssentosClasseEconomicaUDI;
    }

    // ================================= Getters e Setters:

    public CompanhiaAerea getCompanhiaResponsavel() { return companhiaResponsavel; }
    public void setCompanhiaResponsavel(CompanhiaAerea companhiaResponsavel) {
        this.companhiaResponsavel = companhiaResponsavel;
    }

    public Voo getVooParaComprar() { return vooParaComprar; }
    public void setVooParaComprar(Voo vooParaComprar) {
        this.vooParaComprar = vooParaComprar;
    }

    public VIP getClienteVip() { return clienteVip; }
    public void setClienteVip(VIP clienteVip) {
        this.clienteVip = clienteVip;
    }

    public int getDesconto() { return desconto; }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public int getNumeroAssentosPrimeiraClasseUDI() { return numeroAssentosPrimeiraClasseUDI; }
    public void setNumeroAssentosPrimeiraClasseUDI(int numeroAssentosPrimeiraClasseUDI) {
        this.numeroAssentosPrimeiraClasseUDI = numeroAssentosPrimeiraClasseUDI;
    }

    public int getNumeroAssentosClasseExecutivaUDI() { return numeroAssentosClasseExecutivaUDI; }
    public void setNumeroAssentosClasseExecutivaUDI(int numeroAssentosClasseExecutivaUDI) {
        this.numeroAssentosClasseExecutivaUDI = numeroAssentosClasseExecutivaUDI;
    }

    public int getNumeroAssentosClasseEconomicaUDI() { return numeroAssentosClasseEconomicaUDI; }
    public void setNumeroAssentosClasseEconomicaUDI(int numeroAssentosClasseEconomicaUDI) {
        this.numeroAssentosClasseEconomicaUDI = numeroAssentosClasseEconomicaUDI;
    }


    // ================================= Outros Métodos:
    private int comprarAssentos(int quantidade, int quantidadeAtual) {
        if (quantidadeAtual - quantidade >= 0) {
            quantidadeAtual -= quantidade;

            return quantidadeAtual;
        } else return -1;
    }

    public int comprarAssentosPrimeiraClasse(int quantidade) {
        int retorno = comprarAssentos(quantidade, numeroAssentosPrimeiraClasseUDI);

        if (retorno == -1) {
            System.out.println("Opa, não há poltronas o suficientes! Temos " + getNumeroAssentosPrimeiraClasseUDI() + " poltronas de primeira classe");
        }  else setNumeroAssentosPrimeiraClasseUDI(retorno);

        return getNumeroAssentosPrimeiraClasseUDI();
    }

    public int comprarAssentosClasseExecutiva(int quantidade) {
        int retorno = comprarAssentos(quantidade, numeroAssentosClasseExecutivaUDI);

        if (retorno == -1) {
            System.out.println("Opa, não há poltronas o suficientes! Temos " + getNumeroAssentosClasseExecutivaUDI() + " poltronas na classe executiva ");
        } else setNumeroAssentosClasseExecutivaUDI(retorno);

        return getNumeroAssentosClasseExecutivaUDI();
    }

    public int comprarAssentosClasseEconomica(int quantidade) {
        int retorno = comprarAssentos(quantidade, numeroAssentosClasseEconomicaUDI);

        if (retorno == -1) {
            System.out.println("Opa, não há poltronas o suficientes! Temos " + getNumeroAssentosClasseEconomicaUDI() + " poltronas na classe econômica ");
        } else {
            setNumeroAssentosClasseEconomicaUDI(retorno);
        }
        return getNumeroAssentosClasseEconomicaUDI();
    }

    public void poltronasRestantes (int qtd) {
        System.out.println("Restaram : " + qtd);
    }

    public void exibirPassagemAerea() {
        System.out.println("\nInformações de passagens ofertadas ao UDI Decola:");
        System.out.println("- Assentos na Primeira Classe: " + getNumeroAssentosPrimeiraClasseUDI());
        System.out.println("- Assentos na Classe Executiva: " + getNumeroAssentosClasseExecutivaUDI());
        System.out.println("- Assentos na Classe Econômica: " + getNumeroAssentosClasseEconomicaUDI());
    }
}
