package project1;

import java.io.Serializable;

/**
 * Classe que define uma tarefa de Design na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Design extends Task implements Serializable
        
{
   private double effortRate = 0.5;

    /**
     * Construtor de Design.
     * 
     * @param acron = acrónimo
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param inCharge = responsável
     * @param rateExec = taxa de execução
     * @param estimatedDuration = tempo estimado de duração
     */
    public Design(String acron, Date startDate, Date endDate, Person inCharge, double rateExec, double estimatedDuration) {
        super(acron, startDate, endDate, inCharge, rateExec);
    }

    /**
     * Construtor de Design.
     * 
     * param acron = acrónimo
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param inCharge = responsável
     * @param rateExec = taxa de execução
     */
    public Design(String acron, Date startDate, Date endDate, Person inCharge, double rateExec) {
        super(acron, startDate, endDate, inCharge, rateExec);
    }

    /**
     * Construtor de Design.
     * 
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param acron = acrónimo
     * @param rateExec = taxa de execução
     * @param estimatedDuration = tempo estimado de duração
     */
    public Design(Date startDate, Date endDate, String acron, double rateExec, double estimatedDuration) {
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
