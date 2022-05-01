package HW3;

import java.io.IOException;
import java.io.Writer;

@SuppressWarnings("serial")
public class HW3Exception extends Exception {

    public HW3Exception(String message) {
        super(message);
    }

    public void writeToWriter(Writer writer, int lineNumber, String line) throws IOException {
        writer.write(String.format("line number = %d, input line = \"%s\" , Error message = %s\n",
                lineNumber, line, getMessage()));
        writer.flush();
    }


}
