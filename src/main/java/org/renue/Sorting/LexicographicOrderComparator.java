package org.renue.Sorting;

import java.util.Comparator;

public class LexicographicOrderComparator implements Comparator<String>
{
    public int compare(String a, String b)
    {
        //Этот метод сравнивает строки лексикографически
        return a.compareTo(b);
    }
}
