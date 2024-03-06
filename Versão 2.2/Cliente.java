/*
    CLIENTE
    {
        - CPF
        - Nome : Verificação feita
        - Endereço completo 
        - Data de Nascimento
        - Data de cadastro
        - E-mail
        - Número de compras
        - Se é VIP
        - Valor do desconto por ser VIP (decidido por nós)
        - Data em que se tornou VIP


        OBS: É necessário registrar as pesquisas feitas pelo cliente
        Seja a origem, destino, data de início e data de fim
        Para fazer pesquisas de destinos e datas mais procurados
        Armazenar também a data e hora que a pesquisa foi realizada
        OBS2: talvez seja interessante NÃO armazenar dentro da classe CLIENTE
    }
*/


public class Cliente {
    // ================================= Atributos
    private String nome; // ok

    private CPF cpf; // ok

    private Data dataNascimento; // ok

    private Data dataCadastro; // ok

    private Endereco endereco; // ok

    private String email; // ok

    private int numeroCompras; // ok

    private VIP vip; // falta cálculo desconto

    //private HistoricoPesquisa historico;

    private double saldo;

    // ================================= Construtores
    public Cliente() {

    }

    public Cliente(String nome, CPF cpf, Data nasci, Data datacadastro, Endereco endereco, String email, int numCompras, VIP vip) {
        setCpf(cpf);
        setEmail(email);
        setNome(nome);
        setNumeroCompras(numCompras);
        setEndereco(endereco);
        setDataNascimento(nasci);
        setDataCadastro(datacadastro);
        setVip(vip);
//        this.historico = new HistoricoPesquisa();
    }

    // ================================= Getters e Setters
    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        if (numeroCompras > 0)
            this.numeroCompras = numeroCompras;
        else
            this.numeroCompras = 0;
    }

    public void AddCompra () {
        numeroCompras++;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public void setNome(String nome) {
        if (verificarNome(nome))
            this.nome = nome;
        else
            System.out.println("\nERRO. NOME INVALIDO.\n");
    }

    public String getNome(){
        return nome;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public CPF getCpf() {
        return cpf;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Data getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Data dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public VIP getVip() {
        return vip;
    }

    public void setVip(VIP vip) {
        this.vip = vip;
    }

//    public HistoricoPesquisa getHistorico() {
//        return historico;
//    }
//
//    public void setHistorico(HistoricoPesquisa historico) {
//        this.historico = historico;
//    }

    public void setEmail(String email) {
        if (verificarEmail(email))
            this.email = email;
        else
            System.out.println("\nERRO. EMAIL INVALIDO.\n");
    }

    public String getEmail() {
        return email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo > 0)
            this.saldo = saldo;
        else
            this.saldo = 0;
    }


    // ================================= Outros Métodos
    private boolean verificarNome(String nome) {
        if (!nome.trim().isEmpty())
            return true;

        else {
            this.nome = nome;
            return false ;
        }
    }

    private boolean verificarEmail(String email) {
        if (email.trim().isEmpty() || email.contains("@") == false)
            return false;
        else {
            this.email = email;
            return true;
        }
    }

    public void exibeCliente() {
        System.out.println("Nome: " + nome);
        cpf.exibeCPF();
        dataNascimento.exibeData();
        dataCadastro.exibeData();
        endereco.exibeEndereco();
        System.out.println("Email: " + email);
        System.out.println("Numero de compras: " + numeroCompras);
        vip.exibeVIP();
    }

//    public void ExibirHistoricoPesquisa() {
//        historico.ExibirHistorico();
//    }

    public void depositar (double valor) {
        if (valor > 0)
            saldo += valor;
    }

    public void pagar (double valor) {
        if (valor > saldo)  {
            System.out.println("\nSALDO INSUFICIENTE.\n");
        }

        else if (valor >= 0) {
            saldo -= valor;
        }
    }
}