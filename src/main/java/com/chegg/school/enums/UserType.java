package com.chegg.school.enums;

public enum UserType {
    STUDENT(Constants.STUDENT),
    PROFESSOR(Constants.PROFESSOR);

    private final String value;

    UserType(String value) {
        try {
            if (!value.equals(UserType.Constants.class.getField(this.name()).get(null))) {
                throw new IllegalArgumentException(value);
            }
            this.value = value;
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            throw new IllegalArgumentException(this.name());
        }
    }

    public String getValue() {
        return this.value;
    }

    public static class Constants {
        public static final String STUDENT = "STUDENT";
        public static final String PROFESSOR = "PROFESSOR";
    }
}