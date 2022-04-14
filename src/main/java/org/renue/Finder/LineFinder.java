package org.renue.Finder;

import java.io.FileNotFoundException;

public class LineFinder extends Finder<String>
{
    public LineFinder(String filePath, int columnNumber, char separator, char mark) throws FileNotFoundException
    {
        super(filePath, columnNumber, separator, mark);
    }

    @Override
    protected void AddData()
    {
        _filteredValues.AddData(_columnValue, _line);
    }

    public String[] GetInfo(String columnValue)
    {
        return (String[]) _filteredValues.GetInfo(columnValue);
    }

}
