package idv.caemasar.demo;

import com.google.common.base.CaseFormat;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Scanner;

/**
 * GuavaTest00
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-01-11
 */
public class GuavaTest00 {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入：\n");
            String str = sc.nextLine();
            System.out.println();
            str = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
            System.out.println(str);
            setIntoClipboard(str);
            System.out.println("\n-------------------------");
        }

    }

    /**
     * 获取剪切板文本
     *
     * @param
     * @return
     * @author BISC
     * @since 2019/10/9
     */
    public static void setIntoClipboard(String data) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(data), null);
    }

    /**
     * 获取剪切板文本
     *
     * @param
     * @return
     * @author BISC
     * @since 2019/10/9
     */
    public String getFromClipboard() {
        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                return (String) transferable.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e) {
                return "";
            }
        }
        return "";
    }
}
