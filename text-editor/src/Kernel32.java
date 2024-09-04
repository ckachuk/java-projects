import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32 extends StdCallLibrary {

    Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class);
    public static final int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 0x0004, ENABLE_PROCESSED_OUTPUT = 0x0001;

    int ENABLE_LINE_INPUT = 0x0002;
    int ENABLE_PROCESSED_INPUT = 0x0001;
    int ENABLE_ECHO_INPUT = 0x0004;
    int ENABLE_MOUSE_INPUT = 0x0010;
    int ENABLE_WINDOW_INPUT = 0x0008;
    int ENABLE_QUICK_EDIT_MODE = 0x0040;
    int ENABLE_INSERT_MODE = 0x0020;
    int ENABLE_EXTENDED_FLAGS = 0x0080;

    int ENABLE_VIRTUAL_TERMINAL_INPUT = 0x0200;


    int STD_OUTPUT_HANDLE = -11;
    int STD_INPUT_HANDLE = -10;
    int DISABLE_NEWLINE_AUTO_RETURN = 0x0008;
//    void GetConsoleScreenBufferInfo(Pointer hConsoleHandle, CONSOLE_SCREEN_BUFFER_INFO hInfo) throws LastErrorException;
    void GetConsoleMode (Pointer hConsoleHandle, IntByReference out_lpMode) throws LastErrorException;
    void SetConsoleMode (Pointer hConsoleHandle, int dwMode) throws LastErrorException;

    Pointer GetStdHandle(int nStdHandle);
}
