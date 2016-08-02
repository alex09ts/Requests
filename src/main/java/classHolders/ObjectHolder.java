package classHolders;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectHolder {

    private static Map<String, Object> mmm;
    private static final Logger logger = Logger.getLogger(ClassListHolder.class);

    public void getList(){
        mmm = new HashMap<String, Object>();

        try {
            Class o = Class.forName("factory.ClassFactory");
            Object obj = o.newInstance();
            Method[] methods = o.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method.getName());
                if (method.getParameters().length < 1) {
                    method.setAccessible(true);
//                    System.out.println(method.getReturnType().getCanonicalName());
                    mmm.put(method.getReturnType().getCanonicalName(), method.invoke(obj, null));
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
//        mmm.put("requestHandlers.GetRequestHandler", ClassFactory.INSTANCE.getRequestHandler());
//        mmm.put("requestHandlers.PostRequestHandler", ClassFactory.INSTANCE.getPostHandler());
//        mmm.put("requestHandlers.UselessRequestHandler", ClassFactory.INSTANCE.getUselessHandler());
    }

    public static Map<String, Object> getSingletoneMap() {
        return mmm;
    }
}