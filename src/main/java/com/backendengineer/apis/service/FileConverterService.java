package com.backendengineer.apis.service;

import java.io.IOException;

import com.backendengineer.apis.model.FileProperties;

public interface FileConverterService {

	public void getFileById(FileProperties properties) throws IOException;


}
