package com.edu.scau.itcommunity.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
	public static void WriteFile(String content, String filepath) throws IOException {
		File file = new File(filepath + ".txt");
		if (!file.exists())
			file.createNewFile();
		FileOutputStream out = new FileOutputStream(file, false);
		StringBuffer sb = new StringBuffer();
		sb.append(content.replace("\n", "\r\n"));
//		sb.append(content);
		out.write(sb.toString().getBytes("utf-8"));
		out.close();
	}

	public static String ReadFile(String filepath) throws IOException {
		File file = new File(filepath + ".txt");
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")); 
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();
		while (temp != null) {
			sb.append(temp + "<br>");
			temp = br.readLine();
		}
		br.close();
		return sb.toString();
	}

	public static void delFile(String filepath) {
		File file = new File(filepath + ".txt");
		if (file.exists() && file.isFile())
			file.delete();
	}
}
