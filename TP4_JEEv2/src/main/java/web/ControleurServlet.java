package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IJeuDao;
import dao.JeuDaoImpl;
import metier.entities.Jeu;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	IJeuDao metier;

	@Override
	public void init() throws ServletException {
		metier = new JeuDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("jeux.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			JeuModele model = new JeuModele();
			model.setMotCle(motCle);
			List<Jeu> games = metier.jeuxParMC(motCle);
			model.setJeux(games);
			request.setAttribute("model", model);
			request.getRequestDispatcher("jeux.jsp").forward(request, response);
		}
		
		else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieJeu.jsp").forward(request, response);
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Jeu j = metier.save(new Jeu(nom, prix));
			request.setAttribute("jeu", j);
			response.sendRedirect("chercher.do?motCle=");
			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		
		else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteJeu(id);
			response.sendRedirect("chercher.do?motCle=");
		}
		
		else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Jeu j = metier.getJeu(id);
			request.setAttribute("jeu", j);
			request.getRequestDispatcher("editerJeu.jsp").forward(request, response);
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Jeu j = new Jeu();
			j.setIdJeu(id);
			j.setNomJeu(nom);
			j.setPrix(prix);
			metier.updateJeu(j);
			request.setAttribute("jeu", j);
			response.sendRedirect("chercher.do?motCle=");
			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
}
