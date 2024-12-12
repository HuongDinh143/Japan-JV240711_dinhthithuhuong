package ra.exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(name = "student_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String studentName;
    @Column(name = "phone_number", columnDefinition = "varchar(11)", nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "email", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String email;
    @Column(name = "address", columnDefinition = "varchar(150)", nullable = false)
    private String address;
    @Column(name = "sex")
    private boolean sex;
    @Column(name = "image_url", columnDefinition = "varchar(150)")
    private String imageUrl;
    @Column(name = "status")
    private int status = 1;
    @ManyToOne
            @JoinColumn(name="class_id",referencedColumnName = "class_id")
    ClassRoom classRoom = new ClassRoom();

}
