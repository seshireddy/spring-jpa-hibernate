package za.co.iherridge0.jpa.hibernate.springjpahibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import za.co.iherridge0.jpa.hibernate.springjpahibernate.repository.CourseRepository;
import za.co.iherridge0.jpa.hibernate.springjpahibernate.repository.StudentRepository;

@SpringBootApplication
public class SpringJpaHibernateApplication implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// courseRepository.playWithEntityManager();
		// studentRepository.saveStudentWithPassport();
		courseRepository.addReviewsForCourse();
	}

}
