package requestHandlers;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;
import requestInterface.HandlerInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ClassAnnotation(
        requestClassUrl = "/PostRequest"
)
public class PostRequestHandler implements HandlerInterface {

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

    @MethodAnnotation(
            requestUrl = "/getSome",
            method = "POST"
    )
    public void redirect(HttpServletRequest req, HttpServletResponse resp){

        logger.info("Path /getSome method POST");

    }

    public void method1() {

    }
}
