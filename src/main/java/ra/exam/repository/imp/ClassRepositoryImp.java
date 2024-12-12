package ra.exam.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.exam.model.entity.ClassRoom;
import ra.exam.repository.IClassRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ClassRepositoryImp implements IClassRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ClassRoom> findAll() {
        return entityManager.createQuery("from ClassRoom", ClassRoom.class).getResultList();
    }

    @Override
    public ClassRoom findById(int classId) {
        return entityManager.find(ClassRoom.class, classId);
    }

    @Override
    public boolean save(ClassRoom classRoom) {
        try {
            entityManager.persist(classRoom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ClassRoom classRoom) {
        try {
            entityManager.merge(classRoom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int classId) {
        try {
            ClassRoom classRoom = findById(classId);
            entityManager.remove(classRoom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ClassRoom findByName(String className) {
        try {
            return entityManager.createQuery("from ClassRoom where className=:name", ClassRoom.class)
                    .setParameter("name", className).getSingleResult();
        }catch (Exception e) {
            return null;
        }

    }
}
