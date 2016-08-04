package utils;

import org.apache.log4j.Logger;
import requestHandlers.GetRequestHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ClassFinder {

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

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
