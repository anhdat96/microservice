package in28minutes.testing.business;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    BusinessImpl business;
//    SomeDataService someDataServiceMock =  mock(SomeDataService.class);

    @Mock
    SomeDataService someDataServiceMock;

    // if you want something execute before running test , we typically use this
//    @Before
//    public void before(){
//        business.setSomeDataService(someDataServiceMock);
//    }

    @Test
    public void calculateSumUsingDataService(){
        // dataserviceMock retrieveData new int[]{1.2.3}
        // mockData from interface
        // when method retrieveAllData() is call return back data int[]{1,2,3,5}
        // ==> do not need to implement the interface to make a test
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3,5});
        int actualResult = business.calculatedSomeDataService();
        int expectedResult = 11;
        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void calculateSumUsingDataService2(){
        // dataserviceMock retrieveData new int[]{1.2.3}
        // mockData from interface
        // when method retrieveAllData() is call return back data int[]{1,2,3,5}
        // ==> do not need to implement the interface to make a test
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3,5});
        int actualResult = business.calculatedSomeDataService();
        int expectedResult = 11;
        assertEquals(expectedResult,actualResult);

    }
}
