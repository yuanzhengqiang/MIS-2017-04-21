package sbtj.util.officeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

public class POICustomXWPFDocument_Test_1 {

	public static OfficeUtil ou = new OfficeUtil();

	public static void main(String[] args) throws Exception {
		// 创建新的空白文档
		CustomXWPFDocument document = new CustomXWPFDocument();
		POICustomXWPFDocument_Test_1 test = new POICustomXWPFDocument_Test_1();
		// 设置页边距
		ou.setDocumentMargin(document, "1797", "1440", "1797", "1440");
		// 测试添加文字与图片
		test.testAddTextParagraph(document);
		// 测试设置段落间距
		test.testParagraphSpacingInfo(document);
		// 测试设置段落缩进
		test.testParagraphIndInfo(document);
		// 测试表格单元格合并
		test.testMegerTableCell(document);
		// 测试添加超链接
		test.testAddHyperlink(document);
		// 测试添加页眉页脚
		test.testAddHeaderFooter(document);
		ou.saveDocument(document,
				"d:/saveFile/temp/sys_" + System.currentTimeMillis() + ".docx");
	}

	public void testAddTextParagraph(CustomXWPFDocument document)
			throws Exception {
		XWPFParagraph p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "高三化学第二轮复习", "宋体", "000000", "40",
				true, null, false, true, null, 0, null);
		XWPFParagraph p2 = document.createParagraph();
		ou.setTextFontInfo(p2, false, false, "专题 4 化学实验基础", "微软雅黑", "000000",
				"20", true, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.CENTER, TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "班级：    姓名：", "宋体",
				"000000", "21", false, UnderlinePatterns.SINGLE, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.CENTER, TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "一、单选题(共10道，每道10分)", "宋体",
				"000000", "21", true, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "100", null, true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "1.下列有关仪器用途的说法错误的是(    )", "宋体",
				"000000", "21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "A.烧杯用于较多量试剂的反应容器", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "100", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "B.烧杯用于较多量试剂的反应容器", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "C.烧杯用于较多量试剂的反应容器", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "D.烧杯用于较多量试剂的反应容器", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "2.下列实验操作中，正确的是(    ) ", "宋体",
				"000000", "21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "100", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "A.", "宋体", "000000", "21", false,
				null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "100", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);
		String blipId = p.getDocument().addPictureData(
				new FileInputStream(new File("d:/saveFile/temp/image1.png")),
				Document.PICTURE_TYPE_PNG);
		document.createPicture(blipId,
				document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90,
				93, p);

		ou.setTextFontInfo(p, true, false, StringUtils.leftPad("B.", 10), "宋体",
				"000000", "21", false, null, false, false, null, 0, null);
		blipId = p.getDocument().addPictureData(
				new FileInputStream(new File("d:/saveFile/temp/image2.png")),
				Document.PICTURE_TYPE_PNG);
		document.createPicture(blipId,
				document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90,
				93, p);

		ou.setTextFontInfo(p, true, true, "C.", "宋体", "000000", "21", false,
				null, false, false, null, 0, null);
		blipId = p.getDocument().addPictureData(
				new FileInputStream(new File("d:/saveFile/temp/image3.png")),
				Document.PICTURE_TYPE_PNG);
		document.createPicture(blipId,
				document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90,
				93, p);

