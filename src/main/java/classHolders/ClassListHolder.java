package classHolders;

import utils.ClassFinder;
import utils.UtilFactory;

import java.util.ArrayList;
import java.util.List;

public class ClassListHolder {

    private List<Class> classList;
    private ClassFinder cf = UtilFactory.INSTANCE.getClassFinder();

    public ClassListHolder(String path){
        classList = parseClassList(path);
    }

    public List<Class> parseClassList(String path){


        List<Class> list = new ArrayList<Class>();
        List<String> allClasses = cf.getPackageClassess(path);

        for(String str:allClasses){
            try {
                list.add(Class.forName(str));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list;

    }

    public List<Class> getClassList(){
        return classList;
    }
}
