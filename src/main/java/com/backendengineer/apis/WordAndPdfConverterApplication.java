package com.backendengineer.apis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.opensagres.poi.xwpf.converter.core.IXWPFConverter;
import fr.opensagres.poi.xwpf.converter.core.XWPFConverterException;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

@SpringBootApplication
public class WordAndPdfConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordAndPdfConverterApplication.class, args);
	}

	public void pdfConvereter() throws ParseException, XWPFConverterException, IOException {
		InputStream stream = new FileInputStream(new File("C:\\Users\\GOD\\Downloads\\Mohan-Resume.docx"));
		XWPFDocument doc = new XWPFDocument(stream);
		PdfOptions pdf = PdfOptions.create();
		OutputStream out = new FileOutputStream(
				new File("C:\\Users\\GOD\\Downloads\\Indian bank statement requesting letter.pdf"));
		// PdfConverter.getInstance().convert(doc, out, pdf);
		IXWPFConverter<PdfOptions> pdf2 = PdfConverter.getInstance();
		pdf2.convert(doc, out, pdf);
		System.out.println("Document converted into as PDF" + pdf2);
	}
}
