package za.co.iherridge0.jpa.hibernate.springjpahibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.co.iherridge0.jpa.hibernate.springjpahibernate.entity.Passport;
import za.co.iherridge0.jpa.hibernate.springjpahibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}

	public void saveStudentWithPassport() {

		Passport passport = new Passport("123456789");
		em.persist(passport);
		Student student = new Student("Jameson");
		student.setPassport(passport);
		em.persist(student);

	}
}