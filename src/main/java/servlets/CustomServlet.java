package servlets;

import org.apache.log4j.Logger;
import requestHandlers.GetRequestHandler;
import utils.AnnotationList;
import utils.UtilFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);
    private AnnotationList ann = UtilFactory.INSTANCE.getAnnotationList();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        logger.error("Вызван метод doGet");
        logger.info(req.getPathInfo()+"  "+req.getServletPath());
//        req.setAttribute("path", "/GetRequest");
//        req.setAttribute("method", "/getSome");
        ann.checkTheClassAnnotations(req, resp, "requestHandlers");

//        req.setAttribute("method", "/getSome2");
//        ann.checkTheClassAnnotations(req, "GET", "requestHandlers");
//
//        req.setAttribute("path", "/PostRequest");
//        req.setAttribute("method", "/getSome");
//        ann.checkTheClassAnnotations(req, "POST", "requestHandlers");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
//        ann.checkMethods(req, "POST", "");
    }

}
