package com.clinicguru.application.enums;

public enum AppointmentType {
    E("E"), C("C");

    private String type;

    private AppointmentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
