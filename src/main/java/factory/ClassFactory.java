package factory;

import classHolders.ClassListHolder;
import requestHandlers.GetRequestHandler;
import requestHandlers.PostRequestHandler;
import requestHandlers.UselessRequestHandler;
import utils.AnnotationList;
import utils.ClassFinder;

public enum ClassFactory {

    INSTANCE;

    public AnnotationList getAnnotationList() {
        final AnnotationList annotationList;
        annotationList = new AnnotationList();
        return annotationList;
    }
    public ClassFinder getClassFinder() {
        final ClassFinder classFinder;
        classFinder = new ClassFinder();
        return classFinder;
    }

    public ClassListHolder getClassListHolder() {

        final ClassListHolder classListHolder;
        classListHolder = new ClassListHolder();
        return classListHolder;
    }

    public GetRequestHandler getRequestHandler() {

        final GetRequestHandler getRequestHandler;
        getRequestHandler = new GetRequestHandler();
        return getRequestHandler;
    }


    public PostRequestHandler getPostHandler() {

        final PostRequestHandler postRequestHandler;
        postRequestHandler = new PostRequestHandler();
        return postRequestHandler;
    }


    public UselessRequestHandler getUselessHandler() {

        final UselessRequestHandler uselessRequestHandler;
        uselessRequestHandler = new UselessRequestHandler();
        return uselessRequestHandler;
    }
}
