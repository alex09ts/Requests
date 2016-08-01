package classHolders;

import factory.ClassFactory;

import java.util.HashMap;
import java.util.Map;

public class ObjectHolder {

    private static Map<String, Object> mmm;

    static {
        mmm = new HashMap<String, Object>();
        mmm.put("requestHandlers.GetRequestHandler", ClassFactory.INSTANCE.getRequestHandler());
        mmm.put("requestHandlers.PostRequestHandler", ClassFactory.INSTANCE.getPostHandler());
        mmm.put("requestHandlers.UselessRequestHandler", ClassFactory.INSTANCE.getUselessHandler());
    }

    public static Map<String, Object> getSingletoneMap(){
        return mmm;
    }

}
