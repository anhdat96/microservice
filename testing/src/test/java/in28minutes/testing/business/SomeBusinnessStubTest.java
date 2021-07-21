package in28minutes.testing.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// create a stubData ServiceImpl to set data

class SomeDataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

public class SomeBusinnessStubTest {
    @Test
    public void calculated_basicUsingDataService(){
        BusinessImpl business = new BusinessImpl( );
        // i dont want my test talking with dataBase
        business.setSomeDataService(new SomeDataServiceStub());
        int result = business.calculatedSomeDataService();
        int expectedResult = 8;
        assertEquals(expectedResult,result);
    }
}
