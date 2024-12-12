package ra.exam.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exam.model.dto.StudentDto;
import ra.exam.model.dto.StudentUpdateDto;
import ra.exam.model.entity.ClassRoom;
import ra.exam.model.entity.Student;
import ra.exam.repository.IClassRepository;
import ra.exam.repository.IStudentRepository;
import ra.exam.service.IStudentService;

import javax.validation.constraints.Size;
import java.util.List;
@Service
public class StudentServiceImp implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IClassRepository classRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public boolean create(StudentDto requestDto) {
        Student student = new Student();
        student.setStudentName(requestDto.getStudentName());
        student.setPhoneNumber(requestDto.getPhoneNumber());
        student.setEmail(requestDto.getEmail());
        student.setAddress(requestDto.getAddress());
        student.setSex(requestDto.isSex());
        ClassRoom classRoom = classRepository.findById(requestDto.getClassId());
        student.setClassRoom(classRoom);
        student.setImageUrl(requestDto.getImageUrl());
        return studentRepository.save(student);
    }

    @Override
    public boolean update(StudentUpdateDto requestDto) {
        Student student = studentRepository.findById(requestDto.getStudentId());
        student.setStudentName(requestDto.getStudentName());
        student.setPhoneNumber(requestDto.getPhoneNumber());
        student.setEmail(requestDto.getEmail());
        student.setAddress(requestDto.getAddress());
        student.setSex(requestDto.isSex());
        ClassRoom classRoom = classRepository.findById(requestDto.getClassId());
        student.setClassRoom(classRoom);
        student.setImageUrl(requestDto.getImageUrl());
        student.setStatus(requestDto.getStatus());
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(int studentId) {
        return studentRepository.delete(studentId);
    }

    @Override
    public List<Student> findByClass(int classId) {
        return studentRepository.findByClass(classId);
    }
}
