package org.renue.DataHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LinesReader
{
    private BufferedReader _bufferedReader;

    public LinesReader(String filePath) throws FileNotFoundException
    {
        _bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    public String GetLine() throws IOException
    {
        return _bufferedReader.readLine();
    }

    public void Close() throws IOException
    {
        _bufferedReader.close();
    }


}
