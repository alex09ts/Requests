package classHolders;

import org.apache.log4j.Logger;
import utils.ClassFinder;
import factory.ClassFactory;

import java.util.ArrayList;
import java.util.List;

public class ClassListHolder {

    private List<Class> classList;
    private ClassFinder cf = ClassFactory.getClassFinder();
//    private ClassFinder cf = (ClassFinder)ObjectHolder.getSingletoneMap().get("utils.ClassFinder");
    private static final Logger logger = Logger.getLogger(ClassListHolder.class);


    private void parseClassList(String path){

        classList = new ArrayList<Class>();
        List<String> allClasses = cf.getPackageClassess(path);

        for(String str:allClasses){
            try {
                logger.info(Class.forName(str));
                classList.add(Class.forName(str));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Class> getClassList(String path){

        if(classList==null){
            logger.info("Class list is empty");
            parseClassList(path);
        }
        return classList;
    }
}
