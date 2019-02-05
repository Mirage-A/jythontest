import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.io.*;

public class JavaInit {
    public static void main(String[] args) throws Exception {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec(readUsingBufferedReader("src/main/python/__init__.py"));
        PyObject pyObject = interpreter.get("PyScript");
        PyObject buildingObject = pyObject.__call__();
        IScript script = (IScript)buildingObject.__tojava__(IScript.class);
        script.run(100);
        System.out.println(a);
    }
    public static int a = 0;
    public static int f() {
        a++;
        return a;
    }
    public int g() {
        return 2;
    }
    // считываем содержимое файла в String с помощью BufferedReader
    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader (fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
