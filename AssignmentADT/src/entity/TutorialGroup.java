/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.HashMap;
import adt.HashMapInterface;

/**
 *
 * @author tkair
 */
public class TutorialGroup {

    private String groupId;
    private String groupName;
    public static int numberOfGroup = 0;
    private HashMapInterface<String, Student> studentList;

    public TutorialGroup() {
        this.groupId = "G" + (numberOfGroup + 1);
        this.groupName = "Tutorial Group " + (numberOfGroup + 1);
        studentList=new HashMap<>();
        numberOfGroup++;
    }

    public boolean addStudent(Student student) {
        return studentList.add(student.getStudentId(), student);
    }

    public boolean removeStudent(String studentID) {
        return studentList.remove(studentID);

    }

    public String getGroupId() {
        return groupId;
    }

    public HashMapInterface<String, Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        String outputStr = String.format("%-10s %-25s \n", groupId, groupName);
        return outputStr;
    }

}
