package utils;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import classHolders.ClassListHolder;
import org.apache.log4j.Logger;
import requestHandlers.GetRequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationList {


    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

    public void checkTheClassAnnotations(HttpServletRequest request, String met, String path) {
        logger.info("Class check");
        ClassListHolder clp = new ClassListHolder();
        List<Class> allClasses = clp.getClassList(path);
        for (Class obj : allClasses) {
            if (obj.isAnnotationPresent(ClassAnnotation.class)) {

                Annotation annotation = obj.getAnnotation(ClassAnnotation.class);
                ClassAnnotation ann = (ClassAnnotation) annotation;
                logger.info(request.getAttribute("path")+" compare to "+ann.requestClassUrl());
                if (request.getAttribute("path").equals(ann.requestClassUrl())) {
                    checkMethods(request, met, obj);
                }
            }
        }
    }

    public void checkMethods(HttpServletRequest request, String met, Class obj) {
        logger.info("check methods");

        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(MethodAnnotation.class)) {

                Annotation annotation = method.getAnnotation(MethodAnnotation.class);
                MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;

                if (request.getAttribute("method").equals(methodAnnotation.requestUrl()) &&
                        met.equals(methodAnnotation.method())) {
                    try {
                        Object o = obj.newInstance();
                        method.setAccessible(true);
                        method.invoke(o, null);
                    } catch (InvocationTargetException x) {
                        logger.error("Error while invoking method");
                    } catch (IllegalAccessException e) {
                        logger.error("Error Illegal Access");
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }
}