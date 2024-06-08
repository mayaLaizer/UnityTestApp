package org.example.app.modules;

import java.util.Date;

public class JsonData {

    private String someJsonNumber;
    private String someJsonString;
 //   private Date someJsonDate;

    public boolean isSomeJsonBoolean() {
        return someJsonBoolean;
    }

    public void setSomeJsonBoolean(boolean someJsonBoolean) {
        this.someJsonBoolean = someJsonBoolean;
    }

    private boolean someJsonBoolean;

    public JsonData(String someJsonNumber, String someJsonString, boolean someJsonBoolean) {
        this.someJsonNumber = someJsonNumber;
        this.someJsonString = someJsonString;
 //       this.someJsonDate = someJsonDate;
        this.someJsonBoolean = someJsonBoolean;
    }

    public String getSomeJsonNumber() {
        return someJsonNumber;
    }

    public void setSomeJsonNumber(String someJsonNumber) {
        this.someJsonNumber = someJsonNumber;
    }

    public String getSomeJsonString() {
        return someJsonString;
    }

    public void setSomeJsonString(String someJsonString) {
        this.someJsonString = someJsonString;
    }

 /*   public Date getSomeJsonDate() {
        return someJsonDate;
    }

    public void setSomeJsonDate(Date someJsonDate) {
        this.someJsonDate = someJsonDate;
    }*/
}
