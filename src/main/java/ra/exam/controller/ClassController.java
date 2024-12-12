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
import ra.exam.model.dto.ClassRoomDto;
import ra.exam.model.dto.ClassRoomUpdateDto;
import ra.exam.model.entity.ClassRoom;
import ra.exam.model.entity.Student;
import ra.exam.service.ClassRoomService;
import ra.exam.service.IStudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/classController")
public class ClassController {
    @Autowired
    private ClassRoomService classRoomService;
    private IStudentService studentService;
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<ClassRoom> listClassRooms = classRoomService.findAll();
        model.addAttribute("listClassRooms", listClassRooms);
        return "/classroom/list";
    }
    @GetMapping("/initCreate")
    public String initClassRoomForm(Model model) {
        model.addAttribute("classRoom", new ClassRoomDto());
        return "/classroom/create";
    }
    @PostMapping("/create")
    public String createCategory(@Valid @ModelAttribute("classRoom") ClassRoomDto classRoomDto,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!");
            return "redirect:/categoryController/initCreate";
        }

        try {
            classRoomService.create(classRoomDto);
            redirectAttributes.addFlashAttribute("successMessage", "Tạo danh mục thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi tạo danh mục: " + e.getMessage());
        }

        return "redirect:/classController/findAll";
    }
    @GetMapping("/initUpdate")
    public String initUpdate(Model model,int classId) {
        ClassRoom classRoom = classRoomService.findById(classId);
        model.addAttribute("classRoom", classRoom);
        return "/classroom/update";
    }
    @PostMapping("/update")
    public String Update(@Valid @ModelAttribute("classRoom") ClassRoomUpdateDto classRoomDto,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Dữ liệu không hợp lệ, vui lòng kiểm tra lại!");
            return "redirect:/categoryController/initCreate?classId=" + classRoomDto.getClassId();
        }

        try {
            classRoomService.update(classRoomDto);
            redirectAttributes.addFlashAttribute("successMessage", "Tạo danh mục thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi tạo danh mục: " + e.getMessage());
        }

        return "redirect:/classController/findAll";
    }
    @GetMapping("/delete")
    public String delete(int classId,RedirectAttributes redirectAttributes) {
            boolean result = classRoomService.delete(classId);
            if (result) {
                return "redirect:/classController/findAll";
            }else {
                return "error";
            }
    }

}
