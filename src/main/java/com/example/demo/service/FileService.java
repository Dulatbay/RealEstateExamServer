package com.example.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String storeFile(MultipartFile file);
    Resource loadFileAsResource(String fileName);
}
