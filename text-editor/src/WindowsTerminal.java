import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

interface Terminal {
    void enableRawMode();

    void disableRawMode();

//    WindowSize getWindowSize();
}
public class WindowsTerminal implements Terminal {
    private static final Kernel32 KERN = Kernel32.INSTANCE;
    private IntByReference inMode;
    private IntByReference outMode;

    public void enableRawMode(){
        Pointer inHandle =  Kernel32.INSTANCE.GetStdHandle(Kernel32.STD_INPUT_HANDLE);
        inMode = new IntByReference();
        KERN.GetConsoleMode(inHandle, inMode);

        int inMode;
        inMode = this.inMode.getValue() & ~(
                Kernel32.ENABLE_ECHO_INPUT
                        | Kernel32.ENABLE_LINE_INPUT
                        | Kernel32.ENABLE_MOUSE_INPUT
                        | Kernel32.ENABLE_WINDOW_INPUT
                        | Kernel32.ENABLE_PROCESSED_INPUT
        );

        KERN.SetConsoleMode(inHandle, inMode);

        Pointer outHandle = Kernel32.INSTANCE.GetStdHandle(Kernel32.STD_OUTPUT_HANDLE);
        outMode = new IntByReference();
        Kernel32.INSTANCE.GetConsoleMode(outHandle, outMode);

        int outMode = this.outMode.getValue();
        outMode |= Kernel32.ENABLE_VIRTUAL_TERMINAL_PROCESSING;
        outMode |= Kernel32.ENABLE_PROCESSED_OUTPUT;
        Kernel32.INSTANCE.SetConsoleMode(outHandle, outMode);

    }

    @Override
    public void disableRawMode() {
        Pointer inHandle = Kernel32.INSTANCE.GetStdHandle(Kernel32.STD_INPUT_HANDLE);
        Kernel32.INSTANCE.SetConsoleMode(inHandle, inMode.getValue());

        Pointer outHandle = Kernel32.INSTANCE.GetStdHandle(Kernel32.STD_OUTPUT_HANDLE);
        Kernel32.INSTANCE.SetConsoleMode(outHandle, outMode.getValue());
    }

//    @Override
//    public WindowSize getWindowSize() {
//        return null;
//    }
}
