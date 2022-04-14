package org.renue.Finder;

import org.renue.DataHandling.CsvParser;
import org.renue.FilteredValues.FilteredLines;
import org.renue.FilteredValues.FilteredData;
import org.renue.DataHandling.LinesReader;
import org.renue.DataHandling.ColumnValueChecker;
import org.renue.Sorting.ValueSorter;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Finder<T>
{
    private LinesReader _reader;
    private CsvParser _parser;
    private ColumnValueChecker _checker;
    protected FilteredData _filteredValues;

    private String _filePath;
    private char _mark;

    protected String _line;
    protected String _columnValue;
    private String[] _sortedValues;

    private boolean _isReady;

    private final String FILE_ALREADY_READ = "The file has already been read. Perform a reset. " +
            "The current result will be lost.";

    public Finder(String filePath, int columnNumber, char separator, char mark) throws FileNotFoundException
    {
        _mark = mark;
        _filePath = filePath;

        _reader = new LinesReader(_filePath);
        _parser = new CsvParser(columnNumber, separator, _mark);
        _filteredValues = new FilteredLines();

        _isReady = true;
    }

    public void Find(String request, int filterColumnIndex) throws IOException
    {
        if(!_isReady)
        {
            throw new RuntimeException(FILE_ALREADY_READ);
        }
        _checker = new ColumnValueChecker(request, _mark);

        while (ReadLine() != null)
        {
            //можно попробовать распараллелить
            _columnValue = _parser.GetColumnValue(_line, filterColumnIndex);
            if(_checker.IsRightValue(_columnValue))
            {
                AddData();
            }
        }
        _reader.Close();
        _isReady = false;
    }

    public void Sort()
    {
        _sortedValues = ValueSorter.Sort(_filteredValues.GetColumnValues());
    }

    public void Reset() throws FileNotFoundException
    {
        _reader = new LinesReader(_filePath);
        _filteredValues = new FilteredLines();
        _sortedValues = null;
        _isReady = true;
    }

    public String[] GetColumnValues()
    {
        if(_sortedValues != null)
        {
            return _sortedValues;
        }
        return _filteredValues.GetColumnValues();
    }

    protected String ReadLine() throws IOException
    {
        return _line = _reader.GetLine();
    }

    public abstract T[] GetInfo(String columnValue);
    protected abstract void AddData();
}
