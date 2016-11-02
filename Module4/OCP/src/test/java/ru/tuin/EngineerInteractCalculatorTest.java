package ru.tuin;

import org.junit.Test;

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
        double expectedResult = Math.sin(1d);

        when(input.askNumber("Please, enter the number: ")).thenReturn(1d);
        engineerInteractCalculator.select(Key.SINUS);
        double actualResult = engineerInteractCalculator.getPrevResult();

        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void whenDetermineCosineNumberThenGetResult() {
        EngineerCalculator engCalc = new EngineerCalculator();
        ValidateInput input = mock(ValidateInput.class);
        Print print = new Print();
        EngineerInteractCalculator engineerInteractCalculator = new EngineerInteractCalculator(input, engCalc, print);
        double expectedResult = Math.cos(1d);

        when(input.askNumber("Please, enter the number: ")).thenReturn(1d);
        engineerInteractCalculator.select(Key.COSINE);
        double actualResult = engineerInteractCalculator.getPrevResult();

        assertEquals(expectedResult, actualResult, 0.001);
    }

}