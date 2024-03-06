public class CPF {
    // ================================= Atributos
    private long cpf;

    // ================================= Construtores
    public CPF(long cpf) {
        setCpf(cpf);
    }

    // ================================= Getters e Setters
    public void setCpf(long cpf) {
        if (validarCpf(cpf))
            this.cpf = cpf;
        else
            System.out.println("\nERRO. CPF INVALIDO.\n");
    }

    public long getCpf() {
        return cpf;
    }

    // ================================= Outros Métodos
    private boolean validarCpf(long cpf) {
        String auxiliar = String.format("%011d", cpf);
        if (auxiliar.matches("(\\d)\\1{10}") || auxiliar.length() != 11) {
            return false;
        }
        
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(auxiliar.charAt(i)) * (10 - i);
        }
    
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) 
            primeiroDigito = 0;
        
    
        soma = 0;
        for (int i = 0; i < 10; i++) 
            soma += Character.getNumericValue(auxiliar.charAt(i)) * (11 - i);
        
    
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) 
            segundoDigito = 0;
        
    
        return Character.getNumericValue(auxiliar.charAt(9)) == primeiroDigito
                && Character.getNumericValue(auxiliar.charAt(10)) == segundoDigito;

                /*
                 esse retorno basicamente retorna true se o primeiroDigito e o segundoDigito forem iguais aos digitos verificadores 
                 nos ultimos dois digitos do cpf, (auxiliar.carAt(9) e auxiliar.char.At(10)) 
                 */
    }

    public void exibeCPF() {
        System.out.println("CPF: " + cpf);
    }
}
