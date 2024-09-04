import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WindowsTerminal windowsTerminal = new WindowsTerminal();

        windowsTerminal.enableRawMode();

        System.out.printf("\033[2J\033");
        
        while (true) {
            int key = System.in.read();
            System.out.println((char) key);
        }
    }
}

