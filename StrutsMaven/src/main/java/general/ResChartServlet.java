package general;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Connection.HibernateUtill;

import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Document;

import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import mapping.Reservation;

/**
 * Servlet implementation class ResChartServlet
 */
@WebServlet("/ResChartServlet")
public class ResChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtill.getSession();
		try {
            // Get the text that will be added to the PDF
            String rdate = request.getParameter("rdate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	Criteria cr = session.createCriteria(Reservation.class);
        	if(rdate != null ){
				
				cr.add(Restrictions.eq("reservation_date", sdf.parse(rdate)));
			}
        	cr.add(Restrictions.eq("status","A"));
        	Date resDate  =  sdf.parse(rdate);
        	
        	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        	cr.addOrder(Order.asc("resId"));
        	List resList = cr.list();
        	
            HeaderFooterPageEvent event  =new  HeaderFooterPageEvent();
            // step 1
            Document document = new Document(PageSize.A4, 36, 36, 90, 36);
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, baos);
 
            Font fontHeader = new  Font(FontFamily.HELVETICA, 10, Font.BOLD, new BaseColor(0, 0, 0));
            Font fonttableHeader = new  Font(FontFamily.HELVETICA, 8, Font.BOLD, new BaseColor(0, 0, 0)); 
            Font fontNormal = new  Font(FontFamily.HELVETICA, 8, Font.NORMAL, new BaseColor(0, 0, 0)); 
            Phrase header = new Phrase(("RESERVATION CHART OF "+sdf1.format(resDate)),fontHeader);
            event.setHeader(header);
            writer.setPageEvent(event);
 
            FooterTable evenfooter = new FooterTable();
            writer.setPageEvent(evenfooter);
            
            
            // step 3
            document.open();
            
            
            
            PdfPTable headingTable = new PdfPTable(3);
            headingTable.setWidths(new int[]{10, 24, 10});
            headingTable.setTotalWidth(527);
            headingTable.setLockedWidth(true);
            headingTable.getDefaultCell().setFixedHeight(20);
            headingTable.setTotalWidth(523);
            headingTable.getDefaultCell().setFixedHeight(20);
			headingTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			headingTable.addCell("");
			PdfPCell cell = new PdfPCell(header);
			cell.setBorder(Rectangle.BOTTOM);
			headingTable.addCell(cell);
			headingTable.addCell("");
			document.add(headingTable);
            // step 4
           
            PdfPTable table = new PdfPTable(6);
           
            table.setTotalWidth(520F);
            table.getDefaultCell().setMinimumHeight(25F);
            table.setLockedWidth(true);
            table.setWidths(new float[]{2,2,1,1,2,2});
            table.addCell(new Phrase("Company Name",fonttableHeader));
            table.addCell(new Phrase("Contact Person",fonttableHeader));
            table.addCell(new Phrase("Phone no",fonttableHeader));
            table.addCell(new Phrase("Number of Guests",fonttableHeader));
            table.addCell(new Phrase("Table Assignment",fonttableHeader));
            table.addCell(new Phrase("Remarks",fonttableHeader));
           
            int totalCount =0;
            
            	
            for (Iterator iterator = resList.iterator(); iterator.hasNext();){
            			 
                Reservation reservation = (Reservation) iterator.next();
                
            	 
            	
            	 table.addCell(new Phrase(reservation.getCompanyName(),fontNormal));
            	 table.addCell(new Phrase(reservation.getContact_person(),fontNormal));
            	 table.addCell(new Phrase(reservation.getPhoneNo(),fontNormal));
            	 table.addCell(new Phrase(String.valueOf(reservation.getNoOfPesons()),fontNormal));
            	 totalCount  += reservation.getNoOfPesons();
            	 table.addCell("");
            	 table.addCell("");
            	
            	 
            }
            
            PdfPTable bottomtable = new PdfPTable(6);
            bottomtable.setTotalWidth(520F);
            bottomtable.setLockedWidth(true);
            bottomtable.setWidths(new float[]{2,2,1,1,2,2});
            bottomtable.setSpacingBefore(20F);
            
            PdfPCell cell1 = new PdfPCell();
            cell1.setBorderColor(BaseColor.WHITE);
            PdfPCell cell2 = new PdfPCell();
            cell2.setBorderColor(BaseColor.WHITE);
            PdfPCell cell3 = new PdfPCell();
            cell3.setBorderColor(BaseColor.WHITE);
           
            PdfPCell cell4 = new PdfPCell();
            cell4.setBorder(Rectangle.TOP);
            cell4.addElement(new Phrase("Total : "+totalCount,fonttableHeader));
            PdfPCell cell5 = new PdfPCell();
            cell5.setBorderColor(BaseColor.WHITE);
            PdfPCell cell6 = new PdfPCell();
            cell6.setBorderColor(BaseColor.WHITE);
            
            bottomtable.addCell(cell1);
            bottomtable.addCell(cell2);
            bottomtable.addCell(cell3);
            bottomtable.addCell(cell4);
            bottomtable.addCell(cell5);
            bottomtable.addCell(cell6);
            document.add(table);
            document.add(bottomtable);
           
            // step 5
            document.close();
 
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        }
        catch(Exception e) {
           e.printStackTrace();
        }finally{
        	session.close();
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
