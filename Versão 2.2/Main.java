public class Main {
    public static void main(String[] args)
    {
        // Instanciando todos os ob jetos
        Hotel           hotelMain               = hotelTeste();
        QuartosHotel    quartosMain             = quartosHotelTeste();
        Empresa         empresaMain             = empresaTesteParaComp();
        CompanhiaAerea  companhiaAereaMain      = companhiaAereaTeste();
        Aviao           aviaoMain               = aviaoTeste();
        Trecho          trechoMain              = trechoTeste();
        Voo             vooMain                 = vooTeste();
        PassagemAerea   passagemAereaMain       = passagemAereaTeste();


        // //====================================================== Colocando voos no sistema:
        vooMain.setIndiceMes(2);           // 1 a 12 para os meses
        vooMain.setDiaSemana(1);           // 1 = terça, 2 = quarta, 3 = quinta, 4 = sexta, 5 = sabado, 6 = domingo, 7 segunda. SE FOR setOcorrenciaMensal = 2, isso é diferente
        vooMain.setOcorrenciaMensal(0);    // 0 = Diariamente, 1 = Uma vez por mes, 2 = Duas vezes por mes, 4 = 4 vezes por mes
        vooMain.setModalidadeMensal(1);    // Cada mês tem uma modalidade, essa variavel ajuda nisso

        int opcao = vooMain.getOcorrenciaMensal();                      // Escolher onde você está entrando no switch.

        // Essas chamadas são para alocar no mês pedido, a quantidade de ocorrencias:
        switch (opcao) {
            case 0:
                vooMain.cadastrarVooDiarioNoMes();
                break;
            case 1:
                vooMain.cadastrarVooUmaVezPorMes();
                break;
            case 2:
                vooMain.cadastrarVooDuasVezesPorMes();
                break;
            case 4:
                vooMain.cadastrarVooQuatroVezesPorMes();
                break;
            default:
                System.out.println("Opção inválida!");
        }
        vooMain.exibirVoo();

        // //====================================================== Compras de Poltrona:
        int retornosDePoltronas;
        for (int quantidade = 2; quantidade < 100; ){

            passagemAereaMain.exibirPassagemAerea();

            System.out.println("\nAgora iremos comprar " + quantidade + " em cada classe.\n");

            retornosDePoltronas = passagemAereaMain.comprarAssentosPrimeiraClasse(quantidade);
            passagemAereaMain.poltronasRestantes(retornosDePoltronas);

            retornosDePoltronas = passagemAereaMain.comprarAssentosClasseExecutiva(quantidade);
            passagemAereaMain.poltronasRestantes(retornosDePoltronas);

            retornosDePoltronas = passagemAereaMain.comprarAssentosClasseEconomica(quantidade);
            passagemAereaMain.poltronasRestantes(retornosDePoltronas);

            quantidade = quantidade *2;

            System.out.println("\n======================================================");
        }

        //====================================================== Quartos compra:
        boolean aux;

        aux = hotelMain.getQuartosHotel().hospedar(new Data(25, 1, 2024), new Data(3, 2, 2024), 50, QuartosHotel.TipoQuarto.SINGLE);
        System.out.println(aux);

        aux = hotelMain.getQuartosHotel().hospedar(new Data(29, 1, 2024), new Data(7, 2, 2024), 30, QuartosHotel.TipoQuarto.SINGLE);
        System.out.println(aux);

        //aux = hotel.getQuartosHotel().hospedar(new Data(10, 7, 2024), new Data(17, 7, 2024), 2, QuartosHotel.TipoQuarto.LUXO);

        aux = hotelMain.getQuartosHotel().hospedar(new Data(29, 1, 2024), new Data(7, 2, 2024), 30, QuartosHotel.TipoQuarto.SINGLE);
        System.out.println(aux);

        // hotel.getQuartosHotel().mostrarQuarto(4);
        hotelMain.getQuartosHotel().mostrarArrayQuartos();

        // Mostra a quantidade de objetos que existem na ArrayList
        System.out.println(hotelMain.getQuartosHotel().getQuartos().size());

        // //====================================================== Exibições finais:
        System.out.println("\n====================================================== Exibicoees finais de todas as informacoes do sistema: ");
        hotelMain.exibirHotel();
        quartosMain.mostrarArrayQuartos();
        empresaMain.exibirEmpresa();
        companhiaAereaMain.exibeCompanhia();
        aviaoMain.exibirAviao();
        trechoMain.exibirTrecho();
        vooMain.exibirVoo();
        passagemAereaMain.exibirPassagemAerea();
    }

    // Hotel genérico pra teste
    private static Hotel hotelTeste() {
        Data dataCriacao            = dataCriacao();
        Endereco endereco           = endereco();
        QuartosHotel quartosHotel   = quartosHotelTeste();
        Horario Check_in            = Check_inTeste();
        Horario Check_out           = Check_outTeste();

        String nomeOficial          = "NOME OFICIAL";
        String nomeMarketing        = "NOME CRIACAO";
        String divulgacao           = "Hotel lindu demais!";
        String descricao            = "Hotel BAUM demais";

        return new Hotel("123", nomeOficial, nomeMarketing, dataCriacao, endereco,5,true, quartosHotel, Check_in, Check_out, divulgacao, descricao, 10);
    }

    // Endereco generico pra teste
    private static Endereco endereco(){
        return new Endereco("Das oliveiras", 1395, "apto 302", "Udia", "MG");
    }

    // Data genérica pra criacao das coisas
    private static Data dataCriacao(){ return new Data(1, 1, 2024); }

    // Criacao dos quartos:
    private static QuartosHotel quartosHotelTeste(){
        return new QuartosHotel(100, 200, 300, 50, 50, 100, 150, 200, 3);
    }

    // Horario de check_in e check_out
    private static Horario Check_inTeste(){ return new Horario(2, 0); }
    private static Horario Check_outTeste(){ return new Horario(2, 0); }

    // Empresa generica pra empresa da companhia:
    private static Empresa empresaTesteParaComp(){ return new Empresa("123456678","Voa Voa","Voabao",dataCriacao(),endereco()); }

    // A companhia aerea:
    private static CompanhiaAerea companhiaAereaTeste(){ return new CompanhiaAerea(empresaTesteParaComp(),15,dataCriacao()); }

    // Vip de test:
    private static VIP vipTeste (){ return new VIP(true,18,dataCriacao()); }

    // Avião que iremos ofertar o trecho de voo:
    private static Aviao aviaoTeste(){ return new Aviao("Aviao Ao", "Inglaterra",1980,"Cha da tarde", 50,50,100); }

    // Criacao individual de um trecho:
    private static Trecho trechoTeste(){
        Data dataCriacao = dataCriacao();
        Horario horarioPartida = horarioGenericoPartida();
        Horario horarioChegada = horarioGenericoChegada();

        return new Trecho("aaa11111","SP","RJ",250,15,dataCriacao,horarioPartida,horarioChegada);
    }

    // E dado um trecho, criamos o voo:
    private static Voo vooTeste(){
        Horario horarioPartida = horarioGenericoPartida();
        Horario horarioChegada = horarioGenericoChegada();

        return new Voo(trechoTeste().getCodigoIdentificador(),horarioPartida,horarioChegada,3,0,1,1);
    }

    // Horarios genericos usados no trecho e no voo:
    private static Horario horarioGenericoPartida(){ return new Horario(10,0); }
    private static Horario horarioGenericoChegada(){ return new Horario(20,0); }

    private static PassagemAerea passagemAereaTeste(){ return new PassagemAerea(companhiaAereaTeste(),vooTeste(),vipTeste(),5,5,10,10);
    }

}