		ou.setTextFontInfo(p, true, false, StringUtils.leftPad("D.", 10), "宋体",
				"000000", "21", false, null, false, false, null, 0, null);
		blipId = p.getDocument().addPictureData(
				new FileInputStream(new File("d:/saveFile/temp/image4.png")),
				Document.PICTURE_TYPE_PNG);
		document.createPicture(blipId,
				document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 90,
				93, p);
	}

	public void testParagraphSpacingInfo(XWPFDocument document) {
		ou.addNewPage(document, BreakType.PAGE);
		XWPFParagraph p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试单倍行距", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, true, false, "测试最小值10磅", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "200",
				STLineSpacingRule.Enum.forString("atLeast"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试固定值12磅", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "240",
				STLineSpacingRule.Enum.forString("exact"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试1.5倍行距", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "360",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试2倍行距", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "480",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试多倍行距3", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "0", "0", true, "720",
				STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试段前2行段后2行单倍行距", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "200", "200", true,
				"240", STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试段前2磅段后2磅单倍行距", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "40", "40", null, null, true,
				"240", STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试段前2行段后2磅单倍行距", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, null, "40", "200", null, true,
				"240", STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试段前2磅段后2行单倍行距", "宋体", "000000",
				"21", false, null, false, false, null, 0, null);
		ou.setParagraphSpacingInfo(p, true, "40", null, null, "200", true,
				"240", STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);
	}

	public void testAddHyperlink(XWPFDocument document) {
		ou.addNewPage(document, BreakType.TEXT_WRAPPING);
		XWPFParagraph p = document.createParagraph();
		ou.setTextFontInfo(p, false, true, "", "宋体", "ff0000", "24", false,
				null, false, false, null, 0, null);
		ou.setTextFontInfo(p, true, false, "接口使用", "宋体", "ff0000", "24", false,
				null, false, false, null, 0, "20");
		ou.appendExternalHyperlink("mailto:liuychn@163.com?subject=测试poi超链接",
				"联系我", p, "微软雅黑", "28", true, true, false, null, "4", "80");
		ou.setTextFontInfo(p, true, false, "接口使用", "黑体", "00ff00", "26", false,
				null, false, false, null, 0, "20");
		ou.setTextFontInfo(p, true, true, "", "宋体", "ff0000", "24", false,
				null, false, false, null, 0, null);
		ou.setParagraphAlignInfo(p, ParagraphAlignment.CENTER,
				TextAlignment.CENTER);
		ou.setParagraphSpacingInfo(p, true, "0", "0", "100", "100", true,
				"240", STLineSpacingRule.Enum.forString("auto"));
		ou.setParagraphBorder(p, Borders.DOUBLE, Borders.DOUBLE,
				Borders.DOUBLE, Borders.DOUBLE, null);
	}

	public void testParagraphIndInfo(XWPFDocument document) {
		ou.addNewPage(document, BreakType.PAGE);
		XWPFParagraph p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试首行缩进2字符", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphIndInfo(p, "440", "200", null, null, null, null, null,
				null);
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试悬挂缩进2字符", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphIndInfo(p, null, null, "440", "200", null, null, null,
				null);
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试左侧缩进2字符", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphIndInfo(p, null, null, null, null, null, null, "440",
				"200");
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);

		p = document.createParagraph();
		ou.setTextFontInfo(p, false, false, "测试右侧缩进2字符", "宋体", "000000", "21",
				false, null, false, false, null, 0, null);
		ou.setParagraphIndInfo(p, null, null, null, null, "440", "200", null,
				null);
		ou.setParagraphAlignInfo(p, ParagraphAlignment.LEFT,
				TextAlignment.CENTER);
	}

	public void testMegerTableCell(XWPFDocument doc) {
		ou.addNewPage(doc, BreakType.PAGE);
		List<String> columnList = new ArrayList<String>();
		columnList.add("序号");
		columnList.add("姓名信息|姓甚|名谁");
		columnList.add("名次信息|籍贯|营生");
		columnList.add("字");
		// 创建一个 m 行, n 列的表格
		XWPFTable table1 = doc.createTable(4, 6);
		ou.setTableWidth(table1, "4000");

		XWPFTableRow firstRow = table1.getRow(0);
		XWPFTableRow secondRow = table1.getRow(1);
		firstRow.setHeight(400);
		secondRow.setHeight(400);
		XWPFTableCell firstCell = null;
		XWPFTableCell secondCell = null;
		int firstCellIndex = 0;
		for (String str : columnList) {
			if (str.indexOf("|") == -1) {
				firstCell = firstRow.getCell(firstCellIndex);
				setCellText(firstCell, str, "CCCCCC", 1600);
				firstCellIndex++;
			} else {
				String[] strArr = str.split("\\|");
				for (int i = 1; i < strArr.length; i++) {
					firstCell = firstRow.getCell(firstCellIndex);
					setCellText(firstCell, strArr[0], "CCCCCC", 1600);
					secondCell = secondRow.getCell(firstCellIndex);
					setCellText(secondCell, strArr[i], "CCCCCC", 1600);
					firstCellIndex++;
				}
			}
		}

		// 合并行(跨列)
		firstCellIndex = 0;
		for (String str : columnList) {
			if (str.indexOf("|") == -1) {
				firstCellIndex++;
			} else {
				String[] strArr = str.split("\\|");
				ou.mergeCellsHorizontal(table1, 0, firstCellIndex,
						firstCellIndex + strArr.length - 2);
				firstCellIndex += strArr.length - 1;
			}
		}

		// 合并列(跨行)
		firstCellIndex = 0;
		for (String str : columnList) {
			if (str.indexOf("|") == -1) {
				ou.mergeCellsVertically(table1, firstCellIndex, 0, 1);
				firstCellIndex++;
			} else {
				String[] strArr = str.split("\\|");
				firstCellIndex += strArr.length - 1;
			}
		}

		// 数据
		for (int i = 2; i < 4; i++) {
			firstRow = table1.getRow(i);
			firstRow.setHeight(380);
			for (int j = 0; j < 6; j++) {
				firstCell = firstRow.getCell(j);
				setCellText(firstCell, "测试", "FFFFC9", 1600);
			}
		}

		// -------------------------------------
		List<String> columnList2 = new ArrayList<String>();
		columnList2.add("序号");
		columnList2.add("姓名信息|姓甚|名谁");
		columnList2.add("名次信息|籍贯|营生");
		columnList2.add("字");
		// 创建一个 m 行, n 列的表格
		XWPFTable table2 = doc.createTable(4, 6);
		ou.setTableWidth(table2, "4000");

		XWPFTableRow firstRow2 = table2.getRow(0);
		XWPFTableRow secondRow2 = table2.getRow(1);
		firstRow.setHeight(400);
		secondRow.setHeight(400);
		XWPFTableCell firstCell2 = null;
		XWPFTableCell secondCell2 = null;
		int firstCellIndex2 = 0;
		for (String str : columnList2) {
			if (str.indexOf("|") == -1) {
				firstCell2 = firstRow2.getCell(firstCellIndex2);
				setCellText(firstCell2, str, "CCCCCC", 1600);
				firstCellIndex2++;
			} else {
				String[] strArr2 = str.split("\\|");
				for (int i = 1; i < strArr2.length; i++) {
					firstCell2 = firstRow2.getCell(firstCellIndex2);
					setCellText(firstCell2, strArr2[0], "CCCCCC", 1600);
					secondCell2 = secondRow2.getCell(firstCellIndex2);
					setCellText(secondCell2, strArr2[i], "CCCCCC", 1600);
					firstCellIndex2++;
				}
			}
		}

		// 合并行(跨列)
		firstCellIndex2 = 0;
		for (String str : columnList2) {
			if (str.indexOf("|") == -1) {
				firstCellIndex2++;
			} else {
				String[] strArr2 = str.split("\\|");
				ou.mergeCellsHorizontal(table2, 0, firstCellIndex2,
						firstCellIndex2 + strArr2.length - 2);
				firstCellIndex2 += strArr2.length - 1;
			}
		}

		// 合并列(跨行)
		firstCellIndex2 = 0;
		for (String str : columnList2) {
			if (str.indexOf("|") == -1) {
				ou.mergeCellsVertically(table2, firstCellIndex2, 0, 1);
				firstCellIndex2++;
			} else {
				String[] strArr2 = str.split("\\|");
				firstCellIndex2 += strArr2.length - 1;
			}
		}

		// 数据
		for (int i = 2; i < 4; i++) {
			firstRow2 = table2.getRow(i);
			firstRow2.setHeight(380);
			for (int j = 0; j < 6; j++) {
				firstCell2 = firstRow2.getCell(j);
				setCellText(firstCell2, "测试", "FFFFC9", 1600);
			}
		}
	}

	public void setCellText(XWPFTableCell cell, String text, String bgcolor,
			int width) {
		CTTc cttc = cell.getCTTc();
		CTTcPr ctPr = cttc.addNewTcPr();
		CTShd ctshd = ctPr.addNewShd();
		ctPr.addNewTcW().setW(BigInteger.valueOf(width));
		ctshd.setFill(bgcolor);
		ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
		cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
		cell.setText(text);
	}

	public void testAddHeaderFooter(XWPFDocument doc) throws Exception {
		simpleDateHeader(doc);
		simpleNumberFooter(doc);
	}

	// 页脚:显示页码信息
	public void simpleNumberFooter(XWPFDocument document) throws Exception {
		CTP ctp = CTP.Factory.newInstance();
		XWPFParagraph codePara = new XWPFParagraph(ctp, document);
		XWPFRun r1 = codePara.createRun();
		r1.setText("第");
		r1.setFontSize(11);
		CTRPr rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr
				.addNewRFonts();
		fonts.setAscii("宋体");
		fonts.setEastAsia("宋体");
		fonts.setHAnsi("宋体");

		r1 = codePara.createRun();
		CTFldChar fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

		r1 = codePara.createRun();
		CTText ctText = r1.getCTR().addNewInstrText();
		ctText.setStringValue("PAGE  \\* MERGEFORMAT");
		ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("宋体");
		fonts.setEastAsia("宋体");
		fonts.setHAnsi("宋体");

		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

		r1 = codePara.createRun();
		r1.setText("页 总共");
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("宋体");
		fonts.setEastAsia("宋体");
		fonts.setHAnsi("宋体");

		r1 = codePara.createRun();
		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

		r1 = codePara.createRun();
		ctText = r1.getCTR().addNewInstrText();
		ctText.setStringValue("NUMPAGES  \\* MERGEFORMAT ");
		ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("宋体");
		fonts.setEastAsia("宋体");
		fonts.setHAnsi("宋体");

		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

		r1 = codePara.createRun();
		r1.setText("页");
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("宋体");
		fonts.setEastAsia("宋体");
		fonts.setHAnsi("宋体");

		codePara.setAlignment(ParagraphAlignment.CENTER);
		codePara.setVerticalAlignment(TextAlignment.CENTER);
		codePara.setBorderTop(Borders.THICK);
		XWPFParagraph[] newparagraphs = new XWPFParagraph[1];
		newparagraphs[0] = codePara;
		CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(
				document, sectPr);
		headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, newparagraphs);
	}

	public void simpleDateHeader(XWPFDocument document) throws Exception {
		CTP ctp = CTP.Factory.newInstance();
		XWPFParagraph codePara = new XWPFParagraph(ctp, document);

		XWPFRun r1 = codePara.createRun();
		CTFldChar fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

		r1 = codePara.createRun();
		CTText ctText = r1.getCTR().addNewInstrText();
		ctText.setStringValue("TIME \\@ \"EEEE\"");
		ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
		r1.setFontSize(11);
		CTRPr rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr
				.addNewRFonts();
		fonts.setAscii("微软雅黑");
		fonts.setEastAsia("微软雅黑");
		fonts.setHAnsi("微软雅黑");

		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

		r1 = codePara.createRun();
		r1.setText("年");
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("微软雅黑");
		fonts.setEastAsia("微软雅黑");
		fonts.setHAnsi("微软雅黑");

		r1 = codePara.createRun();
		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

		r1 = codePara.createRun();
		ctText = r1.getCTR().addNewInstrText();
		ctText.setStringValue("TIME \\@ \"O\"");
		ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("微软雅黑");
		fonts.setEastAsia("微软雅黑");
		fonts.setHAnsi("微软雅黑");

		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

		r1 = codePara.createRun();
		r1.setText("月");
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("微软雅黑");
		fonts.setEastAsia("微软雅黑");
		fonts.setHAnsi("微软雅黑");

		r1 = codePara.createRun();
		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

		r1 = codePara.createRun();
		ctText = r1.getCTR().addNewInstrText();
		ctText.setStringValue("TIME \\@ \"A\"");
		ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("微软雅黑");
		fonts.setEastAsia("微软雅黑");
		fonts.setHAnsi("微软雅黑");

		fldChar = r1.getCTR().addNewFldChar();
		fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

		r1 = codePara.createRun();
		r1.setText("日");
		r1.setFontSize(11);
		rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR()
				.addNewRPr();
		fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii("微软雅黑");
		fonts.setEastAsia("微软雅黑");
		fonts.setHAnsi("微软雅黑");

		codePara.setAlignment(ParagraphAlignment.CENTER);
		codePara.setVerticalAlignment(TextAlignment.CENTER);
		codePara.setBorderBottom(Borders.THICK);
		XWPFParagraph[] newparagraphs = new XWPFParagraph[1];
		newparagraphs[0] = codePara;
		CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(
				document, sectPr);
		headerFooterPolicy.createHeader(STHdrFtr.DEFAULT, newparagraphs);
	}
}
