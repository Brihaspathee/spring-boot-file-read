package com.example.fileread.service.impl;

import com.example.fileread.service.interfaces.FileLoadingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, November 2021
 * Time: 5:57 AM
 * Project: file-read
 * Package Name: com.example.fileread.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileLoadingServiceImpl implements FileLoadingService {

    private final ApplicationContext applicationContext;

    private final ResourceLoader resourceLoader;

    @Value("${file.location}")
    private String fileLocation;

    @Override
    public Resource[] loadFiles() throws IOException {
        log.info("File Location: {}", fileLocation);
        Resource [] resources = applicationContext.getResources("file:"+fileLocation);
        /*Resource [] resources = new Resource[1];
        Resource resource = resourceLoader.getResource("classpath:data.txt");
        resources[0] = resource;*/
        return resources;
    }
}
