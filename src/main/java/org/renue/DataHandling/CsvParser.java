package org.renue.DataHandling;

public class CsvParser
{
    private int _columnNumber;
    private char _separator;
    private char _mark;

    private int startPosition;
    private int endPosition;
    private int currentPosition;
    private int currentColumnIndex;

    public CsvParser(int columnNumber, char separator, char mark)
    {
        _separator = separator;
        _mark = mark;

        _columnNumber = columnNumber;
    }

    public String GetColumnValue(String line, int columnIndex)
    {
        if (columnIndex < 0 || columnIndex >= _columnNumber)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (line == null || line.isEmpty()) return null;
        return ParseColumnValue(line, columnIndex);
    }

    private String ParseColumnValue(String line, int columnIndex)
    {
        //по хорошему если нужная дальше чем на середине, то поиск надо вести с конца
        currentPosition = 0;
        startPosition = 0;
        currentColumnIndex = 0;
        while ((endPosition = line.indexOf(_separator, currentPosition)) >= 0)
        {
            char endSymbol = line.charAt(endPosition - 1);
            if (line.charAt(startPosition) == _mark && (endSymbol == '\\' || endSymbol != _mark))
            {
                currentPosition = endPosition + 1;
            }
            else
            {
                if (currentColumnIndex == columnIndex)
                {
                    return line.substring(startPosition, endPosition);
                }
                currentPosition = startPosition = endPosition + 1;
                currentColumnIndex++;
            }
        }
        return line.substring(startPosition);
    }

}
