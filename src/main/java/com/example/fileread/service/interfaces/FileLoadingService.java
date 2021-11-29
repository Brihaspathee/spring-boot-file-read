package com.example.fileread.service.interfaces;

import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, November 2021
 * Time: 5:49 AM
 * Project: file-read
 * Package Name: com.example.fileread.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface FileLoadingService {

    Resource [] loadFiles() throws IOException;
}
