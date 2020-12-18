package project1;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe que define a Interface na aplicação.
 *
 * @author João Marques e Diogo Martins
 */
public class GUITeste extends JFrame implements Serializable {

    public App app;
    private JPanel jPanel;
    private JButton butProjectNConcluded, butAddProject, butProjectConcluded, butCreatePerson;

    /**
     * Método da Interface.
     *
     * @param app = aplição do programa
     */
    public GUITeste(App app) {
        this.app = app;
        this.setTitle("Ciscu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(400, 400));
        this.setLocationRelativeTo(null);

        butProjectNConcluded = new JButton("Project none concluded");
        butProjectConcluded = new JButton("Project Concluded");
        butAddProject = new JButton("New Project");
        butCreatePerson = new JButton("Create Person");
        jPanel = new JPanel();

        butCreatePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPerson(e);

            }
        });

        butProjectNConcluded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProjectNC(e);

            }
        });

        butAddProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProject(e);
            }
        });

        butProjectConcluded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProjectC(e);

            }
        });

        jPanel.setLayout(new GridLayout(4, 1));
        jPanel.add(butProjectNConcluded);
        jPanel.add(butAddProject);
        jPanel.add(butProjectConcluded);
        jPanel.add(butCreatePerson);
        this.add(jPanel);
    }

    /**
     * Método para mostrar ecra para criar pessoas.
     *
     * @param e = ActionEvent
     */
    private void createPerson(ActionEvent e) {
        showCreatePerson w = new showCreatePerson(this);
        w.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Método para mostrar o ecra dos os projectos não concluidos.
     *
     * @param e = ActionEvent
     */
    private void showProjectNC(ActionEvent e) {
        showProjectNConcluded w = new showProjectNConcluded(this);
        w.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Método para mostrar ecra para criar projecto.
     *
     * @param e = ActionEvent
     */
    private void createProject(ActionEvent e) {
        createP w = new createP(this);
        w.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Método da para mostrar o ecra dos os projectos concluidos.
     *
     * @param e = ActionEvent
     */
    private void showProjectC(ActionEvent e) {
        showProjectConcluded w = new showProjectConcluded(this);
        w.setVisible(true);
        this.setVisible(false);
    }

}

/**
 * Classe para criar pessoas.
 */
class showCreatePerson extends JFrame {

    private GUITeste gui;
    private JButton butAddTeacher, butAddStudent, butBack;
    private JPanel panel;

    /**
     * Método para mostrar ecra para criar pessoas.
     *
     * @param gui = interface
     */
    public showCreatePerson(GUITeste gui) {
        this.gui = gui;
        this.setTitle("Create Person");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        butAddStudent = new JButton("Add a Student");
        butAddTeacher = new JButton("Add Tecaher");
        butBack = new JButton("Back");

        butBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                gui.setVisible(true);
                panel.setVisible(false);
            }
        });

        butAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("add Student");;
                addStudent(gui.app);
            }
        });

        butAddTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addTeacher();
            }
        });

        panel.setLayout(new GridLayout(3, 1));
        panel.add(butAddStudent);
        panel.add(butAddTeacher);
        panel.add(butBack);
        panel.setVisible(true);
        this.add(panel);

    }

    /**
     * Método para adicionar um professor.
     */
    private void addTeacher() {
        JFrame frame = new JFrame("Add Teacher");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        JLabel lName = new JLabel("Name");
        JTextField name = new JTextField();

        JLabel lEmail = new JLabel("Email");
        JTextField email = new JTextField();

        JLabel lNum = new JLabel("Number");
        JTextField num = new JTextField();

        JLabel lResearchArea = new JLabel("Research Area");
        JTextField researchArea = new JTextField();

        JButton create = new JButton("Create");

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name1 = name.getText();
                String email1 = email.getText();
                int num1 = Integer.parseInt(num.getText());
                String researchArea1 = researchArea.getText();
                gui.app.createPerson(name1, email1, "Teacher", null, null, researchArea1, num1);
                gui.app.save();
                frame.setVisible(false);
            }
        });

        frame.setLayout(new GridLayout(9, 1));
        frame.add(lName);
        frame.add(name);

        frame.add(lNum);
        frame.add(num);

        frame.add(lEmail);
        frame.add(email);

        frame.add(lResearchArea);
        frame.add(researchArea);

        frame.add(create);

        frame.setVisible(true);
    }

    /**
     * Método para adicionar um professor.
     *
     * @param app = aplicação
     */
    private void addStudent(App app) {
        JFrame frame = new JFrame("Add a Student");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        JLabel lName = new JLabel("Name");
        JTextField name = new JTextField();

        JLabel lStartDate = new JLabel("Scholarship Start Date (dd/mm/yyyy)");
        JTextField startDate = new JTextField();

        JLabel lEndDate = new JLabel("Scholarship End Date (dd/mm/yyyy)");
        JTextField endDate = new JTextField();

        JLabel lEmail = new JLabel("Email");
        JTextField email = new JTextField();

        JLabel lAdvisor = new JLabel("Advisors");

        JButton create = new JButton("Create");

        DefaultListModel listModel = new DefaultListModel();

        listModel.addElement("Licenced");
        listModel.addElement("Development");
        listModel.addElement("Doctorate");

        JList jAList = new JList(listModel);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Date d = new Date();
                String name1 = name.getText();
                String email1 = email.getText();
                String type = jAList.getSelectedValue().toString();
                String sDate[] = startDate.getText().split("/");
                String eDate[] = endDate.getText().split("/");
                if (d.validateDate(startDate.getText()) && d.validateDate(endDate.getText())) {
                    int sDay = Integer.parseInt(sDate[0]);
                    int sMonth = Integer.parseInt(sDate[1]);
                    int sYear = Integer.parseInt(sDate[2]);
                    int eDay = Integer.parseInt(eDate[0]);
                    int eMonth = Integer.parseInt(eDate[1]);
                    int eYear = Integer.parseInt(eDate[2]);

                    if (!d.verifyDateBeforeCurrent(new Date(eDay, eMonth, eYear)) && d.verifyFirstDateBeforeSecondDate(new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear))) {
                        gui.app.createPerson(name1, email1, type, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), null, 0);
                        gui.app.save();
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid aqui dates!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid aqui2 dates!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        frame.setLayout(new GridLayout(12, 1));

        frame.add(scrollPane2);

        frame.add(lName);
        frame.add(name);

        frame.add(lStartDate);
        frame.add(startDate);

        frame.add(lEndDate);
        frame.add(endDate);

        frame.add(lEmail);
        frame.add(email);

        frame.add(create);

        frame.setVisible(true);
    }
}

