package dev.blog.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UploadService {
    String uploadImage(HttpServletRequest request, MultipartFile file, String path);
}
