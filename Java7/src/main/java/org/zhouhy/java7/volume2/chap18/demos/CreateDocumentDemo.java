package org.zhouhy.java7.volume2.chap18.demos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateDocumentDemo {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("c:\\first.pdf"));
		document.open();
		document.add(new Paragraph("First Document"));
		document.add(new Paragraph("Second"));
		document.close();
	}

}
