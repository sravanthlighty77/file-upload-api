package com.management.files.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.files.entity.FilesEntity;

public interface FilesRepository extends JpaRepository<FilesEntity, Integer> {

}
