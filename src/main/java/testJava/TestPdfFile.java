package testJava;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.text.PDFTextStripper;

public class TestPdfFile {

	private static final Logger log = LogManager.getLogger(TestPdfFile.class.getName());

	public static void main(String[] args){

		try (PDDocument document = new PDDocument()) {
			PDPage my_page = new PDPage();
			document.addPage(my_page);
			PDPageContentStream contentStream = new PDPageContentStream(document,my_page);
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
			contentStream.newLineAtOffset(25, 500);
			String text = "This is the sample document and we are adding content to it.";
			contentStream.showText(text);
			contentStream.endText();
			contentStream.close();
			log.info("document page number: {}",document.getNumberOfPages());
			document.save("/tmp/auto_pdf_stuff.pdf");
			PDFTextStripper stripper = new PDFTextStripper();
			String textStripped = stripper.getText(document);
			log.debug(textStripped);
			PDDocument document2=PDDocument.load(new File("/home/frafor/PERSONAL_SOFTWARE/DEVELOPMENT/PROJECTS/QA_PROJECTS/signflow-regression-tests-cucumber/target/myfile"));
			textStripped = stripper.getText(document2);
			log.debug(textStripped);
			PDDocument document3=PDDocument.load(new File("/tmp/SampleSignedPDFDocument.pdf"));
			PDSignature pds = new PDSignature();
	//		document3.getSignatureFields().forEach(x->System.out.println(x.getFullyQualifiedName()));
			
		} catch (Exception e) {
			log.error(e);
		}
	}

}
