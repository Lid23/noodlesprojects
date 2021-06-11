package com.noodles.spirepdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

/**
 * @filename PDFtoHTML
 * @description
 * @author 巫威
 * @date 2021/4/14 18:17
 */
public class PDFtoHTML {
	public static void main(String[] args) throws FileNotFoundException {

		String inputFile = "C:\\Users\\KJ00019\\Desktop\\安心签/随手借合同.pdf";
		String outputFile = "C:\\Users\\KJ00019\\Desktop\\安心签/随手借合同-out.html";

		//加载示例文档
		PdfDocument pdf = new PdfDocument();

		pdf.loadFromFile(inputFile);

		//设置useEmbeddedSvg和 useEmbeddedImg布尔值为true
		pdf .getConvertOptions().setPdfToHtmlOptions(true,true);

		//保存到流
		File outFile = new File(outputFile);
		OutputStream outputStream = new FileOutputStream(outFile);
		pdf.saveToStream(outputStream, FileFormat.HTML);
		pdf.close();

	}
}
