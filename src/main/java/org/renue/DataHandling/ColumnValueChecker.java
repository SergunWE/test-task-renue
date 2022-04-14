package org.renue.DataHandling;

public class ColumnValueChecker
{
    private String _userRequest;
    private char _mark;

    private boolean _requestEmpty;

    public ColumnValueChecker(String userRequest, char mark)
    {
        _userRequest = userRequest;
        _mark = mark;

        _requestEmpty = (_userRequest == null) || _userRequest.isEmpty();
    }

    public boolean IsRightValue(String columnValue)
    {
        if(_requestEmpty) return true;
        if(columnValue.charAt(0) == _mark)
        {
            return columnValue.indexOf(_userRequest) == 1;
        }
        return columnValue.indexOf(_userRequest) == 0;
    }
}