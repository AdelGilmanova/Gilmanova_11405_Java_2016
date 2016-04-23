package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Контроллер по добавлению нового фото в профиль преподавателя
 * Created by Adel on 17.04.2016.
 */
@Controller
@RequestMapping("/newFile")
public class FileController extends BaseController {
    @Autowired
    private TeacherService teacherService;

//    @RequestMapping(method = RequestMethod.POST)
//    public String changePhoto() {
//        String msg = "К сожалению, ваше фото не добавлено.";
//        try {
//            if (isMultipartFormat(request)) {
//                PostData multidata = new PostData(request);
//                FileData tempFile = multidata.getFileData("file_send");
//                if (tempFile != null) {
//                    saveFile(tempFile, request);
//                    msg = "Ваше фото добавлено.";
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        } finally {
//            return "redirect:/teachers_page?msg=" + msg;
//        }
//    }
//
//    private boolean isMultipartFormat(HttpServletRequest req) throws javax.servlet.ServletException, java.io.IOException {
//        String temptype = req.getContentType();
//        return (temptype.contains("multipart/form-data"));
//    }
//
//    private void saveFile(FileData tempFile, HttpServletRequest request) throws IOException {
//        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        //Integer userId = user.getUserEntity().getId();
//        Integer userId = 1;
//        String getPath = request.getServletContext().getRealPath("/resources/images/usersPhoto/id_" + userId + "/");
//        File filePath = new File(getPath);
//        filePath.mkdirs();
//        File f = new File(filePath, tempFile.getFileName());
//        FileOutputStream fos = new FileOutputStream(f);
//        fos.write(tempFile.getByteData());
//        fos.close();
//        teacherService.addPhoto("/resources/images/usersPhoto/id_" + userId + "/" + tempFile.getFileName(), userId);
//    }
}
