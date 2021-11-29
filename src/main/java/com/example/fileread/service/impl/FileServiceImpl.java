package com.example.fileread.service.impl;

import com.example.fileread.service.interfaces.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, November 2021
 * Time: 5:58 AM
 * Project: file-read
 * Package Name: com.example.fileread.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Override
    public void processFile(Resource resource) throws IOException {
        BasicFileAttributes basicFileAttributes = Files.readAttributes(resource.getFile().toPath(), BasicFileAttributes.class);
        FileTime time = basicFileAttributes.creationTime();
        Date createdDate = new Date(time.toMillis());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(createdDate.toInstant(), ZoneId.systemDefault());
        String fileName = resource.getFilename();
        log.info("File Name: {}", fileName);
        InputStream inputStream = resource.getInputStream();
        byte[] fileBinaryData = FileCopyUtils.copyToByteArray(inputStream);
        String fileData = new String(fileBinaryData, StandardCharsets.UTF_8);
        log.info("File Data: {}", fileData);
    }
}
