package gbr2_Music;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArtistListWS
 */
@WebServlet("/ArtistListWS")
public class ArtistListWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistListWS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ManageArtists mar = new ManageArtists();
		String lastName = "";
		String searchType = "";
		//Use last name and search type to query database and return relevant data
		if(request.getParameter("lastName") != null && request.getParameter("searchType") != null){
			lastName = request.getParameter("lastName");
			searchType = request.getParameter("searchType");
		}
		// If lastName and searchType are blank, then return everything.
		response.getWriter().print(mar.getArtistList(lastName, searchType));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
