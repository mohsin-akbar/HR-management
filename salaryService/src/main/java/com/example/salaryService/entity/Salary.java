package com.example.salaryService.entity;

public class Salary {
    private int empId;
    private double basic;
    private double bonus;

    public Salary(int empId, double basic, double bonus) {
        this.empId = empId;
        this.basic = basic;
        this.bonus = bonus;
    }
    public Salary() {}

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // getters/setters
}
