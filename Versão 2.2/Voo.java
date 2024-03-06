import java.util.ArrayList;

public class Voo extends Trecho {
    // ================================= Atributos
    private ArrayList<Data> voosCad;        // datas para esse voo
    private Horario horarioSaida;           // horario que poderá ser modificado pela companhia
    private Horario horarioChegada;         // horario que poderá ser modificado pela companhia
    private int indiceMes;                  // mes das reservas do voo
    private int ocorrenciaMensal;           // 0= todo dia, 1= uma vez no mes, 2= duas vezes, 4= vezes
    private int modalidadeMensal;           // com base na ocorrencia mensal, essa modalidade influencia
    private int diaDaSemana;                // 1 = terça, 2 = quarta, 3 = quinta, 4 = sexta, 5 = sabado, 6 = domingo, 7 segunda. SE FOR setOcorrenciaMensal = 2, isso é diferente
    private float preco;                    // preco base desse voo

    // ================================= Construtores
    public Voo(String codigoIdentificador, Horario hSaida, Horario hChegada, int indiceMes, int ocorrenciaMensal, int modalidadeMensal, int diaDaSemana) {
        super(codigoIdentificador);
        this.horarioSaida       = hSaida;
        this.horarioChegada     = hChegada;
        this.indiceMes          = indiceMes;
        this.ocorrenciaMensal   = ocorrenciaMensal;
        this.modalidadeMensal   = modalidadeMensal;
        this.diaDaSemana        = diaDaSemana;
        this.voosCad = new ArrayList<>();
    }

