package Calculator;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Calculator.Panel;
public class CreatePDF {
 
	public CreatePDF(Double x1, Double x2, Double x3, Double x4, Double x5) {
 
		try {
 

			DateFormat dateFormatter = new SimpleDateFormat("hh_mm_ss");
			String currentDateTime = dateFormatter.format(new Date()); 
		String file_name=currentDateTime +".pdf";
		Document document = new Document();
 
		PdfWriter.getInstance(document, new FileOutputStream(file_name));
		
		
		
		document.open();

		DecimalFormat df2 = new DecimalFormat("###");
 
		Paragraph mainPara = new Paragraph("Credit calculation:");
		mainPara.setAlignment(Paragraph.ALIGN_CENTER);
		Paragraph para1 = new Paragraph("Cost of hypothec " + x1 + " rub");
		para1.setAlignment(Paragraph.ALIGN_CENTER);
		Paragraph para2 = new Paragraph("With percent rate " + df2.format(x4) + " % ");    // x2= mesyaci  x1= summa  x3= mes x4 = %                                                                          //x5 = mes oplata
		para2.setAlignment(Paragraph.ALIGN_CENTER);                                         //x5 = mes oplata
		Paragraph para3 = new Paragraph("On " + (x3) + " full mounths");
		para3.setAlignment(Paragraph.ALIGN_CENTER);
		//Paragraph para4 = new Paragraph("First donat " + df2.format(x) + " rub");
		//para4.setAlignment(Paragraph.ALIGN_CENTER);
		Paragraph para5 = new Paragraph("Monthly payment: " + df2.format(x5) + " rub");
		para5.setAlignment(Paragraph.ALIGN_CENTER);
		//Paragraph para6 = new Paragraph("Monthly payment2: " + df2.format(x5) + " rub");
		//para6.setAlignment(Paragraph.ALIGN_CENTER);
 
		document.add(mainPara);
		document.add(para1);
		document.add(para2);
		document.add(para3);
		//document.add(para4);
		document.add(para5);
		//document.add(para6);
 
		PdfPTable table = new PdfPTable(3);
		PdfPCell c1 = new PdfPCell(new Phrase("Full cost:"));
		table.addCell(c1);
 
 
		c1 = new PdfPCell(new Phrase(df2.format(x1)));
		table.addCell(c1);
 
		PdfPCell c2 = new PdfPCell(new Phrase("rub"));
		table.addCell(c2);
 

 
		table.addCell("Percents");
		table.addCell(df2.format(x2));  //dobavit percents
		table.addCell("%");
		
		table.addCell("Credit term:");
		table.addCell(df2.format(x3));  // norm
		table.addCell("mounths");
 
		table.addCell("Mounthly pay:");
		table.addCell(df2.format(x5));  // dobavit formulu
		table.addCell("rub");
 
		//table.addCell("First donat:");
		//table.addCell(df2.format(x));  // norm
		//table.addCell("rub");
 
		document.add(table);
 
 
		document.close();
 
 
		System.out.println("Finished");
		} catch (Exception e) {
			System.err.println(e);
		}
 
 
 
 
	}
 
}
