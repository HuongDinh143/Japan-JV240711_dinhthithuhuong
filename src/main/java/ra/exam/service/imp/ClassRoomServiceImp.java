package ra.exam.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exam.model.dto.ClassRoomDto;
import ra.exam.model.dto.ClassRoomUpdateDto;
import ra.exam.model.entity.ClassRoom;
import ra.exam.repository.IClassRepository;
import ra.exam.service.ClassRoomService;

import java.util.List;
@Service
public class ClassRoomServiceImp implements ClassRoomService {
    @Autowired
    private IClassRepository classRepository;
    @Override
    public List<ClassRoom> findAll() {
        return classRepository.findAll();
    }

    @Override
    public ClassRoom findById(int classId) {
        return classRepository.findById(classId);
    }

    @Override
    public boolean create(ClassRoomDto requestDto) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassName(requestDto.getClassName());
        classRoom.setMajors(requestDto.getMajors());
        return classRepository.save(classRoom);
    }

    @Override
    public boolean update(ClassRoomUpdateDto requestDto) {
        ClassRoom classRoom = classRepository.findById(requestDto.getClassId());
        classRoom.setClassName(requestDto.getClassName());
        classRoom.setMajors(requestDto.getMajors());
        return classRepository.update(classRoom);
    }

    @Override
    public boolean delete(int classId) {
        return classRepository.delete(classId);
    }

    @Override
    public ClassRoom findByName(String className) {
        return classRepository.findByName(className);
    }
}
