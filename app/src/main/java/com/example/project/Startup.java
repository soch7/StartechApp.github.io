package com.example.project;

public class Startup {

    String name;
    String shortDesc;
    String startupIdea;
    String qualification;
    String location;
    String email;
    String phone;
    boolean expanded;

    public Startup(String name, String shortDesc, String startupIdea, String qualification, String location, String email, String phone) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.startupIdea = startupIdea;
        this.qualification = qualification;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.expanded=false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getStartupIdea() {
        return startupIdea;
    }

    public void setStartupIdea(String startupIdea) {
        this.startupIdea = startupIdea;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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


    @Override
    public String toString() {
        return "Startup{" +
                "name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", startupIdea='" + startupIdea + '\'' +
                ", qualification='" + qualification + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
