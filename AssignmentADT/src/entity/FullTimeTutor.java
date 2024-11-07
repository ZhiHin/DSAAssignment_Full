/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author zhinf
 */
public class FullTimeTutor extends Tutor{
    private double basicSalary;
    private double allowance;

    public FullTimeTutor(String id, String tutorName, int age, String gender, String email, String contactNo,
                         double basicSalary, double allowance) {
        super(id, tutorName, age, gender, email, contactNo);
        this.basicSalary = basicSalary;
        this.allowance = allowance;
    }
    
    public FullTimeTutor(String id, String tutorName, int age, String gender, String email, String contactNo,
                         int semester, String faculty, String course,
                         double basicSalary, double allowance) {
        super(id, tutorName, age, gender, email, contactNo, semester, faculty, course);
        this.basicSalary = basicSalary;
        this.allowance = allowance;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %-16.2f %-16.2f", super.toString(), basicSalary, allowance);
    }

    @Override
    public double salaryPay() {
        return basicSalary + allowance;
    }
}
