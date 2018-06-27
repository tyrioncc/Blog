package dev.blog.controller;

import dev.blog.service.UploadService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/home")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @RequestMapping("/uploadImage")
    @ResponseBody
    public void imageUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file,
                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String fileName = "default_file_name";
        try{
            String path = request.getSession().getServletContext().getRealPath("upload");
            fileName = uploadService.uploadImage(request, file, path);
            System.out.println("fileName:" + fileName);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //下面response返回的json格式是editor.md所限制的，规范输出就OK
        response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/resources/upload/image/" + fileName + "\"}" );
    }
}
