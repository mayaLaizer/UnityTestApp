package org.example.app.enums;

//Post Status Enum
public enum PostStatusSelection {

    ACTIVE("ACTIVE"),
    REMOVED("REMOVED");


    public String option;
    PostStatusSelection(String option) {
        this.option = option;
    }
}
