package gbr2_Music;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SongListWS
 */
@WebServlet("/SongListWS")
public class SongListWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongListWS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ManageSongs ms = new ManageSongs();
		String title = "";
		String searchType = "";
		//Use title and search type to query database and return relevant data
		if(request.getParameter("title") != null && request.getParameter("searchType") != null){
			title = request.getParameter("title");
			searchType = request.getParameter("searchType");
		}
		// If title and searchType are blank, then return everything.
		response.getWriter().print(ms.getSongList(title, searchType));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
