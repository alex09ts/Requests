package starter;

import classHolders.ClassListHolder;
import utils.AnnotationList;
import utils.ClassFinder;

import java.util.List;
import java.util.Map;

public class InitComponents {

    private ClassListHolder classListHolder;
    private AnnotationList annotationList;
    private ClassFinder classFinder;
    private String packagePath;
    private Map<String,Object> objectMap;

    public InitComponents(String packagePath){
        this.packagePath = packagePath;
        init();
    }

    public void init(){
        classFinder = new ClassFinder();

        List<String> classNameList = classFinder.getPackageClassess(packagePath);
        classListHolder = new ClassListHolder(classNameList);

        List<Class> classLIst = classListHolder.parseClassList();
        objectMap = classListHolder.goSingletoneMap();

        annotationList = new AnnotationList(classLIst, objectMap);

    }

    public AnnotationList getAnnotationList(){
        return this.annotationList;
    }
}
