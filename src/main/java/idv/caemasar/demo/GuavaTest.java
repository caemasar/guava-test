package idv.caemasar.demo;

import com.google.common.base.CaseFormat;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * GuavaTest
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-20
 */
public class GuavaTest {

    @Test
    public void test() {
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        //testData
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        //testData
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
        //TestData

        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testdata"));
        //testdata
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));
        //test_data
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));
        //test-data

    }

    public static void main(String[] args) {
        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            System.out.println("____________");
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Map<String, String> xmlMap = new HashMap<>();
            xmlMap.put("a","attribute");
            xmlMap.put("c","collection");
            xmlMap.put("o","object");
            reader.getDocumentFactory().setXPathNamespaceURIs(xmlMap);
            Document document = reader.read(new File("src/main/resources/ID0.xml"));
            // 通过document对象获取根节点bookstore
            Element rootElement = document.getRootElement();
//            System.out.println(rootElement.getName());
//            System.out.println(rootElement.elements().size());

//            XPath xPath = document.createXPath("//o:Column");
//            xPath.setNamespaceURIs(xmlMap);
            Node name = document.selectSingleNode("/Model/o:RootObject/c:Children/o:Model/c:Tables/o:Table/c:Columns/o:Column/a:Name");
            List<Node> nodes = document.selectNodes("/Model/o:RootObject/c:Children/o:Model/c:Tables/o:Table/c:Columns/o:Column/a:Name");
            for (Node node : nodes) {
//                System.out.println(node.getName());
//                System.out.println(node.getPath());
                node.setText(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,node.getText()));
                System.out.println(node.getText());
            }

//            /实例化输出格式对象
            OutputFormat format = OutputFormat.createPrettyPrint();
            //设置输出编码
            format.setEncoding("UTF-8");
            //创建需要写入的File对象
            File file = new File("src/main/resources/ID02.xml");
            //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            //开始写入，write方法中包含上面创建的Document对象
            writer.write(document);


//            List<Element> elementList = rootElement.elements("Column");
//            System.out.println(elementList.size());
//            for (Element element : elementList) {
//                System.out.println(element.element("a:Name").getText());
//            }



        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
