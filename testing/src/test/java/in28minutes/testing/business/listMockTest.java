package in28minutes.testing.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.internal.matchers.Any;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class listMockTest {
    List mock = mock(List.class);


    @Test
    public void test() {
        // create a mock of interface
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValue() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28minutes");
        assertEquals("in28minutes",mock.get(0));

    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes",mock.get(0));
        assertEquals("in28minutes",mock.get(2));

    }

    @Test
    public void verificationBasic(){
        //
        String value = (String) mock.get(0);

        //
        verify(mock).get(0);
        verify(mock).get(anyInt());
        verify(mock,times(1)).get(anyInt());
    }

    //
    @Test
    public void argumentCapture(){
        mock.add("String value");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        // check the method add is call or not then capture the argument
        verify(mock).add(captor.capture());
        assertEquals("String value",captor.getValue());
    }
}
