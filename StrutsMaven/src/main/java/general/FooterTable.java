package general;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class FooterTable extends PdfPageEventHelper {
	
        
    public void onEndPage(PdfWriter writer, Document document) {
    	try {
			Font fontFooterNormal = new  Font(FontFamily.HELVETICA, 7, Font.BOLD, new BaseColor(0, 0, 0)); 
			PdfPTable tablefooter = new PdfPTable(3);
			
			tablefooter.setWidths(new int[]{10, 24, 10});
			tablefooter.setTotalWidth(527);
			tablefooter.setLockedWidth(true);
			tablefooter.getDefaultCell().setFixedHeight(20);
			tablefooter.setTotalWidth(523);
			tablefooter.getDefaultCell().setFixedHeight(20);
			tablefooter.getDefaultCell().setBorder(Rectangle.TOP);//HH:mm:ss
			Date today = new Date();
			SimpleDateFormat sdfFooter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Phrase footerPrintDate  = new Phrase("Printed On "+sdfFooter.format(today.getTime()),fontFooterNormal);
			tablefooter.addCell(footerPrintDate);
			tablefooter.addCell("");
			String pagetext  = String.format("Page %d ", writer.getPageNumber());
			tablefooter.addCell(new Phrase(pagetext,fontFooterNormal));
			PdfPCell cell = new PdfPCell();
			cell.setBorder(Rectangle.TOP);
			tablefooter.addCell(cell);
      // tablefooter.addCell(cell);
			tablefooter.writeSelectedRows(0, -1, 36, 64, writer.getDirectContent());
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
    }

}
