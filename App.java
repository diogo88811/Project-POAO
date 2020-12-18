package project1;

import java.io.*;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe onde é iniciado o programa.
 *
 * @author João Marques e Diogo Martins
 */
public class App implements Serializable {

    ArrayList<Person> listPerson = new ArrayList<>();
    ArrayList<Project> listTasks = new ArrayList<>();
    ArrayList<Project> listProject = new ArrayList<>();

    private GUITeste gui;

    /**
     * Método principal (main), cria uma nova aplicação.
     *
     * @param args
     */
    public static void main(String[] args) {
        new App();
    }

    /**
     * Método aplicação, lê os dados do ficheiro objeto e inicia a interface.
     */
    public App() {

        readObjectFile();

        gui = new GUITeste(this);
        gui.setVisible(true);

        while (true) {
            System.out.println("\t Menu \t");
            System.out.println("0: Exit");
            System.out.println("2. Print for debug ");
            Scanner sc = new Scanner(System.in);

            int option = sc.nextInt();

            if (option == 0) {
                out();
            }

            if (option == 2) {
                System.out.println("Print List Person:");
                System.out.println("------------------[DEBUG]------------");
                for (Person x : listPerson) {
                    System.out.println("" + x);
                    System.out.println(x.getListTasks());
                }
                for (Project x : listTasks) {
                    System.out.println("" + x.getListTasks());
                }

            }

        }

    }

