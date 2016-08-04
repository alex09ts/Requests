package classHolders;

import factory.ClassFactory;
import org.apache.log4j.Logger;
import utils.Utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectHolder {

    private static final ClassListHolder clp = ClassFactory.getClassListHolder();
    private static Map<String, Object> mmm;
    private static final Logger logger = Logger.getLogger(ClassListHolder.class);

    static {
        mmm = new HashMap<String, Object>();

        try {
            Class o = Class.forName(Utils.getClassFactoryPath());
            Object obj = o.newInstance();
            Method[] methods = o.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method.getName());
                if (method.getParameters().length < 1) {
                    method.setAccessible(true);
                    mmm.put(method.getReturnType().getCanonicalName(), method.invoke(obj, null));
                }
            }

            List<Class> list = clp.getClassList(Utils.getPackageName());

            for (Class clazz : list){
                mmm.put(clazz.getCanonicalName(), clazz.newInstance());
            }

        } catch (Exception e) {
            logger.error(e);
        }
    }

    public static Map<String, Object> getSingletoneMap() {
        return mmm;
    }
}