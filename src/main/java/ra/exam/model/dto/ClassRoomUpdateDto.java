package ra.exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassRoomUpdateDto {
    private int classId;
    @NotBlank(message = "Tên lớp không được bỏ trống")
    @Size(max = 100,message = "Tên lớp tối đa 100 ký tự")
    private String className;
    @NotBlank(message = "Tên chuyên ngành không được bỏ trống")
    @Size(max = 150,message = "Tên chuyên ngành tối da 150 ký tự")
    private String majors;
}
