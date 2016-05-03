package ru.kpfu.itis.Gilmanova.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Student;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.model.HomeWorkEntity;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.HomeWorkService;
import ru.kpfu.itis.Gilmanova.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Контроллер для отображения домашних заданий ученика
 * Created by Adel on 09.04.2016.
 */
@Controller
@RequestMapping("/student/home_works")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private HomeWorkService homeWorkService;
    @Autowired
    private ClassesService classesService;

    /*
     * Показывает домашние задания ученика
     */
    @Logger
    @Student
    @RequestMapping(method = RequestMethod.GET)
    public String renderStudentPage(ModelMap model) {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = user.getUserEntity().getId();
        StudentsEntity studentsEntity = studentService.getStudentByUserId(userId);
        Integer classId = studentsEntity.getClass_id().getId();
        model.put("home_works", homeWorkService.getHomeWorksByClassId(classId));
        model.put("student", studentService.getStudentByUserId(userId));
        return "student_page";
    }

    /*
     * Cкачивания документа
     */
    @Logger
    @Student
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String downloadHomeWork(HttpServletResponse response,
                                   @RequestParam String classId) throws IOException {
        createDocument(Integer.parseInt(classId));
        downloadDocument(response);
        return "redirect:/student/home_works";
    }

    private void createDocument(int classId) {
        try {
            List<HomeWorkEntity> list = homeWorkService.getHomeWorksByClassId(classId);

            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            String path = request.getServletContext().getRealPath("/resources/documents/");
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(path + "homeWorks.pdf"));
            document.open();

            Anchor anchorTarget = new Anchor("");
            anchorTarget.setName("BackToTop");
            Paragraph paragraph1 = new Paragraph();
            paragraph1.setSpacingBefore(50);
            paragraph1.add(anchorTarget);
            document.add(paragraph1);
            String fontsPath = request.getServletContext().getRealPath("/resources/fonts/");
            BaseFont baseFont = BaseFont.createFont(fontsPath + "arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont);

            ClassesEntity classesEntity = classesService.getClazz(classId);
            document.add(new Paragraph(classesEntity.getClazz(), font));
            for (HomeWorkEntity homeWork : list) {
                document.add(new Paragraph(homeWork.getClassTeacherObjectById().
                        getTeacher_object_id().getObjectsEntity().getObject(), font));
                document.add(new Paragraph(String.valueOf(homeWork.getDate()), font));
                document.add(new Paragraph(String.valueOf(homeWork.getHomeWork()), font));
                document.add(new Paragraph("_____________________________________________"));
            }
            document.close();
        } catch (IOException | DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private void downloadDocument(HttpServletResponse response) {
        try {
            final int BYTES_DOWNLOAD = 1024;
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition",
                    "attachment;filename=homeWorks.pdf");
            String path = request.getServletContext().getRealPath("/resources/documents/");
            InputStream is = new FileInputStream(path + "homeWorks.pdf");
            int read = 0;
            byte[] bytes = new byte[BYTES_DOWNLOAD];
            OutputStream os = response.getOutputStream();

            while ((read = is.read(bytes)) != -1) {
                os.write(bytes, 0, read);
            }
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