    // ================================= Getters e Setters
    @Override
    public Horario getHorarioSaida() { return horarioSaida; }
    @Override
    public void setHorarioSaida(Horario horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    @Override
    public Horario getHorarioChegada() { return horarioChegada; }
    @Override
    public void setHorarioChegada(Horario horarioChegada) {
        this.horarioChegada = horarioChegada;
    }


    public float getPreco() { return preco; }
    public void setPreco(float preco) {
        if (preco > 0)
            this.preco = preco;
    }

    public int getOcorrenciaMensal() { return ocorrenciaMensal; }
    public void setOcorrenciaMensal(int ocorrenciaMensal) {
        if ((ocorrenciaMensal != 0) && (ocorrenciaMensal != 1) &&(ocorrenciaMensal != 2) && (ocorrenciaMensal != 4) )
            throw new IllegalArgumentException("Forneça uma ocorrencia válido!\n");

        this.ocorrenciaMensal = ocorrenciaMensal;
    }

    public int getModalidadeMensal() { return modalidadeMensal; }
    public void setModalidadeMensal(int modalidadeMensal) {
        // Se temo alguma ocorrencia válida:
        if (((ocorrenciaMensal == 0) || (ocorrenciaMensal == 1) || (ocorrenciaMensal == 2) || (ocorrenciaMensal == 4)) && ((modalidadeMensal > 0) && (modalidadeMensal < 4)))
        {
            this.modalidadeMensal = modalidadeMensal;
        }
        // E se não entrar em uma dessas ocorrencias mensais, não podemos atribuir modalidade devidamente:
        else throw new IllegalArgumentException("Forneça uma ocorrência válida!\n");
    }

    public int getIndiceMes() { return indiceMes; }
    public void setIndiceMes(int indiceMes) {
        if ((indiceMes < 1) || (indiceMes > 12))
            throw new IllegalArgumentException("Forneça uma escolha válida!\n");

        this.indiceMes = indiceMes;
    }

    public int getDiaSemana() { return diaDaSemana; }
    public void setDiaSemana(int diaDaSemana) {
        if ((diaDaSemana < 0) || diaDaSemana > 8)
            throw new IllegalArgumentException("Forneça uma escolha válida!\n");

        this.diaDaSemana = diaDaSemana;
    }

    // ================================= Outros Métodos
    public void exibirVoo() {
        //exibirTrecho(); // para ter todas as infos ddo trecho
        System.out.println("\n> Informações do Voo:");
        System.out.println("- Horario da saida: ");
        horarioSaida.exibeHorario();
        System.out.println("- Horario de chegada: ");
        horarioChegada.exibeHorario();
        System.out.println("Datas encontradas para o voo:");
        for (Data data : voosCad) { data.exibeData(); }
    }

    public void cadastrarVooUmaVezPorMes(){
        int anoAtual    = 2024;                             // Data padrão do sistema
        int contagem    = 0;                                // Contador usado em iteracoes do codigo
        Data dataVoo    = new Data(1,indiceMes,anoAtual); // Data genérica que iremos manipular
        int mes         = indiceMes;                        // Mes escolhido pelo usuario
        int maxDiasMes = dataVoo.quantidadeDiasNoMes(indiceMes,dataVoo.getAno()); // Int que garante a leitura completa de um mês

        System.out.println("[ Ocorre 1 vez(es) no mes ] ");

        percorreMes(mes, anoAtual, contagem, maxDiasMes);
    }

    public void cadastrarVooDuasVezesPorMes(){
        int dia         ;                                   // Dia genérico usado em iteracoes
        int anoAtual    = 2024;                             // Data padrão do sistema
        int contagem    = 0;                                // Contador usado em iteracoes do codigo
        Data dataVoo    = new Data(1,indiceMes,anoAtual); // Data genérica que iremos manipular
        int mes         = indiceMes;                        // Mes escolhido pelo usuario
        int maxDiasMes = dataVoo.quantidadeDiasNoMes(indiceMes,dataVoo.getAno()); // Int que garante a leitura completa de um mês

        System.out.println("[ Ocorre 2 vez(es) no mes ] ");

        // Modalidade UM: Dado um dia da semana, será reservada a primeira ocorrencia e a segunda
        if (modalidadeMensal == 1)  // A primeira aparicao e segunda aparicao do dia da semana definido em setDiaSemana
        {
            System.out.println("-> Modalidade 1: ");
            percorreMes(mes, anoAtual, contagem, maxDiasMes);
        }

        // Modalidade DOIS: Um sexta-sabado do mes.
        if (modalidadeMensal == 2)
        {
            System.out.println("-> Modalidade 2:");

            switch (diaDaSemana)
            {
                case 1: // Primeira sexta-sábado
                    for (dia = 1; dia <= maxDiasMes; dia++) {
                        // Verifica se o dia da semana corresponde ao dia da semana definido para o voo
                        if (Data.diaDaSemana(anoAtual, mes, dia) == 4) { // 4 representa sexta-feira
                            // Verifica se o próximo dia também é o dia desejado (sexta-feira)
                            percorreMesDuplas(dia, mes, anoAtual, maxDiasMes);
                            dia = maxDiasMes;  // para barrar a iteracao
                        }
                    }
                    break;

                case 2: // Segunda ocorrencia de sexta-sabado
                    for (dia = 1; dia <= maxDiasMes; dia++) {
                        if (Data.diaDaSemana(anoAtual, mes, dia) == 4) {
                            if ((dia < maxDiasMes && Data.diaDaSemana(anoAtual, mes, dia + 1) == 5) && contagem == 1) { // 5 representa sexta-feira
                                Data dataUm = new Data(dia, mes, anoAtual);
                                Data dataDois = new Data(dia + 1, mes, anoAtual);
                                voosCad.add(dataUm);
                                voosCad.add(dataDois);
                            }
                            contagem++;
                        }
                    }break;

                case 3: // Ultima sexta-sabado
                    // Essa iteracao é puramente pra saber quantas sexta-sabado temos, e com isso, achamos o penultimo:
                    for (dia = 1; dia <= maxDiasMes; dia++) {
                        if (Data.diaDaSemana(anoAtual, mes, dia) == 4) { contagem++; }
                    }

                    int penultimo   = contagem - 2;
                    contagem        = 0;

                    for (dia = 1; dia <= maxDiasMes; dia++) {
                        if (Data.diaDaSemana(anoAtual, mes, dia) == 4){
                            if ((dia < maxDiasMes && Data.diaDaSemana(anoAtual, mes, dia + 1) == 5) && (contagem == penultimo)) { // 5 representa sexta-feira
                                Data dataUm = new Data(dia, mes, anoAtual);
                                Data dataDois = new Data(dia + 1, mes, anoAtual);
                                voosCad.add(dataUm);
                                voosCad.add(dataDois);
                            }
                            contagem++;
                        }
                    }
                    break;
            }
        }

        // Modalidade TRES: Escolha um dia, e reserve o seguinte também:
        if ((modalidadeMensal == 3))
        {
            System.out.println("-> Modalidade 3:");

            for (dia = 1; dia <= maxDiasMes; dia++) {
                if (Data.diaDaSemana(anoAtual, mes, dia) == diaDaSemana) {
                    if (dia < maxDiasMes && Data.diaDaSemana(anoAtual, mes, dia + 1) == diaDaSemana) {
                        Data dataUm = new Data(dia, mes, anoAtual);
                        Data dataDois = new Data(dia + 1, mes, anoAtual);
                        voosCad.add(dataUm);
                        voosCad.add(dataDois);
                    }
                    dia = maxDiasMes;  // para barrar a iteracao
                }
            }
        }
    }

    public void cadastrarVooQuatroVezesPorMes() {
        int dia;                                                // Dia genérico usado em iteracoes
        int anoAtual    = 2024;                             // Data padrão do sistema
        int contagem    = 0;                                // Contador usado em iteracoes do codigo
        Data dataVoo    = new Data(1,indiceMes,anoAtual); // Data genérica que iremos manipular
        int mes         = indiceMes;                        // Mes escolhido pelo usuario
        int maxDiasMes = dataVoo.quantidadeDiasNoMes(indiceMes,dataVoo.getAno()); // Int que garante a leitura completa de um mês

        System.out.println("[ Ocorre 4 vez(es) no mes ] ");

        if (modalidadeMensal == 1) // Reservas para as quatro primeirass aparicoes do setDiaSemana nesse mes
        {
            System.out.println("-> Modalidade 1:");

            percorreMes(mes, anoAtual, contagem, maxDiasMes);
        }

        if (modalidadeMensal == 2) // primeira ocorrencia de sexta/sabado do mes, pula uma semana, reserva a sexta/segunda
        {
            System.out.println("-> Modalidade 2:");

            for (dia = 1; dia <= maxDiasMes; dia++) {
                // Verifica se o dia da semana corresponde ao dia da semana definido para o voo
                if (Data.diaDaSemana(anoAtual, mes, dia) == 4) { //

                    // Verifica se a contagem é par e se o próximo dia também é o dia desejado (sábado)
                    percorreMesDuplas(dia, mes, anoAtual, maxDiasMes);
                    dia = dia + 7;  // garante que vamos pular uma semana!
                }
            }
        }
    }

    private void percorreMesDuplas(int dia, int mes, int anoAtual, int maxDiasMes) {
        if (dia < maxDiasMes && Data.diaDaSemana(anoAtual, mes, dia + 1) == 5) { // 6 representa sábado
            Data dataUm = new Data(dia, mes, anoAtual);
            Data dataDois = new Data(dia + 1, mes, anoAtual);
            voosCad.add(dataUm);
            voosCad.add(dataDois);
        }
    }

    private void percorreMes(int mes, int anoAtual, int contagem, int maxDiasMes) {
        int dia;
        for (dia = 1; dia <= maxDiasMes; dia++) // percorre até o fim do mes em questao
        {
            // Verifica se o dia da semana corresponde ao dia da semana definido para o voo
            if (Data.diaDaSemana(anoAtual, mes, dia) == diaDaSemana) {
                contagem++;                                                 // voos cadastrados no mês

                // Se a contagem for menor ou igual ao número de vezes que o voo deve ser cadastrado
                if (contagem <= ocorrenciaMensal) {
                    Data dataCadastro = new Data(dia, mes, anoAtual);       // Cria a data para o dia encontrado
                    voosCad.add(dataCadastro);                              // Adiciona a data encontrada ao ArrayList
                }
            }
        }
    }

    public void cadastrarVooDiarioNoMes() {
        int dia         ;                                       // Dia genérico usado em iteracoes
        int anoAtual    = 2024;                                 // Data padrão do sistema
        int contagem    = 0;                                    // Contador usado em iteracoes do codigo
        Data dataVoo    = new Data(1,indiceMes,anoAtual);   // Data genérica que iremos manipular
        int mes         = indiceMes;                            // Mes escolhido pelo usuario
        int maxDiasMes = dataVoo.quantidadeDiasNoMes(indiceMes,dataVoo.getAno()); // Int que garante a leitura completa de um mês

        for (dia = 1; dia <= maxDiasMes; dia++) // percorre até o fim do mes em questao
        {
            Data dataCadastro = new Data(dia, mes, anoAtual);       // Cria a data para o dia encontrado
            voosCad.add(dataCadastro);
        }
    }
}