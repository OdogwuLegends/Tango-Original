package com.tm30.tango.service.interfaces;

import com.tm30.tango.service.implementation.FileImplementation;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileImplementation.FileResponse upload(MultipartFile file);
}
