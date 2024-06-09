package org.example.app.enums;

public enum PostStatusSelection {

    ACTIVE("ACTIVE"),
    REMOVE("REMOVE");


    public String option;
    PostStatusSelection(String option) {
        this.option = option;
    }
}
