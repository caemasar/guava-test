package idv.caemasar.demo.util;

import info.monitorenter.cpdetector.io.*;

import java.io.*;
import java.util.LinkedList;

/**
 * FileCharsetChangeUtil
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-06-14
 */
public class FileCharsetChangeUtil {
    public static void main(String[] args) throws Exception {
        LinkedList<File> files = traverseFolder1("E:\\现场包\\a\\file");
        InputStream is = null;
        InputStreamReader isr = null;
//        byteb
        BufferedReader br = null;

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        for (File file : files) {
            System.out.println(file.getPath());
            if ("GB2312".equals(detectorCharset(file))) {
                is = new FileInputStream(file.getPath());
                isr = new InputStreamReader(is, "gb2312");

                br = new BufferedReader(isr);
                os = new FileOutputStream(file.getPath().replace("现场包\\a", "现场包\\b"));
                osw = new OutputStreamWriter(os, "UTF-8");
                bw = new BufferedWriter(osw);
                String line;
                for (line = br.readLine(); line != null; line = br.readLine()) {
//                    System.out.println(line);
//                    bw.write(new String(line.getBytes("GB2312"), "UTF-8") + "\n");
                    bw.write(line);
                }
//                break;
            }
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isr != null) {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bw != null) {
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (osw != null) {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String detectorCharset(File f) {
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
        detector.add(new ParsingDetector(false));
        detector.add(JChardetFacade.getInstance());
        //ASCIIDetector用于ASCII编码测定
        detector.add(ASCIIDetector.getInstance());
        //UnicodeDetector用于Unicode家族编码的测定
        detector.add(UnicodeDetector.getInstance());
        java.nio.charset.Charset charset = null;
        try {
            charset = detector.detectCodepage(f.toURL());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (charset != null) {
            return charset.name();
        } else {
            return "未知";
        }
    }

    public static LinkedList<File> traverseFolder1(String path) {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        LinkedList<File> list = new LinkedList<File>();
        LinkedList<File> returnList = new LinkedList<File>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
//                    System.out.println("文件夹:" + file2.getAbsolutePath());
                    list.add(file2);
                    folderNum++;
                } else {
//                    System.out.println("文件:" + file2.getAbsolutePath());
                    returnList.add(file2);
                    fileNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
//                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
//                        System.out.println("文件:" + file2.getAbsolutePath());
                        returnList.add(file2);
                        fileNum++;
                    }
                }
            }
        } else {
//            System.out.println("文件不存在!");
        }
//        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
        return returnList;
    }
}
