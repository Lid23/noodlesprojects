package com.noodles.spirepdf;

import com.spire.pdf.graphics.PdfMargins;
import com.spire.pdf.htmlconverter.qt.HtmlConverter;
import com.spire.pdf.htmlconverter.qt.Size;

/**
 * @filename HtmltoPDF
 * @description
 * @author 巫威
 * @date 2021/4/14 18:20
 */
public class HtmltoPDF {
	public static void main(String[] args) {
		//定义需要转换的HTML
		String url = "file:///C:/Users/KJ00019/Desktop/安心签/随手借合同-out.html";
		String fileName = "C:\\Users\\KJ00019\\Desktop\\安心签/随手借合同-Result.pdf";
		//设置插件本地地址
		String pluginPath = "D:\\plugins-windows-x64";
		HtmlConverter.setPluginPath(pluginPath);
		//转换到PDF并设置PDF尺寸
		HtmlConverter.convert(url, fileName, true, 1000000, new Size(600f, 900f), new PdfMargins(0));

		System.out.println("done");
	}
}
