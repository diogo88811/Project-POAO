package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que define um Professor na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Teacher extends Person implements Serializable {

    private String researchArea;
    private int num;
    private int payValue = 0;

    /**
     * Construtor de Professor.
     *
     * @param researchArea = àrea de investigação
     * @param num = número de professor
     * @param name = nome
     * @param email = email
     */
    public Teacher(String researchArea, int num, String name, String email) {
        super(name, email);
        this.researchArea = researchArea;
        this.num = num;
    }

    /**
     * Método get para obter a àrea de investigação.
     * 
     * @return researchArea = àrea de investigação
     */
    public String getResearchArea() {
        return researchArea;
    }

    /**
     * Método get para obter o numero de professor.
     *
     * @return num = número de professor
     */
    public int getNum() {
        return num;
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
        return "Teacher: "+
                 name + '\''
                + //", email='" + email + '\'' +
                " NumTeacher:" + num //", researchArea='" + researchArea + '\'' +
                //'}'
                ;
    }

}
