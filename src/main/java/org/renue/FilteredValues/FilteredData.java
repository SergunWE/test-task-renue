package org.renue.FilteredValues;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class FilteredData<T>
{
    protected HashMap<String, ArrayList<T>> _data;

    public FilteredData()
    {
        _data = new HashMap<>();
    }

    public void AddData(String columnValue, T info)
    {
        if (!_data.containsKey(columnValue))
        {
            _data.put(columnValue, new ArrayList<>());
        }
        _data.get(columnValue).add(info);
    }

    public String[] GetColumnValues()
    {
        return _data.keySet().toArray(new String[0]);
    }

    public abstract T[] GetInfo(String columnValue);
}
