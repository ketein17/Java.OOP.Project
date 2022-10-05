package OceanTech.training.model;

import OceanTech.training.utils.EmailFormatException;
import OceanTech.training.utils.IDFormatException;
import OceanTech.training.utils.Validator;

public class Student {
    private String id;
    private String name;
    private double diem;
    private String email;

    private String rank;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        if (diem < 3) rank = "Too bad";
        else if (diem < 5) rank = "bad";
        else if (diem < 6.5) rank = "Average";
        else if (diem < 7.5) rank = "Good";
        else if (diem < 9) rank = "Very good";
        else rank = "Excellent";
        return rank;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        if (diem >= 0 || diem <= 10) {
            this.diem = diem;
        } else {
            throw new NumberFormatException("Score is invalid!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailFormatException {
        if (Validator.isEmail(email)) {
            this.email = email;
        } else {
            throw new EmailFormatException("Email is invalid!");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IDFormatException {
        if (Validator.isID(id)) {
            String s = id.substring(0, 2);
            if (s.equals("HS")) {
                this.id = id;
            } else {
                throw new IDFormatException("ID is invalid!");
            }
        } else {
            throw new IDFormatException("ID is invalid!");
        }
    }

    public void display() {
        System.out.format("%s%20s%15.3f%20s%20s\n", id, name, diem, email, getRank());
    }
}
