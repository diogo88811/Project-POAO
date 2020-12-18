package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que define uma Tarefa na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public abstract class Task implements Serializable {

    protected Date startDate;
    protected Date endDate;
    protected double rateExec;
    protected double estimatedDuration;
    protected Person inCharge;
    protected double effortRate;
    protected String acron;
    protected String type;

    /**
     * Construtor de Tarefa.
     *
     * @param acron = acrónimo
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param rateExec = taxa de execução
     * @param inCharge = responsavel
     * @param effortRate = taxa de esforço
     */
    public Task(String acron, Date startDate, Date endDate, double rateExec, Person inCharge, double effortRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.rateExec = rateExec;
        this.inCharge = inCharge;
        this.effortRate = effortRate;
    }

    /**
     * Construtor de Tarefa.
     *
     * @param acron = acrónimo
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param inCharge = responsavel
     * @param rateExec = taxa de execução
     */
    public Task(String acron, Date startDate, Date endDate, Person inCharge, double rateExec) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.inCharge = inCharge;
        this.acron = acron;
        this.rateExec = rateExec;
    }

    /**
     * Construtor de Tarefa.
     *
     * @param acron = acrónimo
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param rateExec = taxa de execução
     */
    public Task(Date startDate, Date endDate, String acron, double rateExec) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.acron = acron;
        this.rateExec = rateExec;
    }

    /**
     * Construtor de Tarefa.
     *
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param acron = acrónimo
     * @param rateExec = taxa de execução
     * @param estimatedDuration = duração estimada
     */
    public Task(Date startDate, Date endDate, String acron, double rateExec, double estimatedDuration) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.acron = acron;
        this.rateExec = rateExec;
        this.estimatedDuration = estimatedDuration;
    }

    /**
     * Método get para obter a taxa de esforço.
     *
     * @return effortRate = taxa de esforço
     */
    public abstract double getEffortRate();

    public Task() {
    }

    /**
     * Método get para obter a data de início.
     *
     * return startDate = data de início
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Método set para definir a data de início.
     *
     * @param startDate = data de início
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Método get para obter a data de fim.
     *
     * return endDate = data de fim
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Método set para definir a data de fim.
     *
     * @param endDate = data de fim
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Método get para obter a taxa de execução.
     *
     * return rateExe = taxa de execução
     */
    public double getRateExec() {
        return rateExec;
    }

    /**
     * Método set para definir a taxa de execução.
     *
     * @param rateExec = taxa de execução
     */
    public void setRateExec(double rateExec) {

        this.rateExec = rateExec;
    }

    /**
     * Método get para obter a duração estimada.
     *
     * return estimatedDuration = duração estimada
     */
    public double getEstimatedDuration() {
        return estimatedDuration;
    }

    /**
     * Método get para obter o acrónimo.
     *
     * return acron = acrónimo
     */
    public String getAcron() {
        return acron;
    }

    /**
     * Método set para definir a duração estimada
     *
     * @param estimatedDuration = duração estimada
     */
    public void setEstimatedDuration(double estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    /**
     * Método get para obter o responsável.
     *
     * return inCharge = responsável
     */
    public Person getInCharge() {
        return inCharge;
    }

    /**
     * Método set para definir o responsável.
     *
     * @param inCharge = responsável
     */
    public void setInCharge(Person inCharge) {
        this.inCharge = inCharge;
    }

    /**
     * Método que verifica se a tarefa tem um responsável.
     *
     * return boolean = true se a tarefa tiver um responsável, false caso
     * contráio
     */
    public boolean checkInCharge() {
        if (getInCharge() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que verifica se a tarefa ainda não começou (taxa de execução a
     * zero).
     *
     * return boolean = true se a tarefa não tiver começado, false caso contráio
     */
    public boolean isUnstarted() {
        if (getRateExec() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que verifica se a tarefa está concluida (taxa de execução a 100).
     *
     * return boolean = true se a tarefa estiver concluida, false caso contráio
     */
    public boolean isConcluded() {
        if (getRateExec() == 100) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que verifica se a tarefa não foi concluida na data estimada.
     *
     * return boolean = true se a tarefa não for concluida na data estimada,
     * false caso contráio
     */
    public boolean isNConcludedOnDate() {

        Date d = new Date();

        if (d.verifyDateBeforeCurrent(getEndDate()) && !isConcluded()) {
            return true;
        }
        return false;
    }

    /**
     * Método toString que retorna todas as informações numa string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Task:"
                 + "Name:" + acron
                + " startDate:" + startDate
               ;
    }

}
