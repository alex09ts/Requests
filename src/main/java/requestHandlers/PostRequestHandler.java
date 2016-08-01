package requestHandlers;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;

@ClassAnnotation(
        requestClassUrl = "/PostRequest"
)
public class PostRequestHandler {

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

    @MethodAnnotation(
            requestUrl = "/getSome",
            method = "POST"
    )
    void logRedirectedPostMethod(){

        logger.info("Path /getSome method POST");

    }
}
