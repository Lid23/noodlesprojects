package com.noodles.spirepdf;

/**
 * @filename FindAndReplaceText
 * @description
 * @author 巫威
 * @date 2021/4/14 17:44
 */
import com.spire.pdf.*;
import com.spire.pdf.general.find.PdfTextFind;
import com.spire.pdf.general.find.PdfTextFindCollection;
import com.spire.pdf.graphics.PdfBrushes;
import com.spire.pdf.graphics.PdfRGBColor;
import com.spire.pdf.graphics.PdfSolidBrush;
import com.spire.pdf.graphics.PdfTrueTypeFont;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class FindAndReplaceText {
	public static void main(String[] args) {
		//加载示例PDF文档
		PdfDocument pdf = new PdfDocument();
		pdf.loadFromFile("C:\\Users\\KJ00019\\Desktop\\安心签/随手借合同.pdf");

		//遍历文档每一页
		for (int i = 0; i < pdf.getPages().getCount(); i++)
		{
			//获取所有页面
			PdfPageBase page = pdf.getPages().get(i);

			//查找指定文本
			PdfTextFindCollection textFindCollection;
			textFindCollection = page.findText("71202003280160928",false);

			//创建画刷、字体
			PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.red));
			PdfTrueTypeFont font1= new PdfTrueTypeFont(new Font("宋体",Font.PLAIN,9),true);

			//用新的文本字符替换原有文本
			Rectangle2D rec;
			for(PdfTextFind find: textFindCollection.getFinds())
			{
				rec = find.getBounds();
				page.getCanvas().drawRectangle(PdfBrushes.getWhite(), rec);
				page.getCanvas().drawString("1234567891011111454", font1, brush1, rec);
			}

		}

		//保存文档
		pdf.saveToFile("C:\\Users\\KJ00019\\Desktop\\安心签/随手借合同-new.pdf");
		pdf.close();

		System.out.println("done");
	}
}
