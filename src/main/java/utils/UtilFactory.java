package utils;

import classHolders.ClassListHolder;

public enum UtilFactory {

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
}
