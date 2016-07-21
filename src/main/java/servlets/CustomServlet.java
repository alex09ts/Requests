package servlets;

import annotations.ClassAnnotation;
import org.apache.log4j.Logger;
import requestHandlers.CustomRequestHandler;
import utils.AnnotationList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

@WebServlet("/index")
public class CustomServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(CustomRequestHandler.class);
    AnnotationList ann;
    @Override
    public void init() throws ServletException {

        ann = new AnnotationList();
        ann.getAnnotations();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        logger.error("Вызван метод doGet");

        req.setAttribute("path", "/Request");
        req.setAttribute("method", "/getSome");
        ann.checkTheClassAnnotations(req, "GET");

        req.setAttribute("method", "/getSome2");
        ann.checkTheClassAnnotations(req, "GET");

        req.setAttribute("method", "/getSome");
        ann.checkTheClassAnnotations(req, "POST");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        ann.checkMethods(req, "POST");
    }

}
