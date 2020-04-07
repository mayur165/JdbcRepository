package CollegeManagement;

import java.util.Date;

public class CollegeMain {
    public static void main(String[] args) {
        Professor p = new Professor(1216,"Varun",new Date(1,10,1993));
        Professor p1 = new Professor(1217,"Sangeet",new Date(5,12,1994));
        Professor p2 = new Professor(1218,"Anita",new Date(2,9,1996));
        Professor p3 = new Professor(1219,"Sampreet",new Date(10,4,1997));
        Professor p4 = new Professor(1220,"Pronit",new Date(11,5,1998));
        Professor p5 = new Professor(1221,"Pankaj",new Date(21,7,1999));
        Professor p6 = new Professor(1222,"Neha",new Date(17,8,2000));
        Professor p7 = new Professor(1223,"Mayur",new Date(12,1,2001));

        CollegeDaoImpl cdao = new CollegeDaoImpl();
        /*cdao.addProfessor(p);
        cdao.addProfessor(p1);
        cdao.addProfessor(p2);
        cdao.addProfessor(p3);
        cdao.addProfessor(p4);
        cdao.addProfessor(p5);
        cdao.addProfessor(p6);
        cdao.addProfessor(p7);*/

        College c = new College(122,"Bansal",1216);
        College c1 = new College(123,"Thakral",1217);
        College c3 = new College(124,"Lnct",1216);
        College c4 = new College(125,"TIT",1219);
        College c5 = new College(126,"Truba",1216);
        College c6 = new College(127,"DeviAhilya",1221);
        College c7 = new College(128,"Radharaman",1219);
        College c8 = new College(129,"Jnct",1219);
        College c9 = new College(130,"Nri",1217);
        College c10 = new College(131,"Kolar",1221);
        /*cdao.addCollege(c);
        cdao.addCollege(c1);
        cdao.addCollege(c3);
        cdao.addCollege(c4);
        cdao.addCollege(c5);
        cdao.addCollege(c6);
        cdao.addCollege(c7);
        cdao.addCollege(c8);
        cdao.addCollege(c9);*/
        //cdao.addCollege(c10);
        System.out.println(cdao.getCollegeMapByProfessor());

    }
}
