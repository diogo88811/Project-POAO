package project1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joaoa
 */
public abstract class ScholarshipStudent extends Person implements Serializable {

    /**
     *
     */
    protected Date startScholarship;

    /**
     *
     */
    protected Date endScholarship;

    /**
     *
     */
    protected Project project;

    /**
     *
     */
    protected int overWorked;

    /**
     *
     * @param startScholarship
     * @param endScholarship
     * @param project
     * @param overWorked
     * @param name
     * @param email
     */
    public ScholarshipStudent(Date startScholarship, Date endScholarship, Project project, int overWorked, String name, String email) {
        super(name, email);
        this.startScholarship = startScholarship;
        this.endScholarship = endScholarship;
        this.project = project;
        this.overWorked = overWorked;
    }

    /**
     *
     * @param startScholarship
     * @param endScholarship
     * @param overWorked
     * @param name
     * @param email
     */
    public ScholarshipStudent(Date startScholarship, Date endScholarship, int overWorked, String name, String email) {
        super(name, email);
        this.startScholarship = startScholarship;
        this.endScholarship = endScholarship;
        this.overWorked = overWorked;
    }

    /**
     * 
     * @param overWorked
     */
    public void setOverWorked(int overWorked) {
        this.overWorked = overWorked;
    }

    /**
     *
     * @return
     */
    public int getOverWorked() {
        return overWorked;
    }
}
