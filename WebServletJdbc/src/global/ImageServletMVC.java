package global;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageHolder;
import model.ImageService;

@WebServlet("/_00_init/ImageServletMVC")
public class ImageServletMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImageService service = new ImageService();
		ImageHolder img = null;
		String mimeType = null;
		long length = 0;
		byte[] content = null;
		
		
		String account = request.getParameter("account");
		String donationIdStr = request.getParameter("donationId");
		int donationId = 0;
		String schoolIdStr = request.getParameter("schoolId");
		int schoolId = 0;
		
		if (account != null) {
//			img = service.findMemberImage(account);
//			mimeType = getServletContext().getMimeType(img.getName());
//			length = img.getContent().length;
//			content = img.getContent();
			
		} else if(donationIdStr != null && schoolIdStr != null) {
			donationId = Integer.parseInt(donationIdStr);
			schoolId = Integer.parseInt(schoolIdStr);
			
			img = service.findDonationImage(donationId, schoolId);
			mimeType = getServletContext().getMimeType(img.getName());
//			System.out.println(mimeType);
			length = img.getContent().length;
			content = img.getContent();
		}
		
		response.reset();
		response.setContentType(mimeType);
		response.setContentLengthLong(length);
		response.getOutputStream().write(content);
		return;
	}
}
