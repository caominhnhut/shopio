package com.gls.sio.persistent.repository.file.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.gls.sio.persistent.entity.FileEntity;
import com.gls.sio.persistent.repository.common.AbstractGenericDao;
import com.gls.sio.persistent.repository.file.FileRepository;

@Repository
public class FileRepositoryImpl extends AbstractGenericDao<FileEntity> implements FileRepository
{
    @PostConstruct
    public void init()
    {
        super.setClazz(FileEntity.class);
    }
}
