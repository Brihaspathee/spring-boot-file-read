package com.example.fileread.bootstrap;

import com.example.fileread.service.interfaces.FileLoadingService;
import com.example.fileread.service.interfaces.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, November 2021
 * Time: 5:53 AM
 * Project: file-read
 * Package Name: com.example.fileread.bootstrap
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LoadFile implements CommandLineRunner {

    private final FileLoadingService fileLoadingService;

    private final FileService fileService;

    @Override
    public void run(String... args) throws Exception {
        Resource [] resources = fileLoadingService.loadFiles();
        log.info("No. of Files:{}", resources.length);
        for (Resource resource: resources){
            fileService.processFile(resource);
        }
    }
}
