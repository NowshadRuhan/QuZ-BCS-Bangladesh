package com.appsticit1.quz;

public class ModelClass {

    String id;
    String qus;
    String ansOne;
    String ansTwo;
    String ansThree;
    String ansFour;
    String mainans;

    public ModelClass(String id,String qus, String ansOne, String ansTwo, String ansThree, String ansFour, String mainans) {
        this.id = id;
        this.qus = qus;
        this.ansOne = ansOne;
        this.ansTwo = ansTwo;
        this.ansThree = ansThree;
        this.ansFour = ansFour;
        this.mainans = mainans;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }

    public String getAnsOne() {
        return ansOne;
    }

    public void setAnsOne(String ansOne) {
        this.ansOne = ansOne;
    }

    public String getAnsTwo() {
        return ansTwo;
    }

    public void setAnsTwo(String ansTwo) {
        this.ansTwo = ansTwo;
    }

    public String getAnsThree() {
        return ansThree;
    }

    public void setAnsThree(String ansThree) {
        this.ansThree = ansThree;
    }

    public String getAnsFour() {
        return ansFour;
    }

    public void setAnsFour(String ansFour) {
        this.ansFour = ansFour;
    }

    public String getMainans() {
        return mainans;
    }

    public void setMainans(String mainans) {
        this.mainans = mainans;
    }
}
