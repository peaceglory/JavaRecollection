package mockito;

import mockito.calculator.CalculatorService;
import mockito.calculator.MathApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Created by mman on 03.05.17.
 */
// @RunWith attaches a runner with the test class to initialize the test data
@ExtendWith(MockitoExtension.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication;

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAddSimple() {
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0, 20.0)).thenReturn(30.00);

        //test the add functionality
        double result = mathApplication.add(10.0, 20.0);
        assertEquals(result, 30.0, 0);

        verify(calcService, times(1)).add(10.0, 20.0);
    }

    @Test
    public void testAddWithNever() {
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //add the behavior of calc service to subtract two numbers
        when(calcService.subtract(20.0,10.0)).thenReturn(10.00);

        //test the add functionality
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        //test the subtract functionality
        assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0.0);

        //default call count is 1
        verify(calcService).subtract(20.0, 10.0);

        //check if add function is called three times
        verify(calcService, times(3)).add(10.0, 20.0);

        //verify that method was never called on a mock
        verify(calcService, never()).multiply(10.0,20.0);
    }

    public void testAddWithAtLeast() {
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //add the behavior of calc service to subtract two numbers
        when(calcService.subtract(20.0,10.0)).thenReturn(10.00);

        //test the add functionality
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        //test the subtract functionality
        assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0.0);

        //check a minimum 1 call count
        verify(calcService, atLeastOnce()).subtract(20.0, 10.0);

        //check if add function is called minimum 2 times
        verify(calcService, atLeast(2)).add(10.0, 20.0);

        //check if add function is called maximum 3 times
        verify(calcService, atMost(3)).add(10.0,20.0);
    }

    @Test
    public void testAddWithException() {
        //add the behavior to throw exception
        doThrow(new RuntimeException("Add operation not implemented")).when(calcService).add(10.0,20.0);

        //test the add functionality
        assertThrows(RuntimeException.class, () -> mathApplication.add(10.0, 20.0));

    }
}
