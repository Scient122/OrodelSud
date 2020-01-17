package JUnit;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ClienteBean;
import Gestione_account.UserDAO;

@WebServlet("/AddCreditCardServlet_Test")
public class AddCreditCardServlet_Test extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public AddCreditCardServlet_Test() {

	} 

	public class AddCreditCardServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String numero = request.getParameter("carta");
			String tipologia = request.getParameter("credito");
			HttpSession session = request.getSession();
			ClienteBean cliente = (ClienteBean) session.getAttribute("userBean");
			UserDAO interfaccia = new UserDAO_Stub();
			String email = cliente.getEmail();

			try {
				interfaccia.addcreditcards(numero, tipologia, email);
			}
			catch (Exception e) {

				response.sendError(500, "Errore"+e);
			}
			cliente.setCarte_credito(numero, tipologia);
			response.sendRedirect("Pagamento.jsp");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}

}
