package requestHandlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by noname on 02.08.16.
 */
public interface HandlerInterface {
    void redirect(HttpServletRequest req, HttpServletResponse resp);
}
