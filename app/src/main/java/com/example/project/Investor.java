package com.example.project;

public class Investor {

    String name;
    String investment;
    String ideaPreferences;
    String qualification;
    String email;
    String phone;
    boolean expanded;

    public Investor(String name, String investment, String ideaPreferences, String qualification, String email, String phone) {
        this.name = name;
        this.investment = investment;
        this.ideaPreferences = ideaPreferences;
        this.qualification = qualification;
        this.email = email;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }

    public String getIdeaPreferences() {
        return ideaPreferences;
    }

    public void setIdeaPreferences(String ideaPreferences) {
        this.ideaPreferences = ideaPreferences;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "name='" + name + '\'' +
                ", investment='" + investment + '\'' +
                ", ideaPreferences='" + ideaPreferences + '\'' +
                ", qualification='" + qualification + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
