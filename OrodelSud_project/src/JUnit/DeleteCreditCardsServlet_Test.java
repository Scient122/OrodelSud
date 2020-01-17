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

@WebServlet("/DeleteCreditCardsServlet")
public class DeleteCreditCardsServlet_Test extends HttpServlet{
	private static final long serialVersionUID = 1L;


	public DeleteCreditCardsServlet_Test() {
		super();
	}

	public class DeleteCreditCardsServlet extends HttpServlet {

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String numero_carta = request.getParameter("numero_carta");
			HttpSession session = request.getSession();
			ClienteBean cliente = (ClienteBean) session.getAttribute("userBean");

			UserDAO interfaccia = new UserDAO_Stub();
			try {
				interfaccia.deletecreditcards(numero_carta);
				cliente.deleteCarte_credito(numero_carta);
			}
			catch (Exception e) {
				response.sendError(500, "Errore"+e);
			}

			response.sendRedirect("Pagamento.jsp");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}
}
