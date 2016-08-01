package factory;

import classHolders.ClassListHolder;
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
}
