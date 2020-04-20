package test.com.example.demo.model.dto;

import com.example.demo.model.dto.Students;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Students Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>4月 19, 2020</pre>
 */
public class StudentsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: validTest()
     */
    @Test
    public void testValidTest() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = Students.getClass().getMethod("validTest"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/

    }

    @Test
    public void test22() {

        Students students = new Students();
        students.validTest();
    }
} 
