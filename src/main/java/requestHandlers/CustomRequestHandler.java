package requestHandlers;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;

@ClassAnnotation(
        requestClassUrl = "/Request"
)
public class CustomRequestHandler {

    private static final Logger logger = Logger.getLogger(CustomRequestHandler.class);

    @MethodAnnotation(
            requestUrl = "/getSome",
            method = "GET"
    )
    void logRedirectedGetMethod(){

        logger.info("Path /getSome method GET");

    }

    @MethodAnnotation(
            requestUrl = "/getSome2",
            method = "GET"
    )
    void logRedirectedGetMethod2(){

        logger.info("Path /getSome2 method GET");

    }

    @MethodAnnotation(
            requestUrl = "/getSome",
            method = "POST"
    )
    void logRedirectedPostMethod(){

        logger.info("Path /getSome method POST");

    }

}
