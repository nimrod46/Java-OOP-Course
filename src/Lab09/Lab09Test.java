package Lab09;

public class Lab09Test {

    public static void main( String[] args ) {
        Exceptions e = new Exceptions();
        for (String s : args) {
            e.process("src\\Lab09\\" + s);
            /*
             * wait a second, to let any exception processing complete
             * before examining another input file.
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
