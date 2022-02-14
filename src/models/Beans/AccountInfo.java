package models.Beans;

import java.io.Serializable;

public class AccountInfo implements Serializable{

    private String firstName;
    private String lastName;
    private String birthDate;
    private int birthDateNum;

    public AccountInfo() {

    }

    public AccountInfo(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        try {
        this.birthDateNum = Integer.parseInt(birthDate.replace("-", ""));
        } catch(NumberFormatException e) {
            this.birthDateNum = 00000000;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getBirthDateNum() {
        return birthDateNum;
    }

    public void setBirthDateNum(int birthDateNum) {
        this.birthDateNum = birthDateNum;
    }


}