/**
 * Classe para mostrar projectos concluidos.
 */
class showProjectConcluded extends JFrame {

    private GUITeste gui;
    private JPanel panel;
    private JButton buttonBack;
    private JList jList;
    DefaultListModel listValues;

    /**
     * Método para mostrar projectos conluidos.
     *
     * @param gui = interface
     */
    public showProjectConcluded(GUITeste gui) {
        this.gui = gui;
        this.setTitle("List Project Concluded");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        jList = new JList();
        createList();

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jListSelectionListener(evt);
            }
        });

        panel = new JPanel();
        buttonBack = new JButton("Back");
        JScrollPane jListScroller = new JScrollPane(jList);
        jListScroller.setBounds(50, 50, 300, 100);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnActionPerformed();
            }
        });

        panel.add(buttonBack);
        panel.add(jListScroller);

        this.add(panel);
    }

    /**
     * Método chamado depois de cliclar no botão.
     */
    private void btnActionPerformed() {

        gui.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Método para criar lista de elementos.
     */
    private void createList() {
        listValues = new DefaultListModel();

        for (Project p : gui.app.listProject) {
            if (p.listConcluded()) {
                listValues.addElement(p);
            }
        }
        jList.setModel(listValues);
    }

    /**
     * Método para selecionar uma opção.
     *
     * @param evt = listener
     */
    private void jListSelectionListener(ListSelectionEvent evt) {

        Project project = (Project) jList.getSelectedValue();
        for (Project p : gui.app.listProject) {
            if (p == project) {
                System.out.println(p.getName());
                System.out.println(p.getAcronym());
                JFrame frame = new JFrame(p.getName());
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setBounds(400, 400, 400, 400);
                frame.setLocationRelativeTo(null);

                JLabel name = new JLabel("Name of the Project: " + p.getName());
                JLabel acronym = new JLabel("Acronym of the Project: " + p.getAcronym());
                JLabel startDate = new JLabel("Start date: " + p.getStartDate());
                JLabel duration = new JLabel("Duration: " + p.getDuration());
                JLabel ip = new JLabel("Main Inves: " + p.getIp());

                frame.add(name);
                frame.add(acronym);
                frame.add(startDate);
                frame.add(duration);
                frame.add(ip);
                frame.setLayout(new GridLayout(5, 1));
                frame.setVisible(true);
            }
        }
        System.out.println("Select a Project: " + project.getName() + "!!!");
    }
}

