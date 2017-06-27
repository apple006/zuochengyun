import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by dengdechao on 2017/6/27.
 */
public class InputOutputPractic {

//    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator.BJXX-50NUQL11B5\\Desktop\\123.csv");
//        byte[] bbuf = new byte[1024];
//        int hasRead = 0;
//        while((hasRead = fis.read(bbuf)) > 0) {
//            System.out.println(new String(bbuf, 0, hasRead));
//        }
//
//        fis.close();
//    }

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Administrator.BJXX-50NUQL11B5\\Desktop\\123.csv");
        InputStreamReader reader = new InputStreamReader(inputStream, "gbk");

        char[] cbuf = new char[1024];
        int hasRead = 0;
        while((hasRead = reader.read(cbuf)) > 0) {
            System.out.println(new String(cbuf, 0, hasRead));
        }
    }
}
