package me.fsn.filipe.refactoring;

public class Conta {

    private long entrada;

    private long saida;

    private Veiculo veiculo;

    public Conta(long entrada, long saida, Veiculo veiculo) {
        this.entrada = entrada;
        this.saida = saida;
        this.veiculo = veiculo;
    }

    public Double gerarConta() {
        // obtém o período de utilização em minutos
        long periodo = (saida - entrada) / 1000 / 60;

        if (veiculo.getTipoVeiculo().equals(TipoVeiculo.CARRO_PASSEIO)) {
            // gera conta para carros de passeio
            if (periodo <= 30) {
                return 5.0;
            } else if (periodo > 30 && periodo <= 60) {
                return 8.0;
            } else if (periodo > 60 && periodo / 60 <= 6) {
                // obtém horas adicionais de utilização
                long horas = (periodo - 1) / 60;
                return horas * 3.0 + 8.0;
            } else {
                return 20.0;
            }
        } else if (veiculo.getTipoVeiculo().equals(TipoVeiculo.CAMINHONETE)) {
            // gera conta para caminhonetes
            if (periodo <= 30) {
                return 7.0;
            } else if (periodo > 30 && periodo <= 60) {
                return 10.0;
            } else if (periodo > 60 && periodo / 60 <= 6) {
                // obtém horas adicionais de utilização
                long horas = (periodo - 1) / 60;
                return horas * 5.0 + 10.0;
            } else {
                return 30.0;
            }
        }

        return null;
    }
}
