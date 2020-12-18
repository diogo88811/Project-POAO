package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que define uma Pessoa aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public abstract  class Person implements Serializable {


    protected String name;
    protected String email;
    protected ArrayList<Task> listTasks = new ArrayList<>();
    protected int payValue;
    protected double effort;

    /**
     * Método que define uma pessoa.
     * 
     * @param name = nome
     * @param email = email
     */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Método get para obter o valor a pagar.
     */
    public abstract int getPayValue();

    /**
     * Método get para obter o nome.
     *
     * @return name = nome
     */
    public String getName() {
        return name;
    }

    /**
     * Método get para obter o email.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método get para obter a lista de tarefas pelo qual está responsável.
     *
     * @return listTasks = lista de tarefas
     */
    public ArrayList<Task> getListTasks() {
        return listTasks;
    }

    /**
     * Método para verificar se a pessoa pode executar uma tarefa ou não.
     * 
     * @param task = tarefa
     * @param project = projecto
     * @return boolean = true se a pessoa poder executar a tarefa, false caso contrário
     */
    public boolean possiblePersons(Task task, Project project) {

        Date d = new Date();
        Date addTaskStartDate = task.startDate;
        Date addTaskEndDate = task.endDate;

        double sum = 0;
        int flag = 0;

        System.out.println("Possible persons: \n");

        for (Person p : project.getListPersons()) {
            sum = task.getEffortRate();
            flag = 0;
            System.out.println("Pessoa: " + p);
            System.out.println("lista " + p.getListTasks());
            System.out.println("sum " + sum);
            if (p.getListTasks() != null) {
                for (Task t : p.getListTasks()) {

                    System.out.println("Task sum: " + t.getEffortRate());
                    Date taskStartDate = t.getStartDate();
                    Date taskEndDate = t.getEndDate();

                    //data de entrada menor ou igual à data atual
                    if (d.verifyFirstDateBeforeSecondDate(addTaskStartDate, taskStartDate) && flag == 0) {
                        //data de entrada maior ou igual que data atual 
                        if (!d.verifyFirstDateBeforeSecondDate(addTaskEndDate, taskStartDate)) {
                            sum += t.getEffortRate();
                            System.out.println("Total sum: " + sum);
                            if (sum > 1) {
                                flag = 1;
                            }
                            //---------------------------------------------------------------------------
                            Date overlayStartDate = taskStartDate;
                            Date overlayEndDate = addTaskEndDate;
                            for (Task tt : p.getListTasks()) {
                                taskStartDate = tt.getStartDate();
                                taskEndDate = tt.getEndDate();

                                //data de entrada menor ou igual à data atual
                                if (d.verifyFirstDateBeforeSecondDate(overlayStartDate, taskStartDate) && tt != t) {
                                    //data de entrada maior ou igual que data atual 
                                    if (!d.verifyFirstDateBeforeSecondDate(overlayEndDate, taskStartDate) && tt != t) {
                                        sum += tt.getEffortRate();
                                        System.out.println("Total sum: " + sum);
                                        if (sum > 1) {
                                            flag = 1;
                                        }
                                    }
                                } else {
                                    if (d.verifyFirstDateBeforeSecondDate(overlayStartDate, taskEndDate) && tt != t) {
                                        sum += tt.getEffortRate();
                                        System.out.println("Total sum: " + sum);
                                        if (sum > 1) {
                                            flag = 1;
                                        }
                                    }
                                }
                            }
                            //---------------------------------------------------------------------------  
                        }
                    } else if (flag == 0) {
                        if (d.verifyFirstDateBeforeSecondDate(addTaskStartDate, taskEndDate)) {
                            sum += t.getEffortRate();
                            System.out.println("Total sum: " + sum);
                            if (sum > 1) {
                                flag = 1;
                            }

                            //---------------------------------------------------------------------------
                            Date overlayStartDate = taskStartDate;
                            Date overlayEndDate = addTaskEndDate;
                            for (Task tt : p.getListTasks()) {
                                taskStartDate = tt.getStartDate();
                                taskEndDate = tt.getEndDate();

                                //data de entrada menor ou igual à data atual
                                if (d.verifyFirstDateBeforeSecondDate(overlayStartDate, taskStartDate) && tt != t) {
                                    //data de entrada maior ou igual que data atual 
                                    if (!d.verifyFirstDateBeforeSecondDate(overlayEndDate, taskStartDate) && tt != t) {
                                        sum += tt.getEffortRate();
                                        System.out.println("Total sum: " + sum);
                                        if (sum > 1) {
                                            flag = 1;
                                        }
                                    }
                                } else {
                                    if (d.verifyFirstDateBeforeSecondDate(overlayStartDate, taskEndDate) && tt != t) {
                                        sum += tt.getEffortRate();
                                        System.out.println("Total sum: " + sum);
                                        if (sum > 1) {
                                            flag = 1;
                                        }
                                    }
                                }
                            }
                            //---------------------------------------------------------------------------
                        }
                    }
                }
                System.out.println("Sum end: " + sum);
                if (sum <= 1 && flag == 0) {
                    if (p.getPayValue() > 0) {
                        ScholarshipStudent s = (ScholarshipStudent) p;
                        Date startS = s.startScholarship;
                        Date endS = s.endScholarship;

                        if (!d.verifyFirstDateBeforeSecondDate(addTaskStartDate, startS) && d.verifyFirstDateBeforeSecondDate(addTaskEndDate, endS)) {
                            return true;
                        }

                    }
                    if (p.getPayValue() == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Método set para definir a lista de tarefas.
     *
     * @param listTasks = lista de tarefas
     */
    public void setListTasks(ArrayList<Task> listTasks) {
        this.listTasks = listTasks;
    }

    /**
     * Método para verificar se a pessoa está disponivel para trabalhar num projecto.
     * 
     * @param project = projecto
     * @return boolean = true se estiver disponivel, false caso contrário.
     */
    public boolean isAvaible(Project project) {
        Date d = new Date();
        System.out.println(this);

        if (getPayValue() == 0) {
            return true;
        } else {
            ScholarshipStudent s = (ScholarshipStudent) this;
            if (s.getOverWorked() == 1) {
                return false;
            } else {
                if(d.verifyFirstDateBeforeSecondDate(s.endScholarship, project.getEndDate())) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }

    }

     /**
     * Método para verificar se é professor.
     *
     * @return boolean = true se for professor, false caso contrário.
     */
    public boolean isTeacher() {
        if (getPayValue() == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Método toString que retorna todas as informações numa string.
     *
     * @return string
     */
    public String toString() {
        return "Person{Name: " + name + ""
                + "Email: " + email
                + "Pay Value:" + payValue + "}\n Tasks" + listTasks;
    }
}
