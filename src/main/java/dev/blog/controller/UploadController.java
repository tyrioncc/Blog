package dev.blog.controller;

import dev.blog.util.FileUpload;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class UploadController {

    @RequestMapping("imageUpload")
    public void imageUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file,
                            HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        PrintWriter wirte = null;
        JSONObject json = new JSONObject();
        try {
            wirte = response.getWriter();
            //文件存放的路径
            String path = request.getSession().getServletContext().getRealPath("upload");
            String url = "http://localhost:8080"
                    + request.getContextPath()
                    + "//upload//"
                    + FileUpload.upload(request, file, path);
            json.put("success", 1);
            json.put("message", "hello");
            json.put("url", url);
        } catch (Exception e) {
        }finally{
            wirte.print(json);
            wirte.flush();
            wirte.close();
        }
    }

}
