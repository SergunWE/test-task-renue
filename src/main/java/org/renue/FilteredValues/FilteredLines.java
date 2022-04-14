package org.renue.FilteredValues;

public class FilteredLines extends FilteredData<String>
{
    public String[] GetInfo(String columnValue)
    {
        return _data.get(columnValue).toArray(new String[0]);
    }
}
