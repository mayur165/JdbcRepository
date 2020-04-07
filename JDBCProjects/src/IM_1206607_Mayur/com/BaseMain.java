package IM_1206607_Mayur.com;

public class BaseMain {
    public static void main(String[] args) {
        Participant p = new Participant(1038,"Adnan Vibhute",
                               "JAVA",22000,78);
        Participant p1 = new Participant(1058,"Varun mehra",
                "SAP",26000,79);
        Participant p2 = new Participant(1068,"Mayank Saraswat",
                "JAVA",25000,78);
        Participant p3 = new Participant(1078,"Nagmohan",
                "ORACLE",13000,80);
        Participant p4 = new Participant(1088,"Mayur",
                "SAP",36000,81);

        BaseLocation b = new BaseLocation(78,"Garima Park","Ahmedabad");
        BaseLocation b1 = new BaseLocation(79,"Sehyadri Park","Pune");
        BaseLocation b2= new BaseLocation(80,"Synergy Park","Hyderabad");
        BaseLocation b3 = new BaseLocation(81,"Kohinoor Park","Mumbai");
        String url = "jdbc:oracle:thin:@localhost:1523:ORCL";
        String username ="oracle_db";
        String password ="mypassword";
        String tablename1 = "TBL_PARTICIPANT_1206607";
        String tabname2 ="TBL_BASE_LOCATION_1206607";
        DbTransaction db = new DbTransaction(url,username,password,tablename1,tabname2);

        BaseMgmtDao bm = new BaseMgmtDaoImpl();

        bm.getTotalParticipantsInCity("Hyderabad",db);



    }
}
