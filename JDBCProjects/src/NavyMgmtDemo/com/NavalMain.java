package NavyMgmtDemo.com;

public class NavalMain {
    public static void main(String[] args) {
        NavalMgmtDAOImpl n = new NavalMgmtDAOImpl();
        NavalOfficer np = new NavalOfficer(1800, "Harmeet Singh", "Captain", 42000, 35);
        NavalOfficer np1 = new NavalOfficer(1810 ,"Rahul Gaur"," Vice Admiral", 57000 ,38);
        NavalOfficer np2 = new NavalOfficer(1992 ,"Sayan Paul" ,"Captain", 45000 ,38);
        NavalOfficer np3 = new NavalOfficer(8765 ,"Sumeet Tripathi" ,"Lieutenant", 59000, 36);
        NavalOfficer np4 = new NavalOfficer(9090," Romi DSouza" ,"Vice Admiral" ,55000, 37);

        BaseCamp b = new BaseCamp(35, "INS Kalinga", "BHOPAL");
        BaseCamp b1 = new BaseCamp(36,"INS Dronacharya","UDAIPUR");
        BaseCamp b2 = new BaseCamp(37 ,"INS Virbahu", "HARYANA");
        BaseCamp b3 = new BaseCamp(38,"INS Kardip"," KOLKATA");
        /*n.addBaseCamp(b);
        n.addBaseCamp(b1);
        n.addBaseCamp(b2);
        n.addBaseCamp(b3);*/
        //n.addNavalOfficer(np);
        /*n.addNavalOfficer(np1);
        n.addNavalOfficer(np2);
        n.addNavalOfficer(np3);
        n.addNavalOfficer(np4);*/
//n.getOfficersNameSortedBySal();
        //n.getOfficersNameForBaseCampLoc("BHOPAL");
        n.getOfficersTotalSalOnBaseCamp(39);

    }
}
