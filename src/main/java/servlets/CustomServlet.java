package servlets;

import org.apache.log4j.Logger;
import requestHandlers.GetRequestHandler;
import starter.InitComponents;
import utils.AnnotationList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);
    private AnnotationList annotationList;

    @Override
    public void init() throws ServletException {
        InitComponents io = new InitComponents(getInitParameter("package"));
        annotationList = io.getAnnotationList();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        logger.info("Вызван метод doGet");
        logger.info(req.getPathInfo() + "  " + req.getServletPath());
        annotationList.checkTheClassAnnotations(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        annotationList.checkTheClassAnnotations(req, resp);
    }

}
