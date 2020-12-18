package project1;

import java.io.Serializable;

/**
 * Classe que define uma tarefa de Documentação na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Documentation extends Task implements Serializable {

    private double effortRate = 0.25;

    /**
     * Conctrutor de Documentação.
     *
     * @param acron = acrónimo
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param inCharge = responsável
     * @param rateExec = taxa de execução
     */
    public Documentation(String acron, Date startDate, Date endDate, Person inCharge, double rateExec) {
        super(acron, startDate, endDate, inCharge, rateExec);
    }

    /**
     * Construtor de Documentação.
     *
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param acron = acrónimo
     * @param rateExec = taxa de execução
     * @param estimatedDuration = tempo estimado de duração
     */
    public Documentation(Date startDate, Date endDate, String acron, double rateExec, double estimatedDuration) {
        super(startDate, endDate, acron, rateExec, estimatedDuration);
    }

    /**
     * Método get para obter a taxa de esforço.
     *
     * @return effortRate = taxa de esforço
     */
    @Override
    public double getEffortRate() {
        return effortRate;
    }

}
