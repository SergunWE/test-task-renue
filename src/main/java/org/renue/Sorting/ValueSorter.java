package org.renue.Sorting;

import java.util.Arrays;

public class ValueSorter
{
    public static String[] Sort(String[] values)
    {
        if(values.length > 1)
        {
            Arrays.sort(values, new LexicographicOrderComparator());
        }
        return values;
    }
}
