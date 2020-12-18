package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que define um Projecto na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Project implements Serializable {

    private String name;
    private String acronym;
    private Date startDate;
    private Date endDate;
    private double duration;
    private Teacher ip;
    public App app;

    ArrayList<Person> listPersons = new ArrayList<>();
    ArrayList<Task> listTasks = new ArrayList<>();

    /**
     *
     * @param name
     * @param acronym
     * @param startDate
     * @param duration
     * @param listPersons
     * @param listTasks
     */
    public Project(String name, String acronym, Date startDate, double duration, ArrayList<Person> listPersons, ArrayList<Task> listTasks) {
        this.name = name;
        this.acronym = acronym;
        this.startDate = startDate;
        this.duration = duration;
        this.listPersons = listPersons;
        this.listTasks = listTasks;
        this.listTasks = listTasks;
        this.listTasks = listTasks;
    }

    //constructor to verify if i´m read //
    /**
     * Construtor de Projecto.
     *
     * @param name = nome
     * @param acronym = acrónimo
     * @param startDate = data de início
     * @param duration = duração
     * @param endDate = data de fim
     */
    public Project(String name, String acronym, Date startDate, double duration, Date endDate) {
        this.name = name;
        this.acronym = acronym;
        this.startDate = startDate;
        this.duration = duration;
        this.endDate = endDate;
    }

    /**
     * Construtor de Projecto.
     *
     * @param name = nome
     * @param acronym = acrónimo
     * @param startDate = data de início
     * @param ip = ip do responável
     * @param duration = duração
     * @param endDate = data de fim
     * @param listPerosns = lista de pessoas
     */
    public Project(String name, String acronym, Date startDate, Teacher ip, double duration, Date endDate, ArrayList<Person> listPerosns) {
        this.name = name;
        this.acronym = acronym;
        this.startDate = startDate;
        this.ip = ip;
        this.duration = duration;
        this.endDate = endDate;
        this.listPersons = listPerosns;
    }

    /**
     * Construtor de Projecto.
     *
     * @param name = nome
     * @param acronym = acrónimo
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param duration = duração
     * @param ip = ip do responável
     */
    public Project(String name, String acronym, Date startDate, Date endDate, double duration, Teacher ip) {
        this.name = name;
        this.acronym = acronym;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.ip = ip;
    }

    /**
     * Construtor de Projecto.
     *
     * @param name = nome
     * @param acronym = acrónimo
     * @param listPersons = lista de pessoas
     */
    public Project(String name, String acronym, ArrayList<Person> listPersons) { //só para teste 
        this.name = name;
        this.acronym = acronym;
        this.listPersons = listPersons;
    }

    /**
     * Método get para obter o nome.
     *
     * return name = name
     */
    public String getName() {
        return name;
    }

    /**
     * Método get para obter o acrónimo.
     *
     * return acronym = acrónimo
     */
    public String getAcronym() {
        return acronym;
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
     * Método get para obter a data de fim.
     *
     * return endDate = data de fim
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Método get para obter a duração.
     *
     * return duration = duração
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Método get para obter a lista de pessoas no projecto.
     *
     * @return listPersons = lista de pessoas no projecto
     */
    public ArrayList<Person> getListPersons() {
        return listPersons;
    }

    /**
     * Método set para definir a lista de tarefas no projecto.
     *
     * 
     */
    public void setListTasks(ArrayList<Task> listTasks) {
        this.listTasks = listTasks;
    }

    /**
     * Método get para obter a lista de tarefas no projecto.
     *
     * @return listTasks = lista de tarefas no projecto
     */
    public ArrayList<Task> getListTasks() {
        return listTasks;
    }

    /**
     * Método get para obter o ip do responsável;
     *
     * @return ip = ip do responsável
     */
    public Teacher getIp() {
        return ip;
    }

    /**
     * Método set para definir o ip do responsável.
     *
     * @param ip = ip do responsável
     */
    public void setIp(Teacher ip) {
        this.ip = ip;
    }

    /**
     * Método para obter o custo do projecto.
     *
     * @return cost = custo
     */
    public double cost() {
        double cost = 0.0;
        for (Person p : getListPersons()) {
            cost += p.getPayValue();
        }
        return cost;
    }

    /**
     * Método para criar uma tarefa.
     *
     * @param acron = acrónimo
     * @param type = tipo de tarefa
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param estimatedDuration = duração estimada
     */
    public void createTask(String acron, String type, Date startDate, Date endDate, double estimatedDuration) {

        if (type.equals("Design")) {
            Task task = new Design(startDate, endDate, acron, 0, estimatedDuration);
            getListTasks().add(task);
        }
        if (type.equals("Development")) {
            Task task = new Development(startDate, endDate, acron, 0, estimatedDuration);
            getListTasks().add(task);
        }
        if (type.equals("Documentation")) {
            Task task = new Documentation(startDate, endDate, acron, 0, estimatedDuration);
            getListTasks().add(task);
        }

    }

    /**
     * Método para dar uma tarefa a uma pessoa.
     *
     * @param person = pessoa
     * @param t = tarefa
     */
    public void assignTasks(Person person, Task t) {
        t.setInCharge(person);
        person.getListTasks().add(t);
    }

    /**
     * Método para remover uma tarefa.
     *
     * @param task = tarefa
     */
    public void removeTask(Task task) {

        getListTasks().remove(task);

        for (int i = 0; i < getListPersons().size(); i++) {
            if (getListPersons().get(i) == (task.inCharge)) {
                System.out.println("--------------Start");
                System.out.println(getListPersons().get(i).getListTasks());
                for (int j = 0; j < getListPersons().get(i).getListTasks().size(); j++) {
                    if (getListPersons().get(i).getListTasks().get(j) == task) {
                        getListPersons().get(i).getListTasks().remove(j);
                    }
                }
                System.out.println("------------end");
                System.out.println(getListPersons().get(i).getListTasks());
            }
        }

    }

    /**
     * Método para remover uma pessoa. Todas as tarefas dessa pessoa no projeto
     * ficam sem responsável.
     *
     * @param personToDelete = pessoa para remover
     */
    public void removePerson(Person personToDelete) {

        getListPersons().remove(personToDelete);

        for (Task t : listTasks) {
            if (t.getInCharge() == personToDelete) {
                t.setInCharge(null);
            }

        }
    }

    /**
     * Método que verifica se o projecto está concluido (todas as tarefas têm a
     * taxa de execução a 100).
     *
     * return boolean = true se o projecto estiver concluido, false caso
     * contráio
     */
    public boolean listConcluded() {
        if (getListTasks().isEmpty() || getListTasks() == null) {
            return false;
        }
        for (Task t : getListTasks()) {
            if (t.getRateExec() != 100) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que verifica se o projecto não está concluido (existe pelo menos
     * uma tarefa com execução menor que 100).
     *
     * return boolean = true se o projecto não estiver concluido, false caso
     * contráio
     */
    public boolean listNConcluded() {

        System.out.println(getListTasks());
        if (getListTasks().isEmpty() || getListTasks() == null) {
            return true;
        }
        for (Task t : getListTasks()) {
            if (t.getRateExec() != 100) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para terminar um projecto.
     * 
     * @return boolean = se o projecto der para terminar (têm de ter tarefas) retorna true, caso contrário false.
     */
    public boolean terminateProject() {

        if (getListTasks().isEmpty() || getListTasks() == null) {
            return false;
        }

        for (Task t : getListTasks()) {
            t.rateExec = 100;
        }
        return true;
    }

    /**
     * Método toString que retorna todas as informações numa string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Project:"
                 + name
                ;
    }

}
