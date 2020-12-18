package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que define um Mestre na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Masters extends ScholarshipStudent implements Serializable {

    private int payValue = 1000;
    private ArrayList<Teacher> listAdvisor = new ArrayList<>();

    /**
     * Construtor de Mestre.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param project = projecto
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     * @param listAdvisor = lista de orientadores
     */
    public Masters(Date startScholarship, Date endScholarship, Project project, int overWorked, String name, String email, ArrayList<Teacher> listAdvisor) {
        super(startScholarship, endScholarship, project, overWorked, name, email);
        this.listAdvisor = listAdvisor;
    }

    /**
     * Construtor de Mestre.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param project = projecto
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     */
    public Masters(Date startScholarship, Date endScholarship, Project project, int overWorked, String name, String email) {
        super(startScholarship, endScholarship, project, overWorked, name, email);
    }

    /**
     * Construtor de Mestre.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     */
    public Masters(Date startScholarship, Date endScholarship, int overWorked, String name, String email) {
        super(startScholarship, endScholarship, overWorked, name, email);
    }

    /**
     * Método get para obter a lista de orientadores.
     *
     * @return listAdvisor = lista de orientadores
     */
    public ArrayList<Teacher> getListAdvisor() {
        return listAdvisor;
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
     * Método toString que retorna todas as informações numa string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Master:"
                + //"Masters=" + masters +
                //", numStudent=" + numStudent +
                //", startScholarship=" + startScholarship +
                //", endScholarship=" + endScholarship +
                  name 
                ;
    }

}
