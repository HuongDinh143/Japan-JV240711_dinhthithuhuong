package ra.exam.repository;

import ra.exam.model.entity.ClassRoom;

import java.util.List;

public interface IClassRepository {
    List<ClassRoom> findAll();
    ClassRoom findById(int classId);
    boolean save(ClassRoom classRoom);
    boolean update(ClassRoom classRoom);
    boolean delete(int classId);
    ClassRoom findByName(String className);
}
