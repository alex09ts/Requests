package requestHandlers;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;

@ClassAnnotation(
        requestClassUrl = "/GetRequest"
)
public class GetRequestHandler {

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

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

}
