import java.io.IOException;
import java.util.logging.*;

public class LoggerTest {

    public static void main(String args[]) {
        final Logger myLogger = Logger.getLogger("mylooger");
        Handler handler = new ConsoleHandler();//创建一个把记录发送到控制台的日志处理器
        handler.setLevel(Level.FINE);//设置日志处理器级别

        FileHandler fileHandler = null;//创建一个把日志发送到文件的日志处理器
        try {
            fileHandler = new FileHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //添加处理器
        myLogger.addHandler(fileHandler);
        myLogger.addHandler(handler);

        myLogger.setLevel(Level.FINEST);//设置日志记录器级别
        //为日志记录器添加不同级别的记录
        myLogger.info("INFO");
        myLogger.warning("WARNING");
        myLogger.fine("FINE");
        myLogger.finest("FINEST");

        //获取调用方法和类的确切信息
        myLogger.logp(Level.INFO, "LoggerTest", "main", "method record");

    }

}
