package ra.exam.repository;

import ra.exam.model.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int studentId);
    boolean save(Student student);
    boolean update(Student student);
    boolean delete(int studentId);
    List<Student> findByClass(int classId);
}
