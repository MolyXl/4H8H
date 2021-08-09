package com.shbh.common.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface IFileStorage {
    FileMeta put(MultipartFile file);
    FileMeta put(byte[] data,String fileName,String mimeType);
    FileMeta put(InputStream stream, String fileName, String mimeType, Long size);
    boolean delete(String path);
}