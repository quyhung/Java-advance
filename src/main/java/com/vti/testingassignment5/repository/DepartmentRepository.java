package com.vti.testingassignment5.repository;


import com.vti.testingassignment5.entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.vti.testingassignment5.utils.HibernateUtils;
import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();


    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments() {
        Session session = null;

        try {
            //get session
            session = hibernateUtils.openSession();
            //create hql query
            Query<Department> query = session.createQuery("FROM Department");//" "
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public Department getDepartmentById(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get Department by id
            Department department = session.get(Department.class, id);
            return department;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Department getDepartmentByName(String name) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();


            // create hql query
            Query<Department> query = session.createQuery("FROM Department  WHERE departmentName=:nameParameter");

            // set parameter
            query.setParameter("nameParameter", name);
            //get result
            Department department = query.uniqueResult();
            return department;


        } finally {
            if (session != null) {
                session.close();
            }

        }
    }

    public void createDepartment(Department department) {
        Session session = null;
        try {
            //get session
            session = hibernateUtils.openSession();
            //create department
            session.save(department);

        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void updateDepartment(Department department) {
        Session session = null;
        try {
            //get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            //update department
            session.update(department);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    public void deleteDepartment(short id) {
        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();
            // get department
            Department department = session.load(Department.class, id);
            // delete
            session.delete(department);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }



}



