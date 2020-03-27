package com.example.mepositry;



public class Prooduct {
    public int id;
    public String name;
    private String gender;
    public String email;
    public String age;
    public String school;
    public String phn;
    public String height;
    public String weight;
    public String bmi;
    public String ph;
    public String pulse;
    public String br;
    public String ur;
    public String er;


    public Prooduct(int id, String name, String gender,String email,String age,String school,String phn,String height,String weight,String bmi,String ph,String pulse,String br,String ur,String er) {
        this.id = id;
        this.name=name;
        this.gender=gender;
        this.email=email;
        this.age=age;
        this.school=school;
        this.phn=phn;
        this.height=height;
        this.weight=weight;
        this.bmi=bmi;
        this.ph=ph;
        this.pulse=pulse;
        this.br=br;
        this.ur=ur;
        this.er=er;



    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public String getAge() {
        return age;
    }
    public String getSchool() {
        return school;
    }
    public String getPhn() {
        return phn;
    }
    public String getHeight() {
        return height;
    }
    public String getweight() {
        return weight;
    }
    public String getBmi() {
        return bmi;
    }
    public String getPh() {
        return ph;
    }
    public String getPulse() {
        return pulse;
    }
    public String getBr() {
        return br;
    }
    public String getEr() {
        return er;
    }
    public String getUr() {
        return ur;
    }




}

