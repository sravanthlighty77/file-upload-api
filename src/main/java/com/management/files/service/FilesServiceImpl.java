package com.management.files.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.management.files.entity.FilesEntity;
import com.management.files.repository.FilesRepository;
import com.management.files.validation.FilesValidation;
@Service
public class FilesServiceImpl implements FilesService {
	
	@Autowired
	private FilesValidation filesValidation;
	
	@Autowired
	private FilesRepository filesRepository;

	@Override
	@Transactional
	public String save(MultipartFile file) {
		FilesEntity fileEntity = new FilesEntity();
		String path = "src/main/resources/upload";
		try {
			if(filesValidation.isValidFileType(file.getOriginalFilename())) {
				fileEntity.setName(file.getOriginalFilename());
				fileEntity.setPath(path+"/"+file.getOriginalFilename());
				filesRepository.save(fileEntity);
				Files.copy(file.getInputStream(), Paths.get(path, file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				return "File has been uploaded successfully";
			}else {
				throw new RuntimeException("Can only upload file types of .pdf, .docx, .xlsx, .doc");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		

	}

}
