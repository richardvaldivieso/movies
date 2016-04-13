package com.movies.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Util {
    private MathFunctions mathFunctions;
    @Autowired
    public Util(MathFunctions mathFunctions) {
        this.mathFunctions = mathFunctions;
    }

    public int addTwoNumbers(int i, int i1) {
        return mathFunctions.sum(i, i1);
    }
}
