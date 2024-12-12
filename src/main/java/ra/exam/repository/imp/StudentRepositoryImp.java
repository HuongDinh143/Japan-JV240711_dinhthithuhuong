package ra.exam.repository.imp;

import org.springframework.stereotype.Repository;
import ra.exam.model.entity.ClassRoom;
import ra.exam.model.entity.Student;
import ra.exam.repository.IStudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class StudentRepositoryImp implements IStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public boolean save(Student student) {
        try {
            entityManager.persist(student);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        try {
            entityManager.merge(student);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int studentId) {
        try {
            Student studentDelete = findById(studentId);
            entityManager.remove(studentDelete);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> findByClass(int classId) {
        try {
            return entityManager.createQuery("from Student where classRoom.classId = :classId", Student.class)
                    .setParameter("classId", classId).getResultList();
        }catch (NoResultException e) {
            return null;
        }
    }
}
