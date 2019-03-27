package com.wyd.jvm_new.lesson10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ClassReader {

	static int[] tag = { 1, 7, 9, 10, 12 };
	static int[] tagLen = { 0, 2, 4, 4, 4 };
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static String format(byte[] bt) {
		int line = 0;
		StringBuilder buf = new StringBuilder();
		// 常量池数
		int constNum = 0;
		for (byte d : bt) {
			if (line == 8) {
				// 第9、10个字节为常量池大小
				constNum = d;
			}
			if (line == 9) {
				// 化为10进制-1为常量池表项的个数
				constNum += d - 1;
			}
			line++;
		}
		System.out.println("~常量池数 : " + constNum);
		// 常量池表项集合
		String[] constant = new String[constNum];
		// 集合对应长度
		int[] constLen = new int[constNum];
		for (int i = 0; i < tag.length; i++) {
			map.put(tag[i], tagLen[i]);
		}
		// 最后表项位置
		int lastConst = 10;
		boolean flag = false;
		for (int i = 0; i < constNum; i++) {
			if (i > 0) {
				if (flag) {
					lastConst += constLen[i - 1] + 3;
				} else {
					lastConst += constLen[i - 1] + 1;
				}
			}
			line = 0;
			for (byte d : bt) {
				if (line == lastConst) {
					if ((int) d != 1) {
						constLen[i] = map.get((int) d);
						flag = false;
						break;
					}
				}
				if (line == lastConst + 2) {
					constLen[i] = (int) d;
					flag = true;
				}
				line++;
			}
			int temp = 0;
			byte[] bs = new byte[constLen[i]];
			int bsCount = 0;
			line = 0;
			for (byte d : bt) {
				if (flag) {
					if (line > lastConst + 2
							&& line < lastConst + constLen[i] + 1 + 2) {
						bs[bsCount] = d;
						bsCount++;
					}
					if (line == lastConst + constLen[i] + 1 + 2) {
						constant[i] = new String(bs);
						break;
					}
				} else {
					if (line > lastConst && line < lastConst + constLen[i] + 1) {
						temp += (int) d;
					}
					if (line == lastConst + constLen[i] + 1) {
						constant[i] = String.valueOf(temp);
						break;
					}
				}
				line++;
			}
		}
		int sumOfConst = line;
		line = 0;
		int accessFlag = 2;
		int interfaceNum = 0;
		int fieldNum = 0;
		int methodNum = 0;
		for (int i = 0; i < bt.length; i++) {
			if (i == sumOfConst + accessFlag) {
				System.out.println("当前类为 : "
						+ constant[Integer.parseInt(constant[bt[i] + bt[++i]
								- 1]) - 1]);
				System.out.println(" 超  类 为 : "
						+ constant[Integer.parseInt(constant[bt[++i] + bt[++i]
								- 1]) - 1]);
				interfaceNum += bt[++i];
				interfaceNum += bt[++i];
				// 打印接口
				if (interfaceNum == 0) {
					System.out.println(" - - - 无接口 - - -");
				} else {
					// 每个接口占有2个字节
					System.out.println("接口数为： " + interfaceNum);
					for (int noI = 0; noI < interfaceNum; noI++) {
						System.out.println("接口分别为： "
								+ constant[bt[++i] + bt[++i] - 1]);
					}

				}

				fieldNum += bt[++i];
				fieldNum += bt[++i];
				// 打印字段
				if (fieldNum == 0) {

					System.out.println(" - - - 无字段 - - -");

				} else {

					// 每个字段 前2个字节为 flag 之后2个字节为 name 之后2个字节为描述
					// 还有2个字节描述其他属性的个数
					System.out.println("字段数为： " + fieldNum);
					for (int noF = 0; noF < fieldNum; noF++) {

						i += 2;
						System.out.print("字段名字为： "
								+ constant[bt[++i] + bt[++i] - 1] + " 字段描述为 : "
								+ constant[bt[++i] + bt[++i] - 1]);
						int numOfAttrOfFiled = (int) (bt[++i] + bt[++i]); // 属性的数量
						System.out.println(" 属性数量为 : " + numOfAttrOfFiled);
						// 每个属性占有8个字节
						for (int noAoF = 0; noAoF < numOfAttrOfFiled; noAoF++) {

							System.out.println("属性分别为： "
									+ constant[bt[++i] + bt[++i] - 1]
									+ constant[bt[++i] + bt[++i] - 1]
									+ constant[bt[++i] + bt[++i] - 1]
									+ constant[bt[++i] + bt[++i] - 1]);

						}

					}

				}

				methodNum += bt[++i];
				methodNum += bt[++i];
				if (methodNum == 0) {
					System.out.println(" 没有方法 ");
				} else {
					System.out.println("方法数共：" + methodNum);
					// 每个方法 前2个字节为 flag 之后2个字节为 name 之后2个字节为描述
					// 还有2个字节描述其他属性的个数
					for (int noM = 0; noM < methodNum; noM++) {

						i += 2;
						System.out.print("方法名字： "
								+ constant[bt[++i] + bt[++i] - 1] + " 方法描述为 : "
								+ constant[bt[++i] + bt[++i] - 1]);
						int numOfAttrOfMethod = (int) (bt[++i] + bt[++i]);
						System.out.println(" 属性共 : " + numOfAttrOfMethod);
						for (int noAOM = 0; noAOM < numOfAttrOfMethod; noAOM++) {
							i += 2;
							int attributr_length = (int) (bt[++i] + bt[++i]
									+ bt[++i] + bt[++i]);
							i += attributr_length;
						}
					}
				}
			}
		}
		line = 0;
		for (byte d : bt) {

			if (line % 16 == 0)
				buf.append(String.format("%05x: ", line));
			buf.append(String.format("%02x  ", d));
			line++;
			if (line % 16 == 0)
				buf.append("\n");
		}
		buf.append("\n");
		return buf.toString();

	}

	public static byte[] readFile(String file) throws IOException {

		InputStream is = new FileInputStream(file);
		int length = is.available();
		byte bt[] = new byte[length];
		is.read(bt);
		return bt;

	}

	public static void main(String[] agrs) throws IOException {
		// G:/work/项目东龙/test/adsend_platform/src/main/webapp/WEB-INF/classes/cn/adsend/platform/service/impl/MarkettingServiceImpl.class
		String path = "G:/work/项目东龙/test/adsend_platform/src/main/webapp/WEB-INF/classes/cn/adsend/platform/model/Account.class";
		// G:/api/code/MyBatis-generator/bin/org/mybatis/generator/api/PluginAdapter.class
		// String path =
		// "G:/myeclipse/com.wyd/jvm/target/classes/com/wyd/jvm_new/lesson10/Test.class";
		byte[] bt = ClassReader.readFile(path);
		String hexData = ClassReader.format(bt);
		System.out.println(hexData);

	}

}