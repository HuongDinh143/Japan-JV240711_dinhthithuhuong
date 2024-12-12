package ra.exam.service;

import ra.exam.model.dto.StudentDto;
import ra.exam.model.dto.StudentUpdateDto;
import ra.exam.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int studentId);
    boolean create(StudentDto requestDto);
    boolean update(StudentUpdateDto requestDto);
    boolean delete(int studentId);
    List<Student> findByClass(int classId);
}
