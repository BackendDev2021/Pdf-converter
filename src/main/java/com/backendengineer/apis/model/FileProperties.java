package com.backendengineer.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileProperties {

	private String fileLocation;
	
	private String fileName;
}
