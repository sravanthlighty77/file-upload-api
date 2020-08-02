package com.management.files.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "files_service")
@GenericGenerator(name = "files_id_sequence", strategy = "sequence",
parameters = {@Parameter(name = "sequnce", value = "files_id_sequence")})
public class FilesEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "files_id_sequence")
	private int id;
	
	@Column(name = "file_name")
	private String name;
	
	@Column(name = "file_path")
	private String path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
