package com.management.files.validation;

import java.net.MalformedURLException;

import org.springframework.web.multipart.MultipartFile;

public interface FilesValidation {
	
	public boolean isValidFileType(String fileName);
	public boolean isFileExists(MultipartFile file) throws MalformedURLException;

}
