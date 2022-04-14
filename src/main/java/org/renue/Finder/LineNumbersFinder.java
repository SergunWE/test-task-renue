package org.renue.Finder;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LineNumbersFinder extends Finder<Integer>
{
    private int _lineNumber;

    public LineNumbersFinder(String filePath, int columnNumber, char separator, char mark) throws FileNotFoundException
    {
        super(filePath, columnNumber, separator, mark);
    }

    @Override
    protected String ReadLine() throws IOException
    {
        _lineNumber++;
       return super.ReadLine();
    }

    @Override
    protected void AddData()
    {
        //вместо сохранения содержимого строки, сохраняем номер строки
        //для вывода данных придётся много раз обращаться к файлу
        _filteredValues.AddData(_columnValue, _lineNumber);
    }

    public Integer[] GetInfo(String columnValue)
    {
        return (Integer[]) _filteredValues.GetInfo(columnValue);
    }
}
