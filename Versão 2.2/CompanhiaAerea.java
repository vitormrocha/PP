import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CompanhiaAerea extends Empresa{
    // ================================= Atributos
    private double porcentagemPorPassagem;
    private Data dataDeAdesaoAoUD;

    // ================================= Construtor
    public CompanhiaAerea(Empresa empresa, double porcentagemPorPassagem, Data dataDeAdesaoAoUD) {
        super(empresa.getCnpj(), empresa.getNomeOficial(), empresa.getNomeMarketing(), empresa.getDataCriacao(), empresa.getEndereco());

        this.porcentagemPorPassagem = porcentagemPorPassagem;
        this.dataDeAdesaoAoUD = dataDeAdesaoAoUD;
    }

    public CompanhiaAerea(double porcentagemPorPassagem, Data dataDeAdesaoAoUD) {
        super();
        this.porcentagemPorPassagem = porcentagemPorPassagem;
        this.dataDeAdesaoAoUD = dataDeAdesaoAoUD;
    }

    public CompanhiaAerea() { super(); }

    // ================================= Getters e Setters:
    public double getPorcentagemPorPassagem() {
        return porcentagemPorPassagem;
    }

    public Data getDataDeAdesaoAoUD() {
        return dataDeAdesaoAoUD;
    }

    // ================================= Outros Métodos
    public void exibeCompanhia()
    {
        System.out.println("\n> Informações da Companhia Aérea:");
        System.out.println("Porcentagem Por Passagem: " + porcentagemPorPassagem);
        System.out.print("- Data criacao   : ");
        getDataDeAdesaoAoUD().exibeData();
    }
}