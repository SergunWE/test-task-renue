package org.renue;

import org.renue.DataHandling.YmlParser;
import org.renue.UI.ConsoleUI;
import org.renue.UI.UserInterface;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            YmlParser ymlParser = new YmlParser("./application.yml");
            int filteredColumn = 0;
            String filePath;

            int argsLength = args.length;
            if(argsLength < 2)
            {
                ymlParser.Read();
            }
            switch (argsLength)
            {
                case 0:
                    filteredColumn = ymlParser.GetIntegerParameter("column");
                    filePath = ymlParser.GetStringParameter("filePath");
                    break;

                case 1:
                    filteredColumn = Integer.parseInt(args[0]);
                    filePath = ymlParser.GetStringParameter("filePath");
                    break;
                case 2:
                    filteredColumn = Integer.parseInt(args[0]);
                    filePath = args[1];
                    break;

                default:
                    throw new RuntimeException("The number of command line parameters is exceeded." +
                            " (1 - column number, 2 - CSV path)");
            }

            if(filePath == null)
            {
                filePath = "./airports.csv";
            }

            UserInterface ui = new ConsoleUI(filePath, filteredColumn);
            ui.Run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
    }
}
