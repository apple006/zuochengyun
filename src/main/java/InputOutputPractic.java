import java.io.*;
import java.util.*;

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


//在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建一个目
//录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文件

class One {
    public static void main(String[] args) throws IOException {
        File file = new File("D:", "Hello.txt");

        if (file.createNewFile()) {
            System.out.println("文件创建成功！");
        } else {
            System.out.println("文件创建失败！");
        }

        if (file.isFile()) {
            System.out.println("这是一个文件");
        } else {
            System.out.println("这是一个目录");
        }

        File file2 = new File("D:/IOTest");
        file2.mkdirs();

        if (file.renameTo(new File(file2.getPath() + "/" + file.getName()))) {
            System.out.println("文件移动成功");
        } else {
            System.out.println("文件移动失败");
        }

        String[] arr = file2.list();
        for(String s : arr) {
            System.out.print(s);
        }
    }
}


//递归实现输入任意目录，列出文件以及文件夹
class TWO {
    private static void longErgodic(File file, List<File> files) {
        File[] fileArr = file.listFiles();

        if(fileArr == null) {
            return ;
        }

        for(File file2 : fileArr) {
            files.add(file2);
            longErgodic((File)file2, files);
        }

    }

    public static List getAllFiles(String dir) {
        List<File> files = new ArrayList<>();
        File file = new File(dir);

        if(file.exists() && file.isDirectory()) {
            longErgodic(file, files);
        }

        return files;
    }

    public static void main(String[] args) throws IOException{
        List<File> list = getAllFiles("D:/IOTest");
        for(File file : list) {
            System.out.println(file.getName());
        }
    }
}


//递归实现列出当前工程下所有.Java文件
class Three {
    private static void longErgodic(File file, List<File> files) {
        File[] files2 = file.listFiles();

        if(files2 == null) {
            return ;
        }

        for(File file2 : files2) {
            if(file2.isFile() && file2.getName().matches("\\b.*\\.java\\b")) {
                files.add(file2);
            } else if(file2.isDirectory()){
                longErgodic(file2,files);
            } else {
                continue;
            }
        }
    }

    private static List<File> getAllFiles(String dir) {
        File file = new File(dir);
        List<File> list = new ArrayList<>();

        if(file.exists() && file.isDirectory()) {
            longErgodic(file, list);
        }

        return list;
    }

    public static void main(String[] args) {
        List<File> list = getAllFiles("D:/IOTest");
        for(File s : list) {
            System.out.println(s.getName());
        }
    }
}

//从磁盘读取一个文件到内存中，再打印到控制台
class FOUR {
    public static void main(String[] args) throws IOException{
        InputStream is = new FileInputStream("D:/IOTest/Hello.txt");
        InputStreamReader isr = new InputStreamReader(is, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String s;
        while((s = br.readLine()) != null) {
            System.out.println(s);
        }

        br.close();
    }
}

//在程序中写一个"HelloJavaWorld你好世界"输出到操作系统文件Hello.txt文件中

class Five {
    public static void main(String[] args) throws IOException{
        String s = "HelloWorldJava你好世界";
        OutputStream os = new FileOutputStream("D:/IOTest/Hello.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os, "GBK");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(s);

        bw.flush();
        bw.close();
    }
}

// 拷贝一张图片，从一个目录到另外一个目录下(PS:是拷贝是不是移动)

class SIX {
    public static void main(String[] args) throws IOException{
        File fileFrom = new File("D:/IOTest/picture.jpg");
        File fileTo = new File("D:/IOTest/play/picture.jpg");

        if(!fileTo.createNewFile()) {
            System.out.println("图片创建失败");
        }

        InputStream is = new FileInputStream(fileFrom);
        FileOutputStream fos = new FileOutputStream(fileTo);
        byte[] buf = new byte[1024];
        int has = 0;

        while((has = is.read(buf)) > 0) {
            fos.write(buf, 0, has);
        }

        fos.flush();
        fos.close();
        is.close();
    }
}

//统计一个文件calcCharNum2.txt（见附件）中各个字母出现次数：
//A(8),B(16),C(10)...,a(12),b(10),c(3)....中(5),国(6)，括号内代表字符出现次数;


class NINE {
    public static void main(String[] args) throws IOException{
        File file = new File("D:/IOTest/HelloWorld.txt");
        Reader r = new FileReader(file);
        Map<Character, Integer> map = new HashMap();
        int count = 0;
        int len = 0;

        while((len = r.read()) > 0) {
            char c = (char)len;
            count = map.get(c);
            map.put(c,count+1);
        }

        Iterator iterator = map.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}