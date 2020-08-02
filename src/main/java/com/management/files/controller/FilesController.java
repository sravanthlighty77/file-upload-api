package com.management.files.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.management.files.service.FilesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/files")
public class FilesController {
	
	@Autowired
	private FilesService filesService;
	
	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		String message = "";
		try {
			if(!file.isEmpty()) {
				message = filesService.save(file);
			}else {
				throw new RuntimeException("Please select a file to upload.");
			}
		} catch (Exception e) {
			message = e.getMessage();
			return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String> (message,HttpStatus.OK);
	}

}
