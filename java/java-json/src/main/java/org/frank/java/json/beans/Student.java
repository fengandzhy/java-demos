package org.frank.java.json.beans;



import java.util.List;


public class Student {

    
    private String trueName;

    
    private List<Address> addresses;

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "trueName='" + trueName + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
