package controller.admin.account;

import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAdmin")
public class DeleteAdmin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String url = "/ListAdminAccount";
        int idAdmin = Integer.parseInt(request.getParameter("idAdmin"));
        int result = UserDAO.DeleteAdminAccount(idAdmin);
        if(result > 0){

        } else {
            url = "/error.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
