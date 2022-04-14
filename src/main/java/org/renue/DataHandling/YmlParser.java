package org.renue.DataHandling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class YmlParser
{
    private HashMap<String, String> _parameters;
    private LinesReader _reader;

    private String _line;

    public YmlParser(String filePath) throws FileNotFoundException
    {
        _reader = new LinesReader(filePath);
        _parameters = new HashMap<>();
    }

    public void Read() throws IOException
    {
        _line = _reader.GetLine();
        while ((_line = _reader.GetLine()) != null)
        {
            String[] parameter = _line.split(":", 2);
            _parameters.put(parameter[0].trim(), parameter[1].trim());
        }
    }

    public String GetStringParameter(String key)
    {
        return _parameters.get(key);
    }

    public int GetIntegerParameter(String key) throws NumberFormatException
    {
        return Integer.parseInt(GetStringParameter(key));
    }

}
