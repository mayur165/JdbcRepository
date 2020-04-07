package CollegeManagement;

import java.util.List;

public class College {
    private int collegeId;
    private String collegeName;
    //private List<Professor> professorList;
    private int professorList;

//    public College(int collegeId, String collegeName, List<Professor> professorList) {
    public College(int collegeId,String collegeName,int professorList){
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.professorList = professorList;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /*public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }*/

    public int getProfessorList() {
        return professorList;
    }

    public void setProfessorList(int professorList) {
        this.professorList = professorList;
    }
}
