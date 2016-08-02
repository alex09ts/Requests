package factory;

import classHolders.ClassListHolder;
import requestHandlers.GetRequestHandler;
import requestHandlers.PostRequestHandler;
import requestHandlers.UselessRequestHandler;
import utils.AnnotationList;
import utils.ClassFinder;

public class ClassFactory {

    private static AnnotationList annotationList;
    private static ClassFinder classFinder;
    private static ClassListHolder classListHolder;
    private static GetRequestHandler getRequestHandler;
    private static PostRequestHandler postRequestHandler;
    private static UselessRequestHandler uselessRequestHandler;

    public static AnnotationList getAnnotationList() {
        if (annotationList == null) {
            annotationList = new AnnotationList();
        }
        return annotationList;
    }

    public static ClassFinder getClassFinder() {
        if (classFinder == null) {
            classFinder = new ClassFinder();
        }
        return classFinder;
    }

    public static ClassListHolder getClassListHolder() {
        if (classListHolder == null) {
            classListHolder = new ClassListHolder();
        }
        return classListHolder;
    }

    public GetRequestHandler getRequestHandler() {
        if (getRequestHandler == null) {
            getRequestHandler = new GetRequestHandler();
        }
        return getRequestHandler;
    }


    public PostRequestHandler getPostHandler() {

        if (postRequestHandler == null) {
            postRequestHandler = new PostRequestHandler();
        }
        return postRequestHandler;
    }


    public UselessRequestHandler getUselessHandler() {

        if (uselessRequestHandler == null) {
            uselessRequestHandler = new UselessRequestHandler();
        }
        return uselessRequestHandler;
    }
}
