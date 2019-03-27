package com.coder.kkb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java_7 {

	int num = 1_0000_0000;

	public static void main(String[] args) {

		String key = "a";

		switch (key) {
		case "a":

			break;

		default:
			break;
		}

		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<>();

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<>();

		try {
			System.exit(1);
		} catch (Exception e) {
			// 错误处理
		} finally {
			// 关闭连接
		}

//		//之前
//		catch (IOException ex) {
//			// 错误处理
//		catch (SQLException ex) {
//			// 错误处理
//		}catch (Exception ex) {
//			// 错误处理
//		}
//		
//		//现在
//		catch (IOException | SQLException | Exception ex) {
//			// 错误处理
//		}
		
	}

	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
}
