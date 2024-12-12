package ra.exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    @NotBlank(message = "Tên sinh viên không được bỏ trống")
    @Size(max = 100, message = "Tên sinh viên tôí đa 100 ký tự")
    private String studentName;
    @NotBlank(message = "Số phone không được bỏ trống")
    @Pattern(regexp = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{8}$")
    private String phoneNumber;
    @NotBlank(message = "Email không được bỏ trống")
    @Email
    private String email;
    @NotBlank(message = "Địa chỉ không được bỏ trống")
    private String address;
    private boolean sex;
    @Size(max = 255,message = "Đường dẫn ảnh tối đa 255 ký tự")
    private String imageUrl;
    @NotNull(message = "Mã lớp học không được bỏ trống")
    private int classId;
}
