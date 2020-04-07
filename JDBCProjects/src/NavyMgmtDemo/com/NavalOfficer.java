package NavyMgmtDemo.com;

public class NavalOfficer {
    private int officeId;
    private String officerName;
    private String officeRank;
    private double officerSal;
    private int baseCampId;

    public NavalOfficer(int officeId, String officerName, String officeRank, double officerSal, int baseCampId) {
        this.officeId = officeId;
        this.officerName = officerName;
        this.officeRank = officeRank;
        this.officerSal = officerSal;
        this.baseCampId = baseCampId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficeRank() {
        return officeRank;
    }

    public void setOfficeRank(String officeRank) {
        this.officeRank = officeRank;
    }

    public double getOfficerSal() {
        return officerSal;
    }

    public void setOfficerSal(double officerSal) {
        this.officerSal = officerSal;
    }

    public int getBaseCampId() {
        return baseCampId;
    }

    public void setBaseCampId(int baseCampId) {
        this.baseCampId = baseCampId;
    }
}
