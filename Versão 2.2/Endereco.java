public class Endereco {
    // ================================= Atributos
    private String rua; // verificado
    private int numero; //verificado
    private String complemento; //verificado
    private String cidade; //verificado
    private String estado; //verificado

    // ================================= Construtores
    public Endereco (String rua, int numero, String complemento, String cidade, String estado) {
        setRua(rua);
        setNumero(numero);
        setComplemento(complemento);
        setCidade(cidade);
        setEstado(estado);
    }

    // ================================= Getters e Setters
    public void setRua(String rua) {
        if (verificarRua(rua))
            this.rua = rua;
        else 
            System.out.println("\nERRO! RUA INVALIDA.\n");
    }

    public String getRua() {
        return rua;
    }

    public void setNumero(int numero) {
        // Não existe casa com número 0 ou negativo
        if (numero > 0)
            this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setComplemento(String complemento) {
        if (verificarComplemento(complemento))
            this.complemento = complemento;
        else 
            System.out.println("\nERRO. COMPLEMENTO INVALIDO.");
    }

    public String getComplemento() {
        return complemento;
    }

    public void setCidade(String cidade) {
        if (verificarCidade(cidade))
            this.cidade = cidade;
        else
            System.out.println("\nERRO. CIDADE INVALIDA.\n");
    }

    public String getCidade() {
        return cidade;
    }

    public void setEstado(String estado) {
        if (verificarEstado(estado))
            this.estado = estado;
        else
            System.out.println("\nERRO.ESTADO INVALIDO!\n");
    }

    public String getEstado() {
        return estado;
    }

    // ================================= Outros Métodos
    private boolean verificarRua(String rua) {
        return !rua.trim().isEmpty();
    }

    private boolean verificarCidade (String cidade) {
        return !cidade.trim().isEmpty();

    }

    private boolean verificarComplemento(String complemento) {
        return !complemento.trim().isEmpty();
    }

    private boolean verificarEstado (String estado) {
        return !estado.trim().isEmpty();
    }

    public void exibeEndereco()
    {
        System.out.println("Rua         : " + rua);
        System.out.println("Numero      : " + numero);
        System.out.println("Complemento : " + complemento);
        System.out.println("Cidade      : " + cidade);
        System.out.println("Estado      : " + estado);
    }
}
