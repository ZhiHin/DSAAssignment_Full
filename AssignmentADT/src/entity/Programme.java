/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Tan Guan Wei
 */
public class Programme implements Comparable<Programme>, Serializable {

    private String id;
    private String name;
    private SortedArrayListInterface<String> tutorialList = new SortedArrayList<>();

    public Programme() {
    }

    public Programme(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTutorialList(SortedArrayListInterface<String> tutorialList) {
        this.tutorialList = tutorialList;
    }

    public SortedArrayListInterface<String> getTutorialList() {
        return tutorialList;
    }

    public StringBuilder displayTutorialGroups() {
        StringBuilder tutorialGroups = new StringBuilder();
        for (int i = 0; i < tutorialList.getNumberOfEntries(); i++) {
            tutorialGroups.append(tutorialList.getEntry(i));
            if (i + 1 < tutorialList.getNumberOfEntries()) {
                tutorialGroups.append(", ");
            }
        }
        return tutorialGroups;
    }

    @Override
    public String toString() {
        return "Programme{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programme other = (Programme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Programme p) {
        return this.id.compareTo(p.id);
    }

}
