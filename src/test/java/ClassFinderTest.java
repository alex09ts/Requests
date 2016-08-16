import org.junit.Test;
import utils.ClassFinder;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by noname on 16.08.16.
 */
public class ClassFinderTest {
    @Test
    public void getPackageClassessTest_Package_RequestHandlers_FirstElementMatching() throws Exception {
        ClassFinder classFinder = new ClassFinder();
        List<String> testList  = classFinder.getPackageClassess("requestHandlers");
        assertEquals("First element must be GetRequestHandler", "requestHandlers.GetRequestHandler" , testList.get(0));
    }

    @Test
    public void getPackageClassessTest_Package_Random_FirstElementMustBeNull() throws Exception {
        ClassFinder classFinder = new ClassFinder();
        List<String> testList  = classFinder.getPackageClassess("Random");
        assertEquals("First element must be null", true , testList.isEmpty());
    }
}