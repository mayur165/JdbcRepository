package CollegeManagement;

import java.util.Date;

public class Professor {
    private int professorId;
    private String professorName;
    private Date professorDob;


    public Professor(int professorId, String professorName, Date professorDob) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.professorDob = professorDob;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Date getProfessorDob() {
        return professorDob;
    }

    public void setProfessorDob(Date professorDob) {
        this.professorDob = professorDob;
    }
}
