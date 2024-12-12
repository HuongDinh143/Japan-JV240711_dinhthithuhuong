package ra.exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassRoomDto {
    @NotBlank(message = "Tên lớp không được bỏ trống")
    @Size(max = 100,message = "Tên lớp tối đa 100 ký tự")
    private String className;
    @NotBlank(message = "Tên chuyên ngành không được bỏ trống")
    @Size(max = 150,message = "Tên chuyên ngành tối da 150 ký tự")
    private String majors;

}
