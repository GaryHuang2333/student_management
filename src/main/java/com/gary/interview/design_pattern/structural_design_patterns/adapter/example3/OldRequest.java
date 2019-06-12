
package com.gary.interview.design_pattern.structural_design_patterns.adapter.example3;

public class OldRequest implements IOldRequest {
    private String oldName;
    private String oldAge;
    private String oldGender;

    public OldRequest() {
    }

    public OldRequest(String oldName, String oldAge, String oldGender) {
        this.oldName = oldName;
        this.oldAge = oldAge;
        this.oldGender = oldGender;
    }

    @Override
    public void postApi() {
        System.out.println("Old Request post API -" + this.toString());
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getOldAge() {
        return oldAge;
    }

    public void setOldAge(String oldAge) {
        this.oldAge = oldAge;
    }

    public String getOldGender() {
        return oldGender;
    }

    public void setOldGender(String oldGender) {
        this.oldGender = oldGender;
    }

    @Override
    public String toString() {
        return "OldRequest{" +
                "oldName='" + oldName + '\'' +
                ", oldAge='" + oldAge + '\'' +
                ", oldGender='" + oldGender + '\'' +
                '}';
    }
}
