package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que define um Licenciado na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Licenced extends ScholarshipStudent implements Serializable {

    private final int payValue = 800;
    private ArrayList<Teacher> listAdvisor = new ArrayList<>();

    /**
     * Construtor de Licenciado.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param project = projecto
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     * @param listAdvisor = lista de orientadores
     */
    public Licenced(Date startScholarship, Date endScholarship, Project project, int overWorked, String name, String email, ArrayList<Teacher> listAdvisor) {
        super(startScholarship, endScholarship, project, overWorked, name, email);
        this.listAdvisor = listAdvisor;
    }

    /**
     * Construtor de Licenciado.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param project = projecto
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     */
    public Licenced(Date startScholarship, Date endScholarship, Project project, int overWorked, String name, String email) {
        super(startScholarship, endScholarship, project, overWorked, name, email);
    }

    /**
     * Construtor de Licenciado.
     *
     * @param startScholarship = início da bola
     * @param endScholarship = fim da bolsa
     * @param overWorked = sobrecarregado
     * @param name = nome
     * @param email = email
     */
    public Licenced(Date startScholarship, Date endScholarship, int overWorked, String name, String email) {
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
     * Método set para definir a lista de orientadores.
     *
     * @param listAdvisor = lista de orientadores
     */
    public void setListAdvisor(ArrayList<Teacher> listAdvisor) {
        this.listAdvisor = listAdvisor;
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
        return "Licensed:"
                + //"Licenced=" + licenced +
                name
                ;
    }

}
