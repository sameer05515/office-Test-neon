package org.p.test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.prem.vocab.build.proj.VocabBuildConstants.Examples;
import com.prem.vocab.build.proj.VocabBuildConstants.Meanings;
import com.prem.vocab.build.proj.VocabBuildConstants.Word;
import com.prem.vocab.build.proj.util.XMLUtilityImpl;

public class Test {

	public static void main(String[] args) {
		try {
			XMLUtilityImpl xmlUtilityImpl = new XMLUtilityImpl();
			List<HashMap<String, String>> list = xmlUtilityImpl.getAllDescription();

			// PrintStream out = System.out;
			PrintStream out = new PrintStream("C:/Users/premendra.kumar1/Desktop/txn/test1.txt");

			method4(out, list, xmlUtilityImpl);

			out.println(list.size());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final String exerciseNodeContainer = "exerciseNodeContainer";
	public static final String exerciseHeaderNode = "exerciseHeaderNode";
	public static final String currentExerciseNodeAllowedTimeToDisplay = "currentExerciseNodeAllowedTimeToDisplay";
	public static final String exerciseNode = "exerciseNode";
	public static final String exerciseNodeImageList = "exerciseNodeImageList";
	public static final String exerciseNodeImage = "exerciseNodeImage";
	public static final String fileWriterURL = "http://127.0.0.1:8080/bce/fileWriter?documentId=";
	public static final String imageWidth = "500";
	public static final String imageHeight = "500";
	public static final String allowedTimeForWord = "120";

	private static void method4(PrintStream out, List<HashMap<String, String>> list, XMLUtilityImpl xmlUtilityImpl)
			throws Exception {

		int allCount = 0;
		StringBuilder objStrBuilder = new StringBuilder("");
		objStrBuilder.append("[");
		for (int i = list.size() - 1; i >= 0; i--) {
			HashMap<String, String> mapObject = list.get(i);

			if (i != list.size() - 1) {
				objStrBuilder.append(",");
			}
			objStrBuilder.append("{");
			if (mapObject.keySet() != null && mapObject.keySet().size() > 0) {

				objStrBuilder.append(append("id", "" + (i + 1)));
				objStrBuilder.append(",");
				objStrBuilder.append(append(Word.node.getName(), getValue(mapObject, Word.node.getName())));
				objStrBuilder.append(",");
				objStrBuilder.append(append(Word.TYPE.getName(), getValue(mapObject, Word.TYPE.getName())));
				objStrBuilder.append(",");

				objStrBuilder.append("\"" + Meanings.node.getName() + "\":");
				objStrBuilder.append("[");
				String mapValueForKey = getValue(mapObject, Meanings.node.getName());

				if (mapValueForKey != null && !mapValueForKey.trim().equalsIgnoreCase("")) {
					String[] strarr = mapValueForKey.trim().split("-->");
					int count = 0;
					for (String str : strarr) {
						
						if (count>0) {
							objStrBuilder.append(",");
						}
						
						objStrBuilder.append("{");
						objStrBuilder.append(append("id", "" + (++count)));
						objStrBuilder.append(",");
						objStrBuilder.append(append("meaning", str));
						objStrBuilder.append("}");
					}
				}
				objStrBuilder.append("]");

				objStrBuilder.append(",");

				objStrBuilder.append("\"" + Examples.node.getName() + "\":");
				objStrBuilder.append("[");
				mapValueForKey = getValue(mapObject, Examples.node.getName());

				if (mapValueForKey != null && !mapValueForKey.trim().equalsIgnoreCase("")) {
					String[] strarr = mapValueForKey.trim().split("-->");
					int count = 0;
					for (String str : strarr) {
						
						if (count>0) {
							objStrBuilder.append(",");
						}
						
						objStrBuilder.append("{");
						objStrBuilder.append(append("id", "" + (++count)));
						objStrBuilder.append(",");
						objStrBuilder.append(append("example", str));
						objStrBuilder.append("}");
					}
				}
				objStrBuilder.append("]");
				///////////////////
			}
			objStrBuilder.append("}");
		}

		objStrBuilder.append("]");

		out.println(objStrBuilder.toString());

	}

	private static String append(String key, String value) {

		return "\"" + key + "\"" + ":" + "\"" + value + "\"";
	}

	private static void method3(PrintStream out, List<HashMap<String, String>> list, XMLUtilityImpl xmlUtilityImpl)
			throws Exception {

		int allCount = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			HashMap<String, String> mapObject = list.get(i);

			if (mapObject.keySet() != null && mapObject.keySet().size() > 0) {

				///////////////
				out.println("<div id=\"" + exerciseNodeContainer + (i + 1) + "\">");
				out.println("\t<div id=\"" + exerciseHeaderNode + (i + 1) + "\" class=\"excerciseHeader\">"
						+ getValue(mapObject, Word.node.getName()) + "</div>");
				out.println("\t\t<div id=\"" + currentExerciseNodeAllowedTimeToDisplay + (i + 1) + "\" >"
						+ allowedTimeForWord + "</div>");
				out.println("\t<div id=\"" + exerciseNode + (i + 1) + "\" class=\"htmlClass prem\">");
				out.println("\t<div id=\"" + exerciseNodeImageList + (i + 1) + "\">");
				out.println("\t<div id=\"" + exerciseNodeImage + (i + 1) + "_" + (i + 1) + "\">");
				//////////////

				out.println("\t<div class=\"planet premu426\">");

				out.println("\t<table>");
				String mapValueForKey = getValue(mapObject, Word.node.getName());
				out.println("\t<tr>");
				out.println("\t<td>");
				out.println(Word.node.getName() + ":" + "<h1>" + (++allCount) + " : " + mapValueForKey + "</h1>");
				out.println("</td>");

				mapValueForKey = getValue(mapObject, Word.TYPE.getName());

				out.println("<td>");
				out.println(Word.TYPE.getName() + ":" + "<h1>" + mapValueForKey + "</h1>");
				out.println("</td></tr>");

				mapValueForKey = getValue(mapObject, Meanings.node.getName());

				if (mapValueForKey != null && !mapValueForKey.trim().equalsIgnoreCase("")) {
					String[] strarr = mapValueForKey.trim().split("-->");
					int count = 0;
					out.println("<tr>");
					out.println("<td>");
					out.println(Meanings.node.getName());
					out.println("</td>");
					out.println("<td>");
					for (String str : strarr) {

						out.println("<h1>" + (++count) + " : " + " : " + str + "</h1>");
					}
					out.println("</td></tr>");

				}

				mapValueForKey = getValue(mapObject, Examples.node.getName());

				if (mapValueForKey != null && !mapValueForKey.trim().equalsIgnoreCase("")) {
					String[] strarr = mapValueForKey.trim().split("-->");
					int count = 0;
					out.println("<tr>");
					out.println("<td>");
					out.println(Examples.node.getName());
					out.println("</td>");
					out.println("<td>");
					for (String str : strarr) {

						out.println("<h1>" + (++count) + " : " + " : " + str + "</h1>");
					}
					out.println("</td></tr>");

				}

				out.println("</table>");
				out.println("</div>");

				///////////
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>\n\n");
				/////////
			}

		}

		out.println(list.size());

	}

	public static String getValue(HashMap<String, String> mapObject, String key) {
		String ret = "";
		if (mapObject.containsKey(key)) {
			ret = mapObject.get(key);
			ret = (ret != null) ? ret : "";
		}

		return ret;
	}

}
