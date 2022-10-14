package com.backendengineer.apis.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendengineer.apis.model.FileProperties;
import com.backendengineer.apis.service.FileConverterService;
import com.backendengineer.apis.utility.FileConverterConstants;

/**
 * 
 * @author Mohan SenthilKumar
 * 
 *         FIrst application to convert the given file from Word document to PDF
 *         Document
 *
 */

@RestController
@RequestMapping("/file-converter-application")
public class FileConverterController {

	@Autowired
	FileConverterService converterService;

	/**
	 * Method to convert the given file as pdf Document
	 * 
	 * @param properties
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/word-to-pdf")
	ResponseEntity<String> getFileById(@RequestBody FileProperties properties) throws IOException {
		converterService.getFileById(properties);
		return ResponseEntity.ok().body(FileConverterConstants.DOWNLOADED_PATH_FILENAME + properties.getFileLocation()
				+ properties.getFileName());
	}

}
