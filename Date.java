package project1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe que define uma data na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class Date implements Serializable {

    private int day;
    private int month;
    private int year;

    /**
     * Método que define uma data.
     *
     * @param day = dia da data
     * @param month = mês da data
     * @param year = ano da data
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
    }

    /**
     * Método get para obter o dia.
     *
     * @return day = dia da data
     */
    public int getDay() {
        return day;
    }

    /**
     * Método set para definir do dia.
     *
     * @param day = dia da data
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Método get para obter o mês.
     *
     * @return month = mês da data
     */
    public int getMonth() {
        return month;
    }

    /**
     * Método set para definir o mês.
     *
     * @param month = mês da data
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Método get para obter o ano.
     *
     * @return year = ano da data
     */
    public int getYear() {
        return year;
    }

    /**
     * Método set para definir o ano.
     *
     * @param year = ano da data
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     * Método que verifica se uma data está antes da data atual.
     *
     * @param inputDate = data para verificar
     * @return boolean = true se estiver antes, false caso contrário
     */
    public Boolean verifyDateBeforeCurrent(Date inputDate) {
        int day = inputDate.getDay();
        System.out.println(day);
        int month = inputDate.getMonth();
        System.out.println(month);
        int year = inputDate.getYear();
        System.out.println(year);
        GregorianCalendar dateToVerify = new GregorianCalendar(year, month, day);

        Calendar rigthNow = Calendar.getInstance();
        int currentDay = rigthNow.get(Calendar.DAY_OF_MONTH);
        int currentMonth = rigthNow.get(Calendar.MONTH) + 1;
        int currentYear = rigthNow.get(Calendar.YEAR);
        System.out.println(currentDay + " " + " " + currentMonth + " " + currentYear);
        System.out.println(inputDate);

        GregorianCalendar currentDate = new GregorianCalendar(currentYear, currentMonth, currentDay);

        //data de entrada menor ou igual à data atual
        System.out.println("Data to verify" + dateToVerify.getTime());
        System.out.println("current date " + currentDate.getTime());
        System.out.println("res " + dateToVerify.compareTo(currentDate));
        if (dateToVerify.compareTo(currentDate) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que verifica se a primeira data de entrada está antes da segunda
     * data de entrada.
     *
     * @param firstDate = primeira data a comparar
     * @param secondDate = seguda data a comparar
     * @return = true se estiver antes, false caso contrário
     */
    public Boolean verifyFirstDateBeforeSecondDate(Date firstDate, Date secondDate) {
        int firstDay = firstDate.getDay();
        int firstMonth = firstDate.getMonth();
        int firstYear = firstDate.getYear();
        GregorianCalendar firstDateToVerify = new GregorianCalendar(firstYear, firstMonth, firstDay);

        int secondDay = secondDate.getDay();
        int secondMonth = secondDate.getMonth();
        int secondYear = secondDate.getYear();
        GregorianCalendar secondDateToVerify = new GregorianCalendar(secondYear, secondMonth, secondDay);

        //data de entrada menor ou igual à data atual
        if (firstDateToVerify.compareTo(secondDateToVerify) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para verificar se a data introduzida é válida.
     *
     * @param input
     * @return = true se for uma data válida, false caso contrário
     */
    public boolean validateDate(String input) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        try {
            LocalDate ld = LocalDate.parse(input, f);
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
