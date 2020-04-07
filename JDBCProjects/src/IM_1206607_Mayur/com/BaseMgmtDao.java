package IM_1206607_Mayur.com;

import java.util.ArrayList;

public interface BaseMgmtDao {
    int  addParticipant(Participant participant, DbTransaction dbobj);
    int  addBaseLocat(BaseLocation baseLocat, DbTransaction dbobj);
    ArrayList<String> getParticipantNameSortedBySal(DbTransaction dbobj);
    ArrayList<String> getParticipantNameForBaseLocation(String baseLocationName, DbTransaction dbobj );
    int getTotalParticipantsInCity(String City, DbTransaction dbobj);

}
