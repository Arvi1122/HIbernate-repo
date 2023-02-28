package com.hibernate.dao;

import java.util.List;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import org.hibernate.Session;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

@Transactional
public class StudentDao {

	public void saveStudent(Student student) throws IllegalStateException, SystemException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = (Transaction) session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e);
		}
	}

	public List<Student> getStudent() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Student", Student.class).list();
		}
	}

}