    /**
     * Método para ler os dados do ficheiro txt. No fim da leitura carraga os
     * dados para o ficheiro objecto.
     */
    private void readfile(File f) {

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(";");
                if (data[0].equals("project")) {
                    String date[] = data[3].split("/");
                    int day = Integer.parseInt(date[0]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[2]);
                    int duration = Integer.parseInt(data[4]);
                    String endDate[] = data[5].split("/");
                    int endDay = Integer.parseInt(endDate[0]);
                    int endMonth = Integer.parseInt(endDate[1]);
                    int endYear = Integer.parseInt(endDate[2]);

                    Project newProject = new Project(data[1], data[2], new Date(day, month, year), duration, new Date(endDay, endMonth, endYear));
                    System.out.println(newProject);
                    listProject.add(newProject);

                }

                if (data[0].equals("task")) {
                    String date[] = data[3].split("/");
                    int day = Integer.parseInt(date[0]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[2]);
                    double duration = Double.valueOf(data[5]);
                    String endDate[] = data[4].split("/");
                    int endDay = Integer.parseInt(endDate[0]);
                    int endMonth = Integer.parseInt(endDate[1]);
                    int endYear = Integer.parseInt(endDate[2]);
                    for (Project p : listProject) {
                        if (p.getAcronym().equals(data[1])) {
                            if ("Design".equals(data[2])) {
                                Task t = new Design(new Date(day, month, year), new Date(endDay, endMonth, endYear), data[6], 0, duration);
                                p.getListTasks().add(t);
                                System.out.println("charge");
                                System.out.println(p.getListTasks());
                            }
                            if ("Documentation".equals(data[2])) {
                                Task t = new Documentation(new Date(day, month, year), new Date(endDay, endMonth, endYear), data[6], 0, duration);
                                p.getListTasks().add(t);
                            }

                            if ("Development".equals(data[2])) {
                                Task t = new Development(new Date(day, month, year), new Date(endDay, endMonth, endYear), data[6], 0, duration);
                                p.getListTasks().add(t);
                            }
                        }
                    }
                }

                if (data[0].equals("teacher")) {
                    int verify = 0;
                    int num = Integer.parseInt(data[3]);
                    if (!"0".equals(data[5])) {
                        Teacher newTeacher = new Teacher(data[4], num, data[1], data[2]);
                        String projects[] = data[5].split("-");
                        for (int i = 1; i <= Integer.parseInt(projects[0]); i++) {
                            for (Project p : listTasks) {
                                if (p.getAcronym().equals(projects[i])) {
                                    p.getListPersons().add(newTeacher);
                                    verify = 1;
                                }
                            }
                        }
                        if (verify == 0) {
                            for (int i = 1; i <= Integer.parseInt(projects[0]); i++) {
                                for (Project p : listProject) {
                                    if (p.getAcronym().equals(projects[i])) {
                                        p.getListPersons().add(newTeacher);
                                        verify = 1;
                                    }
                                }
                            }
                        }

                        listPerson.add(newTeacher);

                        String tasks[] = data[6].split("#");

                        for (int i = 1; i <= Integer.parseInt(tasks[0]); i++) {
                            String task[] = tasks[i].split("-");
                            String taskName = task[0];
                            String taskAcro = task[1];
                            String dateS[] = task[2].split("/");
                            int sDay = Integer.parseInt(dateS[0]);
                            int sMonth = Integer.parseInt(dateS[1]);
                            int sYear = Integer.parseInt(dateS[2]);

                            String dateE[] = task[3].split("/");
                            int eDay = Integer.parseInt(dateE[0]);
                            int eMonth = Integer.parseInt(dateE[1]);
                            int eYear = Integer.parseInt(dateE[2]);

                            double execRate = Double.valueOf(task[4]);

                            if (taskName.equals("Design")) {
                                Task personTask = new Design(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newTeacher, execRate);
                                newTeacher.getListTasks().add(personTask);

                            }
                            if (taskName.equals("Documentation")) {
                                Task personTask = new Documentation(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newTeacher, execRate);
                                newTeacher.getListTasks().add(personTask);
                            }
                            if (taskName.equals(("Development"))) {
                                Task personTask = new Development(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newTeacher, execRate);
                                newTeacher.getListTasks().add(personTask);
                                System.out.println("ola");
                            }

                        }
                    } else {
                        Teacher newTeacher = new Teacher(data[4], num, data[1], data[2]);
                        listPerson.add(newTeacher);
                    }

                }

                if (data[0].equals("licenced")) {
                    String startDate[] = data[3].split("/");
                    int startDay = Integer.parseInt(startDate[0]);
                    int startMonth = Integer.parseInt(startDate[1]);
                    int startYear = Integer.parseInt(startDate[2]);

                    String endDate[] = data[4].split("/");
                    int endDay = Integer.parseInt(endDate[0]);
                    int endMonth = Integer.parseInt(endDate[0]);
                    int endYear = Integer.parseInt(endDate[0]);

                    int verify = 0;
                    if (!"0".equals(data[5])) {
                        String acronym = data[5];
                        String advisor[] = data[6].split("-");
                        ArrayList<Teacher> listAdvisor = new ArrayList<>();
                        for (int i = 1; i < Integer.parseInt(advisor[0]); i++) {
                            for (Person adv : listPerson) {
                                if (adv.getPayValue() == 0) {
                                    Teacher advi = (Teacher) adv;
                                    if (advi.getNum() == Integer.parseInt(advisor[i])) {
                                        listAdvisor.add(advi);
                                    }

                                }
                            }

                        }
                        for (Project p : listTasks) {
                            if (acronym.equals(p.getAcronym())) {
                                Project rightProject = p;
                                Licenced newLicenced = new Licenced(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), rightProject, 1, data[1], data[2], listAdvisor);
                                p.getListPersons().add(newLicenced);
                                listPerson.add(newLicenced);
                                verify = 1;
                                String tasks[] = data[7].split("#");

                                for (int i = 1; i <= Integer.parseInt(tasks[0]); i++) {
                                    String task[] = tasks[i].split("-");
                                    String taskName = task[0];
                                    String taskAcro = task[1];
                                    String dateS[] = task[2].split("/");
                                    int sDay = Integer.parseInt(dateS[0]);
                                    int sMonth = Integer.parseInt(dateS[1]);
                                    int sYear = Integer.parseInt(dateS[2]);

                                    String dateE[] = task[3].split("/");
                                    int eDay = Integer.parseInt(dateE[0]);
                                    int eMonth = Integer.parseInt(dateE[1]);
                                    int eYear = Integer.parseInt(dateE[2]);
                                    double execRate = Double.valueOf(task[4]);

                                    if (taskName.equals("Design")) {
                                        Task personTask = new Design(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newLicenced, execRate);
                                        newLicenced.getListTasks().add(personTask);
                                    }
                                    if (taskName.equals("Documentation")) {
                                        Task personTask = new Documentation(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newLicenced, execRate);
                                        newLicenced.getListTasks().add(personTask);
                                    }
                                    if (taskName.equals(("Development"))) {
                                        Task personTask = new Development(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newLicenced, execRate);
                                        newLicenced.getListTasks().add(personTask);
                                    }

                                }
                            }
                        }
                        if (verify == 0) {
                            for (Project p : listProject) {
                                if (acronym.equals(p.getAcronym())) {
                                    Project rightProject = p;
                                    Licenced newLicenced = new Licenced(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), rightProject, 1, data[1], data[2], listAdvisor);
                                    p.getListPersons().add(newLicenced);
                                    listPerson.add(newLicenced);
                                }
                            }
                        }

                    } else {
                        Licenced newLicenced = new Licenced(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), 0, data[1], data[2]);
                        System.out.println(newLicenced);
                        listPerson.add(newLicenced);
                    }
                }

                if (data[0].equals("master")) {
                    String startDate[] = data[3].split("/");
                    int startDay = Integer.parseInt(startDate[0]);
                    int startMonth = Integer.parseInt(startDate[1]);
                    int startYear = Integer.parseInt(startDate[2]);

                    String endDate[] = data[4].split("/");
                    int endDay = Integer.parseInt(endDate[0]);
                    int endMonth = Integer.parseInt(endDate[0]);
                    int endYear = Integer.parseInt(endDate[0]);

                    int verify = 0;

                    if (!"0".equals(data[5])) {
                        String acronym = data[5];
                        String advisor[] = data[6].split("-");
                        ArrayList<Teacher> listAdvisor = new ArrayList<>();
                        for (int i = 1; i < Integer.parseInt(advisor[0]); i++) {
                            for (Person adv : listPerson) {
                                if (adv.getPayValue() == 0) {
                                    Teacher advi = (Teacher) adv;
                                    if (advi.getNum() == Integer.parseInt(advisor[i])) {
                                        listAdvisor.add(advi);
                                    }

                                }
                            }

                        }

                        for (Project p : listTasks) {
                            if (acronym.equals(p.getAcronym())) {
                                Project rightProject = p;
                                Masters newMasters = new Masters(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), rightProject, 1, data[1], data[2], listAdvisor);
                                p.getListPersons().add(newMasters);
                                listPerson.add(newMasters);
                                verify = 1;
                                String tasks[] = data[7].split("#");

                                for (int i = 1; i <= Integer.parseInt(tasks[0]); i++) {
                                    String task[] = tasks[i].split("-");
                                    String taskName = task[0];
                                    String taskAcro = task[1];
                                    String dateS[] = task[2].split("/");
                                    int sDay = Integer.parseInt(dateS[0]);
                                    int sMonth = Integer.parseInt(dateS[1]);
                                    int sYear = Integer.parseInt(dateS[2]);

                                    String dateE[] = task[3].split("/");
                                    int eDay = Integer.parseInt(dateE[0]);
                                    int eMonth = Integer.parseInt(dateE[1]);
                                    int eYear = Integer.parseInt(dateE[2]);

                                    double execRate = Double.valueOf(task[4]);

                                    if (taskName.equals("Design")) {
                                        Task personTask = new Design(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newMasters, execRate);
                                        newMasters.getListTasks().add(personTask);
                                    }
                                    if (taskName.equals("Documentation")) {
                                        Task personTask = new Documentation(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newMasters, execRate);
                                        newMasters.getListTasks().add(personTask);
                                    }
                                    if (taskName.equals(("Development"))) {
                                        Task personTask = new Development(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newMasters, execRate);
                                        newMasters.getListTasks().add(personTask);
                                    }

                                }

                            }

                        }
                        if (verify == 0) {
                            for (Project p : listProject) {
                                if (acronym.equals(p.getAcronym())) {
                                    Project rightProject = p;
                                    Masters newMasters = new Masters(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), rightProject, 1, data[1], data[2], listAdvisor);
                                    p.getListPersons().add(newMasters);
                                    listPerson.add(newMasters);
                                }
                            }
                        }

                    } else {
                        Masters newMasters = new Masters(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), 0, data[1], data[2]);
                        System.out.println(newMasters);
                        listPerson.add(newMasters);
                    }
                }

                if (data[0].equals("doctorate")) {
                    String startDate[] = data[3].split("/");
                    int startDay = Integer.parseInt(startDate[0]);
                    int startMonth = Integer.parseInt(startDate[1]);
                    int startYear = Integer.parseInt(startDate[2]);

                    String endDate[] = data[4].split("/");
                    int endDay = Integer.parseInt(endDate[0]);
                    int endMonth = Integer.parseInt(endDate[0]);
                    int endYear = Integer.parseInt(endDate[0]);

                    int verify = 0;

                    if (!"0".equals(data[5])) {
                        String acronym = data[5];

                        for (Project p : listTasks) {
                            if (acronym.equals(p.getAcronym())) {
                                Project rightProject = p;
                                Doctorate newDoctorate = new Doctorate(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), rightProject, 1, data[1], data[2]);
                                p.getListPersons().add(newDoctorate);
                                listPerson.add(newDoctorate);
                                verify = 1;
                                String tasks[] = data[6].split("#");

                                for (int i = 1; i <= Integer.parseInt(tasks[0]); i++) {
                                    String task[] = tasks[i].split("-");
                                    String taskName = task[0];
                                    String taskAcro = task[1];
                                    String dateS[] = task[2].split("/");
                                    int sDay = Integer.parseInt(dateS[0]);
                                    int sMonth = Integer.parseInt(dateS[1]);
                                    int sYear = Integer.parseInt(dateS[2]);

                                    String dateE[] = task[3].split("/");
                                    int eDay = Integer.parseInt(dateE[0]);
                                    int eMonth = Integer.parseInt(dateE[1]);
                                    int eYear = Integer.parseInt(dateE[2]);

                                    double execRate = Double.valueOf(task[4]);

                                    if (taskName.equals("Design")) {
                                        Task personTask = new Design(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newDoctorate, execRate);
                                        newDoctorate.getListTasks().add(personTask);
                                    }
                                    if (taskName.equals("Documentation")) {
                                        Task personTask = new Documentation(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newDoctorate, execRate);
                                        newDoctorate.getListTasks().add(personTask);
                                    }
                                    if (taskName.equals(("Development"))) {
                                        Task personTask = new Development(taskAcro, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), newDoctorate, execRate);
                                        newDoctorate.getListTasks().add(personTask);
                                    }

                                }

                            }
                        }
                        if (verify == 0) {
                            for (Project p : listProject) {
                                if (acronym.equals(p.getAcronym())) {
                                    Project rightProject = p;
                                    Doctorate newDoctorate = new Doctorate(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), rightProject, 1, data[1], data[2]);
                                    p.getListPersons().add(newDoctorate);
                                    listPerson.add(newDoctorate);
                                }
                            }
                        }
                    } else {

                        Doctorate newDoctorate = new Doctorate(new Date(startDay, startMonth, startYear), new Date(endDay, endMonth, endYear), 0, data[1], data[2]);
                        System.out.println(newDoctorate);
                        listPerson.add(newDoctorate);
                    }
                }

                if (data[0].equals("ip")) {
                    int verify = 0;
                    int num = Integer.parseInt(data[3]);
                    Teacher newTeacher = new Teacher(data[4], num, data[1], data[2]);
                    String projects[] = data[5].split("-");
                    for (Project p : listTasks) {
                        if (p.getAcronym().equals(projects[0])) {
                            p.setIp(newTeacher);
                            verify = 1;
                        }
                    }
                    if (verify == 0) {
                        for (Project p : listProject) {
                            if (p.getAcronym().equals(projects[0])) {
                                p.setIp(newTeacher);
                            }
                        }
                    }

                    listPerson.add(newTeacher);
                }
            }
            deleteSamePerson();
            loadTasksToProject();
            writeObjectFile();

        } catch (FileNotFoundException ex) {
            System.out.println("Error open file\n");
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método para ler os dados do ficheiro objeto. Caso não consiga lê do
     * ficheiro de txt original.
     */
    private void readObjectFile() {
        File f = new File("data.txt");

        try {
            FileInputStream fi = new FileInputStream("myObjects.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            listPerson = (ArrayList<Person>) oi.readObject();
            listProject = (ArrayList<Project>) oi.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Object file not found!");
            System.out.println("Trying to open original txt file...");
            readfile(f);

        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método para escrever os dados no ficheiro objeto.
     */
    public void writeObjectFile() {

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            ArrayList<Project> listProjects = new ArrayList<>();
            int i = 0;

            while (i < listProject.size()) {
                listProjects.add(listProject.get(i));
                i++;
            }

            i = 0;
            while (i < listTasks.size()) {
                listProjects.add(listTasks.get(i));
                i++;
            }

            // Write objects to file
            o.writeObject(listPerson);
            o.writeObject(listProject);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Método para cria um projecto na aplicação.
     *
     * @param name = nome do projeto
     * @param acron = acrónimo do projecto
     * @param startDate = data de início
     * @param endDate = data de fim
     * @param ip = ip do professor responsável
     * @param duration = duração do projeto
     */
    public void createProject(String name, String acron, Date startDate, Date endDate, Teacher ip, double duration) {
        System.out.println("poject add with sucesses");
        Project p = new Project(name, acron, startDate, endDate, duration, ip);
        System.out.println(p);
        listProject.add(p);
        writeObjectFile();
    }

    /**
     * Método para imprimir uma mensagem de despedida ao clicar na opção do menu
     * exit.
     */
    private void out() {
        System.out.println("bye!!!");
        exit(0);
    }

    /**
     * Método para carregar as tarefas nos projectos.
     */
    private void loadTasksToProject() {
        for (Project pr : listProject) {
            for (Person p : pr.getListPersons()) {
                for (Task t : p.getListTasks()) {
                    pr.getListTasks().add(t);
                }
            }
        }
        writeObjectFile();
        System.out.println("terminei a load task");
    }

    /**
     * Método para fazer guardar alguma alteração feita no programa escrevendo
     * no ficheiro objecto.
     */
    public void save() {
        writeObjectFile();
    }

    /**
     * Método para criar uma pessoa na aplicação.
     *
     * @param name = nome da pessoa
     * @param email = email da pessoa
     * @param type = tipo da pessoa
     * @param startScholarship = início da bolsa
     * @param endScholarship = fim da bolsa
     * @param researchArea = àrea de investigação
     * @param num = número de professor
     * @return boolean = true se foi adicionado com sucesso, false caso
     * contrário
     */
    public boolean createPerson(String name, String email, String type, Date startScholarship, Date endScholarship, String researchArea, int num) {
        if (type.equals("Licenced")) {
            Licenced l = new Licenced(startScholarship, endScholarship, null, 0, name, email);
            listPerson.add(l);
            return true;
        }
        if (type.equals("Masters")) {
            Masters m = new Masters(startScholarship, endScholarship, null, 0, name, email);
            listPerson.add(m);
            return true;
        }
        if (type.equals("Doctorate")) {
            Doctorate d = new Doctorate(startScholarship, endScholarship, null, 0, name, email);
            listPerson.add(d);
            return true;
        }
        if (type.equals("Teacher")) {
            Teacher t = new Teacher(researchArea, num, name, email);
            listPerson.add(t);
            System.out.println("Teacher create");
            return true;
        }

        return false;
    }

    /**
     * Método para remove as pessoas repetidas que foram carregadas mais que uma
     * vez do ficheiro txt.
     */
    private void deleteSamePerson() {
        for (int i = 0; i < listPerson.size(); i++) {
            for (int k = 0; k < listPerson.size(); k++) {
                if (listPerson.get(i).getEmail().equals(listPerson.get(k).getEmail())) {
                    if (i != k) {
                        listPerson.remove(k);
                    }
                }
            }
        }
    }

}
