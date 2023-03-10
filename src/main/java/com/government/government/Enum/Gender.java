package com.government.government.Enum;

public enum Gender {
    MALE("M"),  FEMALE("F");

    private final String abbreviate;
    private Gender(String abbreviate) {
        this.abbreviate = abbreviate;
    }

    public String getAbbreviate() {
        return abbreviate;
    }

}
