package general;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper {
	 protected Phrase header;
	 PdfTemplate total;
	 public float tableHt;
	
	 
     public void setHeader(Phrase header) {
         this.header = header;
     }
     @Override
     
     public void onOpenDocument(PdfWriter writer, Document document) {
         total = writer.getDirectContent().createTemplate(30, 16);
     }
     
     @Override
     public void onEndPage(PdfWriter writer, Document document) {
         PdfPTable table = new PdfPTable(3);
         try {
        	
        	 String  absolutePathToIndexJSP = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
        	 String IMAGE =absolutePathToIndexJSP+"/img/logoblueocean.png";
        	 System.out.println(absolutePathToIndexJSP);
        	 Font fontNormal = new  Font(FontFamily.HELVETICA, 7, Font.BOLD, new BaseColor(0, 0, 0)); 
             table.setWidths(new int[]{10, 24, 30});
             table.setTotalWidth(527);
             table.setLockedWidth(true);
             table.getDefaultCell().setFixedHeight(80);
             //table.getDefaultCell().setBorder(Rectangle.BOTTOM);
             Date today = new Date();
             SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
             
             table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
             table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
             table.addCell("");
             table.addCell("");
             Image image = Image.getInstance(IMAGE);
             image.scaleAbsolute(161f, 145f);
             String pagetext  = "Page "+writer.getPageNumber();
             table.addCell(image);
             PdfPCell cell = new PdfPCell();
             //cell.setBorder(Rectangle.BOTTOM);
             table.addCell(cell);
             table.writeSelectedRows(0, -1, 34, 833, writer.getDirectContent());
         }
         catch(Exception e) {
            e.printStackTrace();
         }
     }
     @Override
     public void onCloseDocument(PdfWriter writer, Document document) {
         ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                 new Phrase(String.valueOf(writer.getPageNumber() - 1)),
                 2, 2, 0);
     }
} 