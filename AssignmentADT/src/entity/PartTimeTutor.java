/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author zhinf
 */
public class PartTimeTutor extends Tutor {

    private double salaryPerHour;
    private double workingHours;
    private double overTime;
    private double overTimePayRate;
    

    public PartTimeTutor(String id, String tutorName, int age, String gender, String email, String contactNo,
            double salaryPerHour, double workingHours, double overTimePayRate, double overTime) {
        super(id, tutorName, age, gender, email, contactNo);
        this.salaryPerHour = salaryPerHour;
        this.workingHours = workingHours;
        this.overTimePayRate = overTimePayRate;
        this.overTime = overTime;
    }
    
    public PartTimeTutor(String id, String tutorName, int age, String gender, String email, String contactNo,
            int semester, String faculty, String course,
            double salaryPerHour, double workingHours, double overTimePayRate, double overTime) {
        super(id, tutorName, age, gender, email, contactNo, semester, faculty, course);
        this.salaryPerHour = salaryPerHour;
        this.workingHours = workingHours;
        this.overTimePayRate = overTimePayRate;
        this.overTime = overTime;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public double getOverTimePayRate() {
        return overTimePayRate;
    }

    public void setOverTimePayRate(double overTimePayRate) {
        this.overTimePayRate = overTimePayRate;
    }

    

    // You can add any additional methods specific to PartTimeTutor here
    @Override
    public String toString() {
        // Include the additional attributes in the toString method
        return String.format("%s %-16.2f %-16.1f %-16.2f %-12.1f", super.toString(), salaryPerHour, workingHours, overTimePayRate, overTime);
    }

    public double overTimePay(){
        return overTimePayRate * overTime;
    }
    
    public double normalSalary(){
        return salaryPerHour * workingHours;
    }
    
    @Override
    public double salaryPay() {
        return normalSalary() + overTimePay();
    }
}
