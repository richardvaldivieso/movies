package com.movies.util;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class MathFunctionsTest {
    @Test
    public void AddTwoNumbers_ReturnTotal() {
        MathFunctions mathFunctions = mock(MathFunctions.class);
        Util util = new Util(mathFunctions);
        doReturn(4).when(mathFunctions).getANumber();

        util.addTwoNumbers(1, 3);
        verify(mathFunctions).sum(1, 3);
    }
}
