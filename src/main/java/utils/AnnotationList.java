package utils;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;
import requestHandlers.CustomRequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationList {

    private static final Logger logger = Logger.getLogger(CustomRequestHandler.class);

    public void getAnnotations() {
        Class<CustomRequestHandler> obj = CustomRequestHandler.class;

        if (obj.isAnnotationPresent(ClassAnnotation.class)) {

            Annotation annotation = obj.getAnnotation(ClassAnnotation.class);
            ClassAnnotation ann = (ClassAnnotation) annotation;

            logger.info("Class annotations: " + ann.requestClassUrl());

            for (Method method : obj.getDeclaredMethods()) {

                if (method.isAnnotationPresent(MethodAnnotation.class)) {

                    annotation = method.getAnnotation(MethodAnnotation.class);
                    MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
                    logger.info("Method annotations: " + methodAnnotation.requestUrl() + ", "
                            + methodAnnotation.method());

                }
            }
        }
    }

    public void checkTheClassAnnotations(HttpServletRequest request, String met){
        logger.info("Check class");
        Class<CustomRequestHandler> obj = CustomRequestHandler.class;

        if (obj.isAnnotationPresent(ClassAnnotation.class)) {

            Annotation annotation = obj.getAnnotation(ClassAnnotation.class);
            ClassAnnotation ann = (ClassAnnotation) annotation;

            if(request.getAttribute("path").equals(ann.requestClassUrl())){
                checkMethods(request, met);
            }
        }
    }

    public void checkMethods(HttpServletRequest request, String met){
        logger.info("check methods");
        Class<CustomRequestHandler> obj = CustomRequestHandler.class;

        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(MethodAnnotation.class)) {

                Annotation annotation = method.getAnnotation(MethodAnnotation.class);
                MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;

                if(request.getAttribute("method").equals(methodAnnotation.requestUrl())&&
                        met.equals(methodAnnotation.method())){
                    try {
//                        logger.info("In try");
                        Object o = obj.newInstance();
//                        logger.info("new instance");
                        method.setAccessible(true);
//                        logger.info("Set access");
                        method.invoke(o, null);
//                        logger.info("invoke");
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