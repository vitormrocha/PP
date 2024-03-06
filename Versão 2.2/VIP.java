/*
    Repensar a forma que será usada e modificar essa função posteriormente
    Formas:
        Valor fixo de desconto Ex: 100 reais de desconto
        Porcentagem Ex: 10% de desconto

        (talvez porcentagem seja mais fácil e interessante de trabalhar
     */

public class VIP {
    // ================================= Atributos
    private boolean eh_VIP;
    private static double desconto; // Repensar se o cálculo será feito por valores ou porcentagem
    private Data dataVIP;

    // ================================= Construtores
    public VIP()
    {
        eh_VIP = false;
        desconto = 0;
        dataVIP = null;
    }

    public VIP(boolean eh_VIP, double desconto, Data dataVIP) {
        this.eh_VIP = eh_VIP;
        VIP.desconto = desconto;
        this.dataVIP = dataVIP;
    }
    // ================================= Getters e Setters
    public void setEh_VIP(boolean eh_VIP) {
        this.eh_VIP = eh_VIP;
    }

    public boolean getEh_VIP() {
        return eh_VIP;
    }

    public void setDesconto(int desconto) {
        VIP.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDataVIP(Data dataVIP) {
        this.dataVIP = dataVIP;
    }

    public Data getDataVIP() {
        return dataVIP;
    }

    // ================================= Outros Métodos
    public void exibeVIP() {
        System.out.println("Eh VIP: " + eh_VIP + "\nDesconto: " + desconto);
        System.out.println("Data VIP: " + dataVIP.getDia() + "/" + dataVIP.getMes() + "/" + dataVIP.getAno());
    }
}

