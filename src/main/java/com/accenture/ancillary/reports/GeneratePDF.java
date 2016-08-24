package com.accenture.ancillary.reports;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.accenture.ancillary.dto.RevenueReportDto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF{
	public static void main(String[] args)throws DocumentException,IOException{
		generateRevReport("8/21/2016");

	}	

	public static void generateRevReport(String startDate){
		com.itextpdf.text.Font greenfont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new CMYKColor(255, 0, 255, 0));
		com.itextpdf.text.Font redFont = FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, new CMYKColor(0, 255, 0, 0));
		com.itextpdf.text.Font blackFont = FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, new CMYKColor(255, 255, 255, 255));
		com.itextpdf.text.Font blackFont1 = FontFactory.getFont(FontFactory.HELVETICA, 7, Font.PLAIN, new CMYKColor(255, 255, 255, 255));
		Document document = new Document();
		try
		{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("FortuneSummryReport.pdf"));
			document.open();

			//Create chapter and sections
			Paragraph chapterTitle = new Paragraph("Fortune Hotel", blackFont);

			chapterTitle.setAlignment(Element.ALIGN_CENTER);
			Paragraph sectionContent = new Paragraph("Revenue summary report for additional services for period :"+startDate, redFont);


			document.add(chapterTitle);
			document.add(sectionContent);

			PdfPTable table = new PdfPTable(4); 
			table.setWidthPercentage(100); 
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f); 

			//Set Column widths
			float[] columnWidths = {1f, 1f, 1f, 1f};
			table.setWidths(columnWidths);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Reservation ID"));
			cell1.setBorderColor(BaseColor.BLACK);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell2 = new PdfPCell(new Paragraph("Service Name"));
			cell2.setBorderColor(BaseColor.BLACK);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell3 = new PdfPCell(new Paragraph("Service Start Date"));
			cell3.setBorderColor(BaseColor.BLACK);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell4 = new PdfPCell(new Paragraph("Cost"));
			cell4.setBorderColor(BaseColor.BLACK);
			cell4.setPaddingLeft(10);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);



			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);

			List<RevenueReportDto> resp = RestClient.getData(startDate);
			PdfPCell cell=null;
			int i=0;
			for(RevenueReportDto spr:resp){
				cell=new PdfPCell(new Paragraph(spr.getResId()+"",blackFont1));
				cell.setBorderColor(BaseColor.DARK_GRAY);
				cell.setPaddingLeft(10);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);

				cell=new PdfPCell(new Paragraph(spr.getServiceName(),blackFont1));
				cell.setBorderColor(BaseColor.DARK_GRAY);
				cell.setPaddingLeft(10);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);

				cell=new PdfPCell(new Paragraph(spr.getServiceStart(),blackFont1));
				cell.setBorderColor(BaseColor.DARK_GRAY);
				cell.setPaddingLeft(10);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);

				cell=new PdfPCell(new Paragraph(spr.getServiceCost(),blackFont1));
				cell.setBorderColor(BaseColor.DARK_GRAY);
				cell.setPaddingLeft(10);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				i+= Integer.parseInt(spr.getServiceCost());

			}

			document.add(table);
			Paragraph sectionContent2 = new Paragraph("Total revenue : "+i*0.05, greenfont);	
			document.add(sectionContent2);
			document.close();
			writer.close();
		} catch (Exception e){
			e.printStackTrace();
		}


	}
}