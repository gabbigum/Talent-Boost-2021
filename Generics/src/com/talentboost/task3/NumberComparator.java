package com.talentboost.task3;

import java.math.BigDecimal;
import java.util.Comparator;

public class NumberComparator implements Comparator<Number> {
    @Override
    public int compare(Number o1, Number o2) {
        return new BigDecimal(o1.toString()).compareTo(new BigDecimal(o2.toString()));
    }
}
