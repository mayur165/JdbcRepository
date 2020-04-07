package IM_1206607_Mayur.com;

public class Participant {
    private int participant_id;
    private String participant_name;
    private String participant_stream;
    private double participant_sal;
    private int base_local_id;

    public Participant(int participant_id, String participant_name, String participant_stream, double participant_sal, int base_local_id) {
        this.participant_id = participant_id;
        this.participant_name = participant_name;
        this.participant_stream = participant_stream;
        this.participant_sal = participant_sal;
        this.base_local_id = base_local_id;
    }

    public int getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(int participant_id) {
        this.participant_id = participant_id;
    }

    public String getParticipant_name() {
        return participant_name;
    }

    public void setParticipant_name(String participant_name) {
        this.participant_name = participant_name;
    }

    public String getParticipant_stream() {
        return participant_stream;
    }

    public void setParticipant_stream(String participant_stream) {
        this.participant_stream = participant_stream;
    }

    public double getParticipant_sal() {
        return participant_sal;
    }

    public void setParticipant_sal(double participant_sal) {
        this.participant_sal = participant_sal;
    }

    public int getBase_local_id() {
        return base_local_id;
    }

    public void setBase_local_id(int base_local_id) {
        this.base_local_id = base_local_id;
    }
}
