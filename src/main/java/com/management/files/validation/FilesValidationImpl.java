package com.management.files.validation;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesValidationImpl implements FilesValidation {

	@Override
	public boolean isValidFileType(String fileName) {
		if(fileName.endsWith(".docx") || fileName.endsWith(".pdf") || fileName.endsWith(".xlsx") || fileName.endsWith(".doc")) return true;
		
		return false;
	}

}
