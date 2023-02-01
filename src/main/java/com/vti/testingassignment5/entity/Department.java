package com.vti.testingassignment5.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private short departmentId;

    @Column(name = "`name`", length = 50, nullable = false, unique = true)
    private String departmentName;

    public short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(short departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
