package org.renue.UI;

import org.renue.Finder.AirportFinder;
import org.renue.Finder.LineFinder;
import org.renue.Timer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements UserInterface
{
    private LineFinder _finder;
    private Scanner _scanner;
    private Timer _timer;

    private String _filePathCsv;
    private int _filteredColumn;

    private PrintStream _printStream;

    public ConsoleUI(String filePathCsv)
    {
        _filePathCsv = filePathCsv;
        _filteredColumn = 0;

        _scanner = new Scanner(System.in);
        _printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    }

    public ConsoleUI(String filePath, int filteredColumn)
    {
        _filePathCsv = filePath;
        _filteredColumn = filteredColumn;

        _scanner = new Scanner(System.in);
        _printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    }

    public void Run()
    {
        try
        {
            _finder = new AirportFinder(_filePathCsv);
            EnterRequest();
        }
        catch (FileNotFoundException e)
        {
            _printStream.println("File not found. Check if it exists or change the path to it.");
        }
        _scanner.close();
        _printStream.close();
    }

    private void EnterRequest()
    {
        while (_filteredColumn <= 0)
        {
            _printStream.print("Enter filtered column: ");
            try
            {
                _filteredColumn = Integer.parseInt(_scanner.nextLine());
                if (_filteredColumn <= 0)
                {
                    _printStream.println("Error. The column must be greater than 0");
                }
            }
            catch (Exception e)
            {
                _printStream.println("Incorrect input");
            }

        }
        _printStream.print("Enter request: ");
        String request = _scanner.nextLine();
        Search(request);
    }

    private void Search(String request)
    {
        _timer = new Timer();
        _timer.StartTimer();
        try
        {
            _finder.Find(request, _filteredColumn - 1);
            _timer.StopTimer();
            PrintResult();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            _printStream.println("Outside the table columns.");
        }
    }
    private void PrintResult()
    {
        int counter = 0;
        for (String key : _finder.GetColumnValues())
        {
            String[] lineInfo = _finder.GetInfo(key);
            //_printStream.println(key);
            for (String info : lineInfo)
            {
                counter++;
                _printStream.println(info);
            }
        }

        _printStream.println("Number of lines found: " + counter);
        _printStream.println("Search and sorting time: " + _timer.GetTimerTime() + " ms");
    }

}
