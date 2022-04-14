package org.renue.Finder;

import org.renue.Finder.LineFinder;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AirportFinder extends LineFinder
{
    public AirportFinder(String filePath) throws FileNotFoundException
    {
        super(filePath, 14, ',', '\"');
    }

    @Override
    public void Find(String request, int filterColumnIndex) throws IOException
    {
        super.Find(request, filterColumnIndex);
        Sort();
    }
}
