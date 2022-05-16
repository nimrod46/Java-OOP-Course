package Lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions {

    public void process(String fileName) {
        File file = new File(fileName);

        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Exception program - file not found");
            return;
        }

        try {
            if (scanner.hasNext()) {
                throw new FileEmptyException("Exception program - file empty");
            }
        } catch (FileEmptyException e) {
            System.out.println(e.getMessage());
        }

        int lineNumber = 0;
        double sum = 0;
        while (scanner.hasNextLine()) {
            try {
                String line = scanner.nextLine();
                lineNumber++;
                if (line == null || line.length() == 0) {
                    throw new EmptyLineException(String.format("Exception program - empty line at line number %d", lineNumber));
                }
                double n;

                if (line.split(" ").length != 1) {
                    throw new MultipleEntriesException(String.format("Exception program - multiple entries in a line.\n" +
                                    "%d entries in line %d"
                            , line.split(" ").length, lineNumber));
                }

                try {
                    n = Double.parseDouble(line);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException(String.format("Exception program - not a number.\n" +
                            "For input string: \"%s\" after processing %d lines.", line, lineNumber));
                }


                if (Math.abs(n) > 1e6) {
                    throw new EntryTooBigException(String.format("Exception program - entry too big\n" +
                            "offending entry: %f after processing %d lines. ", n, lineNumber));
                }

                if (lineNumber > 1000) {
                    throw new TooManyEntryException(String.format("Exception program - Too many entries\n" +
                            "after processing %d lines. ", lineNumber));
                }
                sum += n;
                if (sum > 5.0e8) {
                    throw new EntriesSumTooLargeException(String.format("Exception program - sum too large.\n" +
                            "is %f(exceeding %f) after processing %d lines.", sum, 5.0e8, lineNumber));
                }
            } catch (EntriesSumTooLargeException | TooManyEntryException e) {
                System.out.println(e.getMessage());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();

    }
}
