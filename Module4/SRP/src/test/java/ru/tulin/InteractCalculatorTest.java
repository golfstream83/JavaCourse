package ru.tulin;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 29.10.2016
 */
public class InteractCalculatorTest {

    @Test
    public void whenAddTwoNumbersThenGetSum() {

        Calculator calculator = new Calculator();
        ValidateInput input = mock(ValidateInput.class);
        Print print = new Print();
        InteractCalculator interactCalc = new InteractCalculator(input, calculator, print);
        double expResult = 4d;

        when(input.askNumber("Please, enter the first number: ")).thenReturn(2.0);
        when(input.askNumber("Please, enter the second number: ")).thenReturn(2.0);
        interactCalc.fillActions();
        interactCalc.select(0);

        assertThat(interactCalc.getPrevResult(), is(expResult));
    }

    @Test
    public void whenSubstructNumberThenGetDifference() {

        Calculator calculator = new Calculator();
        ValidateInput input = mock(ValidateInput.class);
        Print print = new Print();
        InteractCalculator interactCalc = new InteractCalculator(input, calculator, print);
        double expResult = 4d;

        when(input.askNumber("Please, enter the first number: ")).thenReturn(8.0);
        when(input.askNumber("Please, enter the second number: ")).thenReturn(4.0);
        interactCalc.fillActions();
        interactCalc.select(1);

        assertThat(interactCalc.getPrevResult(), is(expResult));
    }

    @Test
    public void whenDivisionNumberThenGetQuotient() {

        Calculator calculator = new Calculator();
        ValidateInput input = mock(ValidateInput.class);
        Print print = new Print();
        InteractCalculator interactCalc = new InteractCalculator(input, calculator, print);
        double expResult = 4d;

        when(input.askNumber("Please, enter the first number: ")).thenReturn(16.0);
        when(input.askNumber("Please, enter the second number: ")).thenReturn(4.0);
        interactCalc.fillActions();
        interactCalc.select(2);

        assertThat(interactCalc.getPrevResult(), is(expResult));
    }

    @Test
    public void whenMultipleNumberThenGetProduct() {

        Calculator calculator = new Calculator();
        ValidateInput input = mock(ValidateInput.class);
        Print print = new Print();
        InteractCalculator interactCalc = new InteractCalculator(input, calculator, print);
        double expResult = 4d;

        when(input.askNumber("Please, enter the first number: ")).thenReturn(2.0);
        when(input.askNumber("Please, enter the second number: ")).thenReturn(2.0);
        interactCalc.fillActions();
        interactCalc.select(3);

        assertThat(interactCalc.getPrevResult(), is(expResult));
    }

}