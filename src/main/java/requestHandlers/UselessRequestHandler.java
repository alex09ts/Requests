package requestHandlers;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import requestInterface.HandlerInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ClassAnnotation(
        requestClassUrl = "/NoRequest"
)
public class UselessRequestHandler implements HandlerInterface {

        @MethodAnnotation(
                requestUrl = "/doNothing",
                method = "GET"
        )
        public void redirect(HttpServletRequest req, HttpServletResponse resp) {

        }
}