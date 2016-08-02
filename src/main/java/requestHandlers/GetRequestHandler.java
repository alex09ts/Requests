package requestHandlers;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ClassAnnotation(
        requestClassUrl = "/GetRequest"
)
public class GetRequestHandler implements HandlerInterface{

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

    @MethodAnnotation(
            requestUrl = "getSome",
            method = "GET"
    )
    void logRedirectedGetMethod(HttpServletRequest req, HttpServletResponse resp){

        logger.info("Path /getSome method GET EXECUTED!!!");
        try {
            resp.sendRedirect("redirect.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @MethodAnnotation(
            requestUrl = "getSome2",
            method = "GET"
    )
    void logRedirectedGetMethod2(HttpServletRequest req, HttpServletResponse resp){

        logger.info("Path /getSome2 method GET");

        try {
            resp.sendRedirect("redirect2.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MethodAnnotation(
            requestUrl = "getSome3",
            method = "GET"
    )
    public void method1() {
        System.out.println("Executed");
    }
}
