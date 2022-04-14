package org.renue.FilteredValues;

public class FilteredLinesNumber extends FilteredData<Integer>
{
    public Integer[] GetInfo(String columnValue)
    {
        return _data.get(columnValue).toArray(new Integer[0]);
    }
}

//Монахи, хранящие обет молчания, ненавидят, когда в туалете выключают свет.
