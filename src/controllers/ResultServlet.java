package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Beans.AccountInfo;
import models.logics.CreateAccountLogic;
import models.validation.Validation;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/Result")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // validationを通して、エラーがなければResult.jspへ。エラーがあればtoppage.jspへリダイレクト
        AccountInfo ai = new AccountInfo(request.getParameter("lastName"), request.getParameter("firstName"),request.getParameter("birthDate"));
        List<String> errorList = new Validation().doValidation(ai);
        HttpSession hs = request.getSession();
        hs.removeAttribute("errorList");

        if(errorList.size() != 0) {
            hs.setAttribute("AccountInfo", ai);
            hs.setAttribute("errorList", errorList);
            response.sendRedirect(request.getContextPath() + "/Toppage");
        } else {
            //アカウント名作成ロジック使用
            //urlをresult.jspへ設定
            String accountName = new CreateAccountLogic().createAccountName(ai);
            request.setAttribute("accountName", accountName);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/result.jsp");
            rd.forward(request, response);
        }
    }
}
