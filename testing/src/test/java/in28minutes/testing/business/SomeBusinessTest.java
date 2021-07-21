package in28minutes.testing.business;


import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessTest {

    @Test
    public void calculated_basic(){
        BusinessImpl business = new BusinessImpl( );
        int result = business.calculated(new int[]{1,3,4});
        int expectedResult = 8;
        assertEquals(expectedResult,result);
    }

}
