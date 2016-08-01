package utils;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import classHolders.ClassListHolder;
import classHolders.ObjectHolder;
import factory.ClassFactory;
import org.apache.log4j.Logger;
import requestHandlers.GetRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationList {


    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);
    private static final ClassListHolder clp = ClassFactory.INSTANCE.getClassListHolder();

    public void checkTheClassAnnotations(HttpServletRequest request, HttpServletResponse resp, String path) {
        logger.info("Class check");

        List<Class> allClasses = clp.getClassList(path);
        for (Class obj : allClasses) {
            if (obj.isAnnotationPresent(ClassAnnotation.class)) {
                Annotation annotation = obj.getAnnotation(ClassAnnotation.class);
                ClassAnnotation ann = (ClassAnnotation) annotation;
                logger.info(request.getServletPath() + " compare to " + ann.requestClassUrl());
                if (request.getServletPath().equals(ann.requestClassUrl())) {
                    checkMethods(request, resp, obj);
                }
            }
        }
    }

    public void checkMethods(HttpServletRequest request, HttpServletResponse resp, Class obj) {
        logger.info("check methods");

        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(MethodAnnotation.class)) {

                Annotation annotation = method.getAnnotation(MethodAnnotation.class);
                MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
                logger.info(request.getParameter("param") + " compare to " + methodAnnotation.requestUrl());
                if (request.getParameter("param").equals(methodAnnotation.requestUrl()) &&
                        request.getMethod().equals(methodAnnotation.method())) {
                    try {
                        logger.info(obj.getName());
                        Object o = ObjectHolder.getSingletoneMap().get(obj.getName());
                        method.setAccessible(true);
                        method.invoke(o, request, resp);
                    } catch (InvocationTargetException x) {
                        logger.error("Error while invoking method");
                    } catch (IllegalAccessException e) {
                        logger.error("Error Illegal Access");
                    }
                }


            }
        }
    }
}