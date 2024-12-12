package ra.exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="classRoom")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClassRoom {
    @Id
    @Column(name="class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;
    @Column(name="class_name",columnDefinition = "varchar(100)",nullable = false,unique = true)
    private String className;
    @Column(name="majors",columnDefinition = "varchar(100)",nullable = false)
    private String majors;
    @OneToMany(mappedBy = "classRoom")
    List<Student> listStudents = new ArrayList<>();

}
