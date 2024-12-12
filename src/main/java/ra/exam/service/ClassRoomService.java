package ra.exam.service;

import ra.exam.model.dto.ClassRoomDto;
import ra.exam.model.dto.ClassRoomUpdateDto;
import ra.exam.model.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    List<ClassRoom> findAll();
    ClassRoom findById(int classId);
    boolean create(ClassRoomDto requestDto);
    boolean update(ClassRoomUpdateDto requestDto);
    boolean delete(int classId);
    ClassRoom findByName(String className);
}
