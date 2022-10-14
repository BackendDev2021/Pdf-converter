package com.backendengineer.apis.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import com.backendengineer.apis.model.FileProperties;
import com.backendengineer.apis.service.FileConverterService;

import fr.opensagres.poi.xwpf.converter.core.IXWPFConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

@Service
public class FileConverterServiceImpl implements FileConverterService {


	@Override
	public void getFileById(FileProperties properties) throws IOException {
		InputStream stream = new FileInputStream(new File(properties.getFileLocation()));
		XWPFDocument doc = new XWPFDocument(stream);
		PdfOptions pdf = PdfOptions.create();
		OutputStream out = new FileOutputStream(new File(properties.getFileLocation()+ properties.getFileName()));
		IXWPFConverter<PdfOptions> pdf2 = PdfConverter.getInstance();
		pdf2.convert(doc, out, pdf);
	}

}
