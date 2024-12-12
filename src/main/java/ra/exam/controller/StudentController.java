package ra.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.exam.model.dto.StudentDto;
import ra.exam.model.entity.ClassRoom;
import ra.exam.model.entity.Student;
import ra.exam.repository.IClassRepository;
import ra.exam.service.IStudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRepository classRepository;
    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("listStudents", studentService.findAll());

        return "/student/list";
    }
    @GetMapping("/initUpdate")
    public String initCreateForm(Model model) {
        model.addAttribute("student", new StudentDto());
        List<ClassRoom> classRooms = classRepository.findAll();
        model.addAttribute("classRooms", classRooms);
        return "/student/create";
    }
    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("student") StudentDto request,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Dữ liệu không hợp lệ, vui lòng kiểm tra lại.");
            return "/student/create";
        }
        try {
            studentService.create(request);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm mới thành công");
            return "redirect:/employeeController/findAll";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra trong quá trình xử lý!");
            return "redirect:/employeeController/initCreate";
        }
    }
    @GetMapping("initUpdate")
    public String initUpdateForm(Model model,int studentId) {
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);
        List<ClassRoom> classRooms = classRepository.findAll();
        model.addAttribute("classRooms", classRooms);
        return "/student/update";

    }
    @GetMapping("/delete")
    public String delete(int studentId,RedirectAttributes redirectAttributes) {
        boolean result = studentService.delete(studentId);
        if (result) {
            return "redirect:/studentController/findAll";
        }
        redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra trong quá trình xử lý!");
        return "redirect:/studentController/findAll";
    }

}
