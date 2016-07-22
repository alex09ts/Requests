package utils;

import annotations.ClassAnnotation;
import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by noname on 22.07.16.
 */
public class ClassListParser {

    public List<Class> getClassList(String path){
//public static void main(String[] args) throws ClassNotFoundException {


        List<Class> list = new ArrayList<Class>();
        ClassFinder cf = new ClassFinder();
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
}
