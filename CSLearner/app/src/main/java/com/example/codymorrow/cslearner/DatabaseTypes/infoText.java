package com.example.codymorrow.cslearner.DatabaseTypes;



public class infoText {
    public String content1;
    public String content2;
    public String content3;
    public String content4;

    //Empty Constructor needed to quell Firebase's whining
    public infoText() {}

    public infoText(String content1, String content2) {
        this.content1 = content1;
        this.content2 = content2;
    }

    public String getContent1() {
        return content1;
    }

    public String getContent2() {
        return content2;
    }

    public String getContent3() {
        return content3;
    }

    public String getContent4() {
        return content4;
    }
}
