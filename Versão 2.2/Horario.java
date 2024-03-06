/*

    Hora e minuto verificados para ter um horário válido
    horas até 23 e minutos até 59
 */

public class Horario {
    // ================================= Atributos
    private int hora;
    private int minuto;
    // ================================= Construtores
    public Horario(int hora, int minuto) {

        if (hora >= 0 && hora <= 23)
            this.hora = hora;

        if (minuto >= 0 && minuto <= 59)
            this.minuto = minuto;
    }

    // ================================= Getters e Setters
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 0 && hora <= 23)
            this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto <= 59)
            this.minuto = minuto;
    }

    // ================================= Outros Métodos
    public void exibeHorario() {
        System.out.printf("Hora: %d\t\tMinuto: %d\n", hora, minuto);
    }
}
