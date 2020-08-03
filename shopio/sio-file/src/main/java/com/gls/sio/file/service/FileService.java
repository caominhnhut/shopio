package com.gls.sio.file.service;

import org.springframework.web.multipart.MultipartFile;

import com.gls.sio.persistent.entity.FileEntity;

public interface FileService
{
    FileEntity storeFile(MultipartFile file);

    FileEntity findById(Long id);
    
    FileEntity create(FileEntity fileEntity);
    
    void detelePhysicalFile(String filename);
    
    FileEntity findByProductId(Long productId);
    
    FileEntity update(FileEntity fileEntity);
}
