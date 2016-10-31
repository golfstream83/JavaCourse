package ru.tuin;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 31.10.2016
 */
public class EngineerInteractCalculatorTest {

    @Test
    public void whenDetermineSinusNumberThenGetResult() {
        EngineerCalculator engCalc = new EngineerCalculator();
        ValidateInput input = mock(ValidateInput.class);
        Print print = new Print();
        EngineerInteractCalculator engineerInteractCalculator = new EngineerInteractCalculator(input, engCalc, print);
        double expectedResult = 0.8414709848078965;

        when(input.askNumber("Please, enter the number: ")).thenReturn(1d);
        engineerInteractCalculator.select(6);
        double actualResult = engineerInteractCalculator.getPrevResult();

        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void whenDetermineCosineNumberThenGetResult() {
        EngineerCalculator engCalc = new EngineerCalculator();
        ValidateInput input = mock(ValidateInput.class);
        Print print = new Print();
        EngineerInteractCalculator engineerInteractCalculator = new EngineerInteractCalculator(input, engCalc, print);
        double expectedResult = 0.5403023058681398;

        when(input.askNumber("Please, enter the number: ")).thenReturn(1d);
        engineerInteractCalculator.select(5);
        double actualResult = engineerInteractCalculator.getPrevResult();

        assertThat(actualResult, is(expectedResult));
    }

}