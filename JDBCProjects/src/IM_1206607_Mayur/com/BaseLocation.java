package IM_1206607_Mayur.com;

public class BaseLocation {
private int base_local_id;
private String base_local_name;
private String base_local_city;

    public BaseLocation(int base_local_id, String base_local_name, String base_local_city) {
        this.base_local_id = base_local_id;
        this.base_local_name = base_local_name;
        this.base_local_city = base_local_city;
    }

    public int getBase_local_id() {
        return base_local_id;
    }

    public void setBase_local_id(int base_local_id) {
        this.base_local_id = base_local_id;
    }

    public String getBase_local_name() {
        return base_local_name;
    }

    public void setBase_local_name(String base_local_name) {
        this.base_local_name = base_local_name;
    }

    public String getBase_local_city() {
        return base_local_city;
    }

    public void setBase_local_city(String base_local_city) {
        this.base_local_city = base_local_city;
    }
}

