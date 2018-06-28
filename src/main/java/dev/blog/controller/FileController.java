package dev.blog.controller;

import dev.blog.Exception.StorageFileNotFoundException;
import dev.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/file/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        //System.out.println("serveFile filename:" + filename);
        Resource file = fileService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @RequestMapping("/home/uploadImage")
    @ResponseBody
    public void imageUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file,
                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String fileName = "default_file_name";
        try{
            fileName = fileService.store(file);
            //System.out.println("fileName:" + fileName);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //下面response返回的json格式是editor.md所限制的，规范输出就OK
        response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/file/" + fileName + "\"}" );
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
