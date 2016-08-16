package classHolders;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassListHolder {

    private List<Class> classList;
    private List<String> classNameList;
    private static Map<String, Object> mmm;
    private static final Logger logger = Logger.getLogger(ClassListHolder.class);

    public ClassListHolder(List<String> allClasses){
        classNameList = allClasses;
        classList = new ArrayList<Class>();
    }

    public Map<String, Object> goSingletoneMap() {
        mmm = new HashMap<String, Object>();
        try {
            for (Class clazz : classList){
                mmm.put(clazz.getCanonicalName(), clazz.newInstance());
            }
            return mmm;
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }

    public static Map<String, Object> getSingletoneMap() {
        return mmm;
    }

    public List<Class> parseClassList(){
        for(String str:classNameList){
            try {
                classList.add(Class.forName(str));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classList;
    }

    public List<Class> getClassList(){

        if(classList==null){
            logger.info("Class list is empty");
            parseClassList();
        }
        return classList;
    }
}
