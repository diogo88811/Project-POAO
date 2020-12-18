package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que define um Doutorado na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Doctorate extends ScholarshipStudent implements Serializable {

    private ArrayList<Task> listTasks = new ArrayList<>();
    private int payValue = 1200;

    /**
     * Construtor de Doutorado.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param project = projecto
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     */
    public Doctorate(Date startScholarship, Date endScholarship, Project project, int overWorked, String name, String email) {
        super(startScholarship, endScholarship, project, overWorked, name, email);
    }

    /**
     * Construtor de Doutorado.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     */
    public Doctorate(Date startScholarship, Date endScholarship, int overWorked, String name, String email) {
        super(startScholarship, endScholarship, overWorked, name, email);
    }

    /**
     * Método get para obter o nome.
     *
     * @return name = nome
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Método get para obter o email.
     *
     * @return email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Método get para obter o valor a pagar.
     *
     * @return payValue = valor a pagar
     */
    @Override
    public int getPayValue() {
        return payValue;
    }

    /**
     * Método get para obter a lista de tarefas pelo qual está responsável.
     *
     * @return listTasks = lista de tarefas
     */
    @Override
    public ArrayList<Task> getListTasks() {
        return listTasks;
    }

    /**
     * Método toString que retorna todas as informações numa string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Doctorate:"
                + name 
               ;
    }

}