/**
 * Classe para mostrar projectos não concluidos.
 */
class showProjectNConcluded extends JFrame {

    private GUITeste gui;
    private JPanel panel;
    private JButton buttonBack, butSelect;
    private JList jList;
    private Project project;
    DefaultListModel listValues;

    /**
     * Método para mostrar projectos não conluidos.
     *
     * @param gui = interface
     */
    public showProjectNConcluded(GUITeste gui) {
        this.gui = gui;
        this.setTitle("List Projects None Concluded");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        jList = new JList();
        createList();

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jListSelectionListener(evt);
            }
        });

        panel = new JPanel();
        buttonBack = new JButton("Back");
        butSelect = new JButton("Select");
        JScrollPane jListScroller = new JScrollPane(jList);
        jListScroller.setBounds(50, 50, 300, 100);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnActionPerformed();
            }
        });

        butSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnActionPerformed();
            }
        });

        panel.add(buttonBack);
        panel.add(jListScroller);

        this.add(panel);

    }

    /**
     * Método chamado depois de cliclar no botão.
     */
    private void btnActionPerformed() {

        gui.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Método para criar lista.
     */
    private void createList() {

        listValues = new DefaultListModel();
        System.out.println(gui.app.listProject);
        for (Project p : gui.app.listProject) {
            if (p.listNConcluded()) {
                listValues.addElement(p);
            }
        }
        jList.setModel(listValues);
    }

    /**
     * Método para selecionar uma opção.
     *
     * @param evt = listener
     */
    private void jListSelectionListener(ListSelectionEvent evt) {

        Project project = (Project) jList.getSelectedValue();
        for (Project p : gui.app.listProject) {
            if (p == project) {
                System.out.println(p.getName());
                System.out.println(p.getAcronym());
                JFrame frame = new JFrame(p.getName());
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setBounds(400, 400, 400, 400);
                frame.setLocationRelativeTo(null);

                JLabel name = new JLabel("Name of the Project: " + p.getName());
                JLabel acronym = new JLabel("Acronym of the Project: " + p.getAcronym());
                JLabel startDate = new JLabel("Start date: " + p.getStartDate());
                JLabel duration = new JLabel("Duration: " + p.getDuration());
                JLabel ip = new JLabel("Main Inves: " + p.getIp());
                JButton projectValue = new JButton("Cost");
                JButton associatePeople = new JButton("Associate Person to the Project");
                JButton butListTasks = new JButton("List Tasks");
                JButton butCreateTask = new JButton("Create Task");
                JButton butEliminateTask = new JButton("Eliminate Task");
                JButton butAssignTasks = new JButton("Assign Tasks");
                JButton butUpdateExecRate = new JButton("Update Execution Rate");
                JButton butListUnstartTasks = new JButton("List Unstarted Tasks");
                JButton butListConcludedTasks = new JButton("List Concluded Tasks");
                JButton butFinishProject = new JButton("Finish Project");
                JButton butDeletePerson = new JButton("Delete Person");
                JButton butListTaskNconCludedOnDate = new JButton("List Task Unfinished on Date");

                frame.add(name);
                frame.add(acronym);
                frame.add(startDate);
                frame.add(duration);
                frame.add(ip);
                frame.add(associatePeople);
                frame.add(butDeletePerson);
                frame.add(butListTasks);
                frame.add(butCreateTask);//
                frame.add(butEliminateTask);//
                frame.add(butAssignTasks);//
                frame.add(butUpdateExecRate); //
                frame.add(butListUnstartTasks);      //faltam os actionslistener e as funções
                frame.add(butListConcludedTasks);
                frame.add(butListTaskNconCludedOnDate);
                frame.add(projectValue);
                frame.add(butFinishProject);//
                frame.setLayout(new GridLayout(17, 1));
                frame.setVisible(true);

                butFinishProject.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        finishProject(gui.app, p);
                    }
                });

                associatePeople.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        associatePeople(gui.app, p);
                    }
                });

                butListTaskNconCludedOnDate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        listTaskNconCludedOnDate(p);
                    }
                });

                butUpdateExecRate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        updateExecRate(p, gui.app);
                    }
                });
                butDeletePerson.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        deletePerson(p, gui.app);
                    }
                });

                projectValue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        showCost(p);
                    }
                });

                butListTasks.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        listTask(p);
                    }
                });

                butListUnstartTasks.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        listUnstartedTask(p);
                    }
                });

                butListConcludedTasks.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        listConcludedTasks(p);
                    }
                });

                butEliminateTask.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        eliminateTasks(p, gui.app);
                    }
                });
                butCreateTask.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        createTask(p, gui.app);
                    }
                });

                butAssignTasks.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        assignTasks(p, gui.app);
                    }
                });
            }

        }
        System.out.println("Select a Project: " + project.getName() + "!!!");
    }

    /**
     * Método para acabar um projecto.
     *
     * @param app = aplicação
     * @param project = projecto
     */
    private void finishProject(App app, Project project) {
        if (project.terminateProject()) {
            gui.app.save();
            JOptionPane.showMessageDialog(null, "Project Finished", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Impossible to finish: Don´t have Tasks!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Método para associar pessoa ao projecto.
     *
     * @param app = aplicação
     * @param project = projecto
     */
    private void associatePeople(App app, Project project) {
        this.project = project;
        System.out.println("Associate People");
        JFrame frame = new JFrame("Associate People");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);
        DefaultListModel listModel = new DefaultListModel();
        JButton associatel = new JButton("Associate");

        System.out.println(project.getListPersons());
        for (Person p : gui.app.listPerson) {
            System.out.println(p);
            if (p.isAvaible(project)) {
                if (!project.getListPersons().contains(p)) {
                    listModel.addElement(p);
                }
            }
        }

        JList jAList = new JList(listModel);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        frame.setLayout(new GridLayout(2, 1));
        frame.add(scrollPane2);
        frame.add(associatel);
        frame.setVisible(true);

        associatel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Person person = (Person) jAList.getSelectedValue();
                if (person.getPayValue() > 0 && person.getPayValue() != 1200) {

                    int verify = 0;
                    for (Person per : project.getListPersons()) {
                        if (per.getPayValue() == 0) {
                            verify++;
                        }
                    }

                    if (verify != 0) {
                        ScholarshipStudent s = (ScholarshipStudent) person;
                        frame.setVisible(false);
                        JFrame frame1 = new JFrame("Chose Advisors");
                        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        frame1.setBounds(400, 400, 400, 400);
                        frame1.setLocationRelativeTo(null);
                        JButton butSelect = new JButton("Select");
                        DefaultListModel listModel1 = new DefaultListModel();

                        for (Person person1 : project.getListPersons()) {
                            if (person1.isTeacher()) {

                                listModel1.addElement(person1);
                            }

                        }
                        JList jAList1 = new JList(listModel1);
                        JScrollPane scrollPane3 = new JScrollPane(jAList1);

                        butSelect.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                Teacher advi = (Teacher) jAList1.getSelectedValue();
                                System.out.println(advi);
                                if (s.getPayValue() == 800) {
                                    Licenced l = (Licenced) s;
                                    if (l.getListAdvisor().contains(advi)) {
                                        JOptionPane.showMessageDialog(null, "Already Assigned", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                                    } else {
                                        l.getListAdvisor().add(advi);
                                        project.getListPersons().add(l);
                                        gui.app.save();
                                        frame1.setVisible(false);
                                    }

                                } else {
                                    Masters m = (Masters) s;
                                    if (m.getListAdvisor().contains(advi)) {
                                        JOptionPane.showMessageDialog(null, "Already Assigned", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                                    } else {
                                        m.getListAdvisor().add(advi);
                                        project.getListPersons().add(m);
                                        gui.app.save();
                                        frame1.setVisible(false);
                                    }
                                }
                            }
                        });

                        frame1.setLayout(new GridLayout(2, 1));
                        frame1.add(scrollPane3);
                        frame1.add(butSelect);
                        frame1.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "You must have a teacher first!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);

                    }

                } else {
                    project.getListPersons().add(person);
                    gui.app.save();
                    frame.setVisible(false);
                }
            }
        });

    }

    /**
     * Método para listar tarefas de um projecto não conluidas na data.
     *
     * @param project = projecto
     */
    private void listTaskNconCludedOnDate(Project project) {
        this.project = project;
        System.out.println("Update Execution Rate");
        JFrame frame = new JFrame("Task Unfinished on Date");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);
        DefaultListModel listModel = new DefaultListModel();

        for (Task t : project.getListTasks()) {
            if (t.isNConcludedOnDate()) {
                listModel.addElement(t);
            }
        }

        JList jAList = new JList(listModel);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        frame.setLayout(new GridLayout(1, 1));
        frame.add(scrollPane2);

        frame.setVisible(true);
    }

    /**
     * Método para atualizar a taxa de execução de uma tarefa.
     *
     * @param project = projecto
     * @param app = aplicação
     */
    private void updateExecRate(Project project, App app) {
        this.project = project;
        System.out.println("Update Execution Rate");
        JFrame frame = new JFrame("Update Exec Rate");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listModel = new DefaultListModel();

        for (Task t : project.getListTasks()) {
            if (!t.isConcluded()) {
                listModel.addElement(t);
            }
        }

        JList jAList = new JList(listModel);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        JButton update = new JButton("Update");
        JLabel lTax = new JLabel("Rate Execution");
        JTextField tax = new JTextField();

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Task task = (Task) jAList.getSelectedValue();
                double rate = Double.valueOf(tax.getText());
                task.setRateExec(rate);
                app.save();
                frame.setVisible(false);
            }
        });

        frame.setLayout(new GridLayout(4, 1));
        frame.add(scrollPane2);
        frame.add(lTax);
        frame.add(tax);
        frame.add(update);
        frame.setVisible(true);
    }

    /**
     * Método para apagar uma pessoa de um projecto.
     *
     * @param project = projecto
     * @param app = aplicação
     */
    private void deletePerson(Project project, App app) {
        this.project = project;
        System.out.println("Delete Person");
        JFrame frame = new JFrame("Delete Person");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listModel = new DefaultListModel();

        for (Person person : project.getListPersons()) {
            listModel.addElement(person);
        }
        JButton delete = new JButton("Delete Person");

        JList jAList = new JList(listModel);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Person person = (Person) jAList.getSelectedValue();
                project.removePerson(person);
                app.save();
                frame.setVisible(false);
            }
        });

        frame.setLayout(new GridLayout(2, 1));
        frame.add(scrollPane2);
        frame.add(delete);
        frame.setVisible(true);
    }

    /**
     * Método para atribuir uma tarefa a uma pessoa num projecto.
     *
     * @param project = projecto
     * @param app = aplicação
     */
    private void assignTasks(Project project, App app) {
        this.project = project;
        System.out.println("assignTask");
        JFrame frame = new JFrame("Assign Task");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listModel = new DefaultListModel();

        for (Task t : project.getListTasks()) {
            if (t.checkInCharge()) {
                listModel.addElement(t);
            }
        }

        JButton select = new JButton("Select task");

        JList jAList = new JList(listModel);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                JFrame frame1 = new JFrame();
                frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame1.setBounds(400, 400, 400, 400);
                Task t = (Task) jAList.getSelectedValue();
                DefaultListModel listModel1 = new DefaultListModel();

                for (Person p : project.getListPersons()) {
                    if (p.possiblePersons(t, project)) {
                        listModel1.addElement(p);
                    }
                }
                JList jAList1 = new JList(listModel1);
                JScrollPane scrollPane3 = new JScrollPane(jAList1);

                JButton select1 = new JButton("Select");

                select1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        Person p = (Person) jAList1.getSelectedValue();
                        project.assignTasks(p, t);
                        app.save();
                        frame1.setVisible(false);

                    }
                });

                frame1.setLayout(new GridLayout(2, 1));
                frame1.add(scrollPane3);
                frame1.add(select1);
                frame1.setVisible(true);

            }
        });

        frame.setLayout(new GridLayout(2, 1));
        frame.add(scrollPane2);
        frame.add(select);
        frame.setVisible(true);
    }

    /**
     * Método para criar uma tarefa num projecto.
     *
     * @param project = projecto
     * @param app = aplicação
     */
    private void createTask(Project project, App app) {
        this.project = project;
        JFrame frame = new JFrame("Create Task");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listType = new DefaultListModel();

        listType.addElement("Development");
        listType.addElement("Design");
        listType.addElement("Documentation");

        JLabel lName = new JLabel("Name");
        JLabel lSDate = new JLabel("Start Date(dd/mm/yyyy)");
        JLabel lEDate = new JLabel("End Date (dd/mm/yyyy)");
        JLabel lduration = new JLabel("Duration");
        JButton create = new JButton("Create Task");

        JTextField name = new JTextField();
        JTextField sDate = new JTextField();
        JTextField eDate = new JTextField();
        JTextField duration = new JTextField();

        JList jAList = new JList(listType);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        jAList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                String str = jAList.getSelectedValue().toString();
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Date d = new Date();
                if (d.validateDate(sDate.getText()) && d.validateDate(eDate.getText())) {
                    String startDate[] = sDate.getText().split("/");
                    String acron = name.getText();
                    int sDay = Integer.parseInt(startDate[0]);
                    int sMonth = Integer.parseInt(startDate[1]);
                    int sYear = Integer.parseInt(startDate[2]);
                    String str = jAList.getSelectedValue().toString();

                    String endDate[] = eDate.getText().split("/");
                    int eDay = Integer.parseInt(endDate[0]);
                    int eMonth = Integer.parseInt(endDate[1]);
                    int eYear = Integer.parseInt(endDate[2]);

                    try {
                        double dur = Double.valueOf(duration.getText());

                        if (!d.verifyDateBeforeCurrent(new Date(sDay, sMonth, sYear)) && !d.verifyDateBeforeCurrent(new Date(eDay, eMonth, eYear)) && d.verifyFirstDateBeforeSecondDate(new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear)) && !d.verifyFirstDateBeforeSecondDate(new Date(sDay, sMonth, sYear), project.getStartDate()) && d.verifyFirstDateBeforeSecondDate(new Date(eDay, eMonth, eYear), project.getEndDate())) {
                            project.createTask(acron, str, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), dur);
                            app.save();
                            frame.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid dates!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Invalid duration!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                    }

                } else {
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Invalid dates!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        frame.setLayout(new GridLayout(10, 1));
        frame.add(scrollPane2);
        frame.add(lName);
        frame.add(name);
        frame.add(lSDate);
        frame.add(sDate);
        frame.add(lEDate);
        frame.add(eDate);
        frame.add(lduration);
        frame.add(duration);
        frame.add(create);
        frame.setVisible(true);

    }

    /**
     * Método para eliminar uma tarefa de um projecto.
     *
     * @param project = projecto
     * @param app = aplicação
     */
    private void eliminateTasks(Project project, App app) {
        this.project = project;
        JFrame frame = new JFrame("Eliminate Task");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listTasks = new DefaultListModel();

        for (Task t : project.getListTasks()) {
            listTasks.addElement(t);
        }

        JList jAList = new JList(listTasks);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        JButton delete = new JButton("Delete");

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("ola");
                Task t = (Task) jAList.getSelectedValue();
                project.removeTask(t);
                app.save();
                frame.setVisible(false);
                eliminateTasks(project, app);
            }
        });

        frame.setLayout(new GridLayout(2, 1));
        frame.add(scrollPane2);
        frame.add(delete);

        frame.setVisible(true);
    }

    /**
     * Método para listar as tarefas concluidas de um projecto.
     *
     * @param project = projecto
     */
    private void listConcludedTasks(Project project) {
        this.project = project;
        JFrame frame = new JFrame("List Concluded Task");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listUTasks = new DefaultListModel();
        for (Task t : project.getListTasks()) {
            if (t.isConcluded()) {

                listUTasks.addElement(t);
            }
        }
        JList jAList = new JList(listUTasks);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        frame.add(scrollPane2);
        frame.setVisible(true);
    }

    /**
     * Método para listar as tarefas não começadas de um projecto.
     *
     * @param project = projecto
     */
    private void listUnstartedTask(Project project) {
        this.project = project;
        JFrame frame = new JFrame("List Unstarted Project");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listUTasks = new DefaultListModel();
        for (Task t : project.getListTasks()) {
            if (t.isUnstarted()) {
                listUTasks.addElement(t);
            }
        }
        JList jAList = new JList(listUTasks);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        frame.add(scrollPane2);
        frame.setVisible(true);
    }

    /**
     * Método para listar as tarefas de um projecto.
     *
     * @param project = projecto
     */
    private void listTask(Project project) {
        this.project = project;

        JFrame frame = new JFrame("List Task");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setBounds(400, 400, 400, 400);
        frame.setLocationRelativeTo(null);

        DefaultListModel listTasks = new DefaultListModel();
        for (Task t : project.getListTasks()) {
            listTasks.addElement(t);
        }

        JList jAList = new JList(listTasks);
        JScrollPane scrollPane2 = new JScrollPane(jAList);

        JPanel panel = new JPanel();

        JLabel listT = new JLabel("Tasks List");

        panel.add(listT);
        panel.add(scrollPane2);
        panel.setLayout(new GridLayout(2, 1));
        frame.add(panel);
        frame.setVisible(true);

    }

    /**
     * Método para mostrar o custo de um projecto.
     *
     * @param project = projecto
     */
    private void showCost(Project project) {
        this.project = project;
        double cost = project.cost();
        JOptionPane.showMessageDialog(null, "Project Cost: " + cost + "€", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
        System.out.println(cost);
    }
}

