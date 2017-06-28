import java.io.*;

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

//    public static void main(String[] args) throws Exception {
//        FileInputStream inputStream = new FileInputStream("C:\\Users\\Administrator.BJXX-50NUQL11B5\\Desktop\\123.csv");
//        InputStreamReader reader = new InputStreamReader(inputStream, "gbk");
//
//        char[] cbuf = new char[1024];
//        int hasRead = 0;
//        while((hasRead = reader.read(cbuf)) > 0) {
//            System.out.println(new String(cbuf, 0, hasRead));
//        }
//    }

//    public static void main(String[] args) throws IOException{
//        InputStreamReader isr = new InputStreamReader(System.in);
//
//        BufferedReader br = new BufferedReader(isr);
//
//        String line;
//
//        while((line = br.readLine()) != null) {
//            if(line.equals("exit")) {
//                System.exit(1);
//            }
//            System.out.println(line);
//        }
//    }

//    public static void main(String[] args) throws IOException{
//        InputStream r = new FileInputStream("C:\\Users\\Administrator.BJXX-50NUQL11B5\\Desktop\\123.csv");
//        Reader isr = new InputStreamReader(r,"gbk");
//        BufferedReader br = new BufferedReader(isr);
//
//        String line;
//
//        while((line = br.readLine()) != null) {
//            if(line.equals("exit")) {
//                System.exit(1);
//            }
//            System.out.println(line);
//        }
//    }

//    public static void main(String[] args) throws IOException {
//        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Administrator.BJXX-50NUQL11B5\\Desktop\\123.csv", "r");
//        System.out.println("文件指针初始位置：" + raf.getFilePointer());
//        raf.seek(300);
//        byte[] buf = new byte[1024];
//        int hasRead = 0;
//
//        while((hasRead = raf.read(buf)) > 0) {
//            System.out.println(new String(buf, 0, hasRead));
//        }
//    }

    public static void insert(String fileName, long pos, String insertContent) throws IOException{
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        FileOutputStream fos = new FileOutputStream(tmp);
        FileInputStream fis = new FileInputStream(tmp);

        raf.seek(pos);

        byte[] buf = new byte[64];

        int hasRead = 0;
        while((hasRead = raf.read(buf)) > 0) {
            fos.write(buf,0,hasRead);
        }

        raf.seek(pos);

        raf.write(insertContent.getBytes());

        while((hasRead = fis.read(buf)) > 0) {
            raf.write(buf, 0, hasRead);
        }

        raf.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException{
        insert("C:\\Users\\Administrator.BJXX-50NUQL11B5\\Desktop\\123.csv", 45, "");
    }
}
