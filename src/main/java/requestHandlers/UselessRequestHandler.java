package requestHandlers;

import annotations.ClassAnnotation;

@ClassAnnotation(
        requestClassUrl = "/NoRequest"
)
public class UselessRequestHandler implements HandlerInterface{


        public void method1() {

        }
}
