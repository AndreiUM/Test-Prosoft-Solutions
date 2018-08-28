package test;
import javax.xml.transform.*;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class XMLTransformation {
	
	static String i;
	static String listString;
	static String xmlFilesDirectory;
	static char[] name ;

    public static void transform(String sourcePath, String xsltPath,
            String resultDir) {

        TransformerFactory tFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = tFactory.newTransformer(new StreamSource(
                    new File(xsltPath)));
            transformer.transform(new StreamSource(new File(sourcePath)),
                    new StreamResult(new File(resultDir)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {

        // set saxon as transformer
        System.setProperty("javax.xml.transform.TransformerFactory",
                "net.sf.saxon.TransformerFactoryImpl");
        
			List<String> result = Files.find(Paths.get("./input"), 100,
				    (p, a) -> p.toString().toLowerCase().endsWith(".xml"))
				    .map(path -> path.toString())
				    .collect(Collectors.toList());
			
			String listString = result.toString();
			String i = listString.replaceAll("\\D+","");
			
		String inputFilepath = "input/orders"+ i +".xml";
        String transformXsltPath = "product.xslt";
        String outputDir = "output";
                 
        transform(inputFilepath, transformXsltPath, outputDir);
        
        File appleFile = new File("output/Apple.xml");
        File appleFile2 = new File("output/Apple"+ i + ".xml");
        
        File panasonicFile = new File("output/Panasonic.xml");
        File panasonicFile2 = new File("output/Panasonic"+ i + ".xml");
        
        File sonyFile = new File("output/Sony.xml");
        File sonyFile2 = new File("output/Sony"+ i + ".xml");
        
        boolean successApple = appleFile.renameTo(appleFile2);
        boolean successPanasonic = panasonicFile.renameTo(panasonicFile2);
        boolean successSony = sonyFile.renameTo(sonyFile2);
        
        if (!successApple || !successPanasonic || !successSony) {
        	
        }
    }


}