package utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by noname on 22.07.16.
 */
public class ClassFinder {
    public List<String> getPackageClassess(String path){
        try {
            List<String> list = new ArrayList<String>();
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(path);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                File dir = new File(url.getFile());
                for (File f : dir.listFiles()) {
                    list.add(
                            f.toPath().getParent().getFileName().toString()
                            +"."
                            +f.getName().substring(0, f.getName().indexOf(".")));
                }
            }

            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
