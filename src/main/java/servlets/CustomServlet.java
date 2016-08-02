package servlets;

import classHolders.ObjectHolder;
import org.apache.log4j.Logger;
import requestHandlers.GetRequestHandler;
import utils.AnnotationList;
import factory.ClassFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);
    private AnnotationList ann = (AnnotationList)ObjectHolder.getSingletoneMap().get("utils.AnnotationList");

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        logger.error("Вызван метод doGet");
        logger.info(req.getPathInfo() + "  " + req.getServletPath());

        ann.checkTheClassAnnotations(req, resp, "requestHandlers");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        ann.checkTheClassAnnotations(req, resp, "requestHandlers");
    }

}
