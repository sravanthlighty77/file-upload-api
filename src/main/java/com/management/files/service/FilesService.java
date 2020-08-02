package com.management.files.service;

import org.springframework.web.multipart.MultipartFile;

public interface FilesService {
	
	public String save(MultipartFile file);

}
