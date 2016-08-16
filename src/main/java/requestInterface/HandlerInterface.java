package requestInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerInterface {
    void redirect(HttpServletRequest req, HttpServletResponse resp);
}
