package ru.mts.dto;

public class JustRow {
    private String FIRST_NAME;

    private String LAST_NAME;
    private Double SALARY;
    private Integer id;

    public JustRow(String first_name, String last_name, Double salary, Integer id) {
        this.FIRST_NAME = first_name;
        this.LAST_NAME = last_name;
        this.SALARY = salary;
        this.id = id;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public Double getSALARY() {
        return SALARY;
    }

    public void setSALARY(Double salary) {
        this.SALARY = salary;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }
}