/**
 * Classe para criar um projecto.
 */
class createP extends JFrame {

    private GUITeste gui;
    private JTextField projectName, projectAcronym, startDate, duration, endDate;
    private JLabel labelName, labelAcronym, lStartDate, lDuration, ip, lEndDate;
    private JPanel panel;
    private JButton button, butBack;
    private JList jList, jList1;
    DefaultListModel listValues, listValues1;

    /**
     * Método para criar um projecto.
     *
     * @param gui = interface
     */
    public createP(GUITeste gui) {
        this.gui = gui;

        this.setTitle("Create Project");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        jList1 = new JList();
        jList = new JList();
        createList();

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jListSelectionListener(evt);
            }
        });

        JScrollPane jListScroller = new JScrollPane(jList);
        JScrollPane jListScroller1 = new JScrollPane(jList1);

        labelName = new JLabel("Name");

        projectName = new JTextField();
        projectAcronym = new JTextField();
        labelAcronym = new JLabel("Acronym:");
        startDate = new JTextField();
        lStartDate = new JLabel("Start Date (dd/mm/yyyy):");
        duration = new JTextField();
        lDuration = new JLabel("Duration:");
        ip = new JLabel("Main Investigator:");
        endDate = new JTextField();
        lEndDate = new JLabel("End Date (dd/mm/yyyy):");

        button = new JButton("Criar");
        butBack = new JButton("Back");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProject(e);
            }
        });

        butBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(labelName);

        panel.add(projectName);
        panel.add(labelAcronym);
        panel.add(projectAcronym);
        panel.add(lStartDate);
        panel.add(startDate);
        panel.add(lDuration);
        panel.add(duration);
        panel.add(ip);
        panel.add(jListScroller);
        panel.add(lEndDate);
        panel.add(endDate);
        panel.add(button);
        panel.add(butBack);

        this.add(panel);

    }

    /**
     * Método para voltar para o ecrã anterior.
     */
    private void back() {
        gui.setVisible(true);
        this.setVisible(false);
    }

    private void jListSelectionListener(ListSelectionEvent evt) {
        Teacher str = (Teacher) jList.getSelectedValue();
        System.out.println("Select a Person: " + str + "!!!");
    }

    /**
     * Método para criar lista.
     */
    private void createList() {

        listValues = new DefaultListModel();

        System.out.println(gui.app.listPerson);
        for (Person p : gui.app.listPerson) {
            if (p.isTeacher()) {
                listValues.addElement(p);
            }
        }
        jList.setModel(listValues);

        listValues1 = new DefaultListModel<>();

    }

    /**
     * Método para selecionar uma opção.
     *
     * @param e = listener
     */
    private void createProject(ActionEvent e) {
        Date d = new Date();
        String name = projectName.getText();
        String acronym = projectAcronym.getText();
        String sDate[] = startDate.getText().split("[/,-]+");
        Teacher str = (Teacher) jList.getSelectedValue();
        String eDate[] = endDate.getText().split("[/,-]+");
        if (d.validateDate(startDate.getText()) && d.validateDate(endDate.getText())) {
            int sDay = Integer.parseInt(sDate[0]);
            int sMonth = Integer.parseInt(sDate[1]);
            int sYear = Integer.parseInt(sDate[2]);

            int eDay = Integer.parseInt(eDate[0]);
            int eMonth = Integer.parseInt(eDate[1]);
            int eYear = Integer.parseInt(eDate[2]);

            try {
                double duration1 = Double.valueOf(duration.getText());

                if (!d.verifyDateBeforeCurrent(new Date(sDay, sMonth, sYear)) && !d.verifyDateBeforeCurrent(new Date(eDay, eMonth, eYear)) && d.verifyFirstDateBeforeSecondDate(new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear))) {
                    gui.app.createProject(name, acronym, new Date(sDay, sMonth, sYear), new Date(eDay, eMonth, eYear), str, duration1);

                    gui.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid dates!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                gui.setVisible(false);
                JOptionPane.showMessageDialog(null, "Invalid duration!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid dates!", "Janela de mensagem!", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
