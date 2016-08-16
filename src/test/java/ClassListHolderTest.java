import classHolders.ClassListHolder;
import org.junit.Before;
import org.junit.Test;
import utils.ClassFinder;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class ClassListHolderTest {

    List<String> testList;
    List<Class> testClassList;
    ClassListHolder classListHolder;
    Map<String,Object> testMap;
    Map<String,Object> testMap2;

    @Before
    public void testGetClassFinderList_Package_RequestHandlers(){
        testList = new ClassFinder().getPackageClassess("requestHandlers");
    }

    @Test
    public void testParseClassList_FirstElementMustBe_Class() throws Exception {
        ClassListHolder classListHolder = new ClassListHolder(testList);
        List<Class> testClassList = classListHolder.parseClassList();
        assertEquals("List must be nut null" , false ,testClassList.isEmpty());
        assertEquals("First element of list must be class requestHandlers.GetRequestHandler" , Class.forName("requestHandlers.GetRequestHandler") , testClassList.get(0));
    }



    @Before
    public void testGetClassFinder_PackageRequestHandlers(){
        testList = new ClassFinder().getPackageClassess("requestHandlers");
        classListHolder = new ClassListHolder(testList);
        testClassList = classListHolder.parseClassList();
    }
    @Test
    public void testGoSingletoneMap_IsPostHandlerInMap() throws Exception {

        testMap =  classListHolder.goSingletoneMap();
//        for (Map.Entry<String, Object> entry : testMap.entrySet())
//        {
//            System.out.println(entry.getKey());
//        }
        assertEquals("Map must be not null" , false ,testMap.isEmpty());
        assertEquals("Map must contain PostRequestHandler", true, testMap.containsKey("requestHandlers.PostRequestHandler"));
    }

}