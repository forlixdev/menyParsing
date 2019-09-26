package testJava;

import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;
import org.apache.pdfbox.pdmodel.PDEmbeddedFilesNameTreeNode;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;

import com.google.common.io.Files;

public class TestPdfFileAttachment {

	private static final Logger log = LogManager.getLogger(TestPdfFileAttachment.class.getName());

	public static void main(String[] args){

		//String inputFile="/home/frafor/Downloads/110320191yijtc13ucu2umscyhjd9770h7lytwvxbru74zi7k4i1g07l";
		String inputFile="/home/frafor/PERSONAL_SOFTWARE/DEVELOPMENT/PROJECTS/QA_PROJECTS/signflow-regression-tests-cucumber/target/myfile";
		
		try (PDDocument pd =  PDDocument.load(new File(inputFile))) {

			//Writes all embedded Filenames (from pdf document) into Logfile
			try{
			    PDDocumentCatalog catalog = pd.getDocumentCatalog();
			    PDDocumentNameDictionary names = catalog.getNames();
			    PDEmbeddedFilesNameTreeNode embeddedFiles = names.getEmbeddedFiles();
			    Map<String, PDComplexFileSpecification> embeddedFileNames = embeddedFiles.getNames();

			    //For-Each Loop is used to list all embedded files (if there is more than one)          
			    for (Map.Entry<String, PDComplexFileSpecification> entry : embeddedFileNames.entrySet())
			    {   
			        //You might need to configure the logger first
			    	log.info("Inputfile: " + inputFile +" Found embedded File: " + entry.getKey() + ":" +entry.getValue());
			    	PDComplexFileSpecification pdc = entry.getValue();
			    	Files.write(pdc.getEmbeddedFile().toByteArray(),new File("/tmp/pippo"));
			    }

			    
			    
			}
			catch (Exception e){
			    System.out.println("Document has no attachments. ");
			}
			
			
			
		} catch (Exception e) {
			log.error(e);
		}
	}

}
