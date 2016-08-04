package utils;

public class Utils {
    private static final String packageName = "requestHandlers";
    private static final String classFinderPath = "utils.ClassFinder";
    private static final String classFactoryPath = "factory.ClassFactory";
    private static final String classListHolderPath = "classHolders.ClassListHolder";
    private static final String parametr = "param";

    public static String getParametr() {
        return parametr;
    }

    public static String getClassListHolderPath() {
        return classListHolderPath;
    }

    public static String getPackageName() {
        return packageName;
    }

    public static String getClassFinderPath() {
        return classFinderPath;
    }

    public static String getClassFactoryPath() {
        return classFactoryPath;
    }
}
