package com.wis.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static String getSuccessfulResult = new String();

	public static Class<?> getType(String paramString) {
		Object localObject = null;

		if (paramString.equals("int")) {
			localObject = Integer.class;
		} else if (paramString.equals("String")) {
			localObject = String.class;
		} else if (paramString.equals("long")) {
			localObject = Long.class;
		} else if (paramString.equals("boolean")) {
			localObject = Boolean.class;
		} else if (paramString.equals("double"))
			localObject = Double.class;
		else if (paramString.equals("float"))
			localObject = Float.class;
		else {
			localObject = getTypes(paramString);
		}
		return ((Class<?>) localObject);
	}

	public static Class<?> getTypes(String paramString) {
		Object localObject = null;
		if (paramString.equals("byte"))
			localObject = String.class;
		else if (paramString.equals("short"))
			localObject = Short.TYPE;
		else if (paramString.equals("array"))
			localObject = JsonArray.class;
		else if (paramString.equals("xml"))
			localObject = String.class;
		else if (paramString.equals("json"))
			localObject = String.class;
		else if (paramString.equals("obj")) {
			localObject = JsonObject.class;
		}
		return ((Class<?>) localObject);
	}

	/**
	 * 读取配置文件 中数据
	 * @param paramString1
	 * @param paramString2
	 * @return
	 */
	public static String readConfigFile(String paramString1, String paramString2) {
		Properties localProperties = new Properties();
		try {
			InputStream localInputStream = StringUtils.class.getResourceAsStream(paramString1);
			BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
			localProperties.load(localBufferedReader);
			String str = localProperties.getProperty(paramString2);
			return str.trim();
		} catch (FileNotFoundException localFileNotFoundException) {
			System.out.println(new StringBuilder().append("无法找到文件:").append(paramString1).toString());
			return null;
		} catch (IOException localIOException) {
			System.out.println(new StringBuilder().append("读文件出错:").append(paramString1).append("---")
					.append(localIOException.getMessage()).toString());
		}
		return null;
	}

	/**
	 * 将字符串第一个字母大写
	 * @param paramString
	 * @return
	 */
	public static String firstToUpperCase(String paramString) {
		return new StringBuilder().append(paramString.substring(0, 1).toUpperCase(Locale.CHINA))
				.append(paramString.substring(1)).toString();
	}

	/**
	 * 将字符串第一个字母小写
	 * @param paramString
	 * @return
	 */
	public static String firstToLowerCase(String paramString) {
		return new StringBuilder().append(paramString.substring(0, 1).toLowerCase(Locale.CHINA))
				.append(paramString.substring(1)).toString();
	}

	public static String[] getObjectProperties(Object paramObject) {
		Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
		String[] arrayOfString = new String[arrayOfField.length];
		for (int i = 0; i < arrayOfField.length; ++i) {
			arrayOfString[i] = arrayOfField[i].getName();
		}
		return arrayOfString;
	}

	public static String parameterAssignment(Object paramObject, String paramString) {
		String[] arrayOfString1 = getObjectProperties(paramObject);
		for (String str : arrayOfString1) {
			StringBuilder localStringBuilder = new StringBuilder();
			localStringBuilder.append("{").append(str).append("}");
			if (paramString.indexOf("{") == -1)
				continue;
			try {
				paramString = paramString.replace(localStringBuilder, getAttributeValue(str, paramObject));
			} catch (Exception localException) {
				localException.printStackTrace();
			}
		}

		return paramString;
	}

	public static List<String> getUrlParam(String paramString) {
		ArrayList localArrayList = new ArrayList();
		String str = null;
		Pattern localPattern = Pattern.compile("\\{.*?\\}");
		Matcher localMatcher = localPattern.matcher(paramString);
		while (localMatcher.find()) {
			str = firstToUpperCase(localMatcher.group().replaceAll("\\{", "").replaceAll("\\}", ""));
			localArrayList.add(str);
		}
		return localArrayList;
	}

	public static String getAttributeValue(String paramString, Object paramObject) throws Exception {
		paramString = new StringBuilder().append(paramString.substring(0, 1).toUpperCase(Locale.CHINA))
				.append(paramString.substring(1)).toString();

		String str = null;
		Object localObject = null;
		try {
			Class localClass = paramObject.getClass();
			Field[] arrayOfField1 = paramObject.getClass().getDeclaredFields();
			for (Field localField : arrayOfField1) {
				PropertyDescriptor localPropertyDescriptor = new PropertyDescriptor(localField.getName(), localClass);

				Method localMethod = localPropertyDescriptor.getReadMethod();
				if (localMethod.getName().indexOf(paramString) != -1) {
					localObject = localMethod.invoke(paramObject, new Object[0]);
					if (localObject != null)
						str = localObject.toString();
				}
			}
		} catch (Exception localException) {
			throw localException;
		}
		return str;
	}

	public static String checkType(String paramString) {
		JsonParser localJsonParser = new JsonParser();
		JsonElement localJsonElement = localJsonParser.parse(paramString);
		if ((!(localJsonElement.isJsonArray())) && (!(localJsonElement.isJsonObject()))) {
			paramString = new StringBuilder().append("{\"result\": \"").append(paramString).append("\"}").toString();
		}
		return paramString.trim();
	}

//	public static String getSuccessfulResult(String paramString, Object paramObject) {
//		getSuccessfulResult = null;
//		JsonParser localJsonParser = new JsonParser();
//		JsonElement localJsonElement = localJsonParser.parse(paramString);
//		JsonObject localJsonObject = null;
//		if (localJsonElement.isJsonObject()) {
//			localJsonObject = localJsonElement.getAsJsonObject();
//		} else if (localJsonElement.isJsonArray()) {
//			JsonArray localJsonArray = localJsonElement.getAsJsonArray();
//			if (localJsonArray.size() > 0) {
//				localJsonObject = localJsonArray.get(0).getAsJsonObject();
//			}
//		}
//		return getResult(localJsonObject, paramObject);
//	}

//	public static String getResult(JsonObject paramJsonObject, Object paramObject) {
//		for (Map.Entry localEntry : paramJsonObject.entrySet()) {
//			if (getSuccessfulResult != null) {
//				break;
//			}
//			String str = (String) localEntry.getKey();
//			JsonElement localJsonElement = (JsonElement) localEntry.getValue();
//
//			Class localClass = getJsonType(localJsonElement);
//			if (localClass == null) {
//				getResult(localJsonElement.getAsJsonObject(), paramObject);
//			} else {
//				Object localObject1;
//				Object localObject2;
//				if (localClass.equals(JsonArray.class)) {
//					for (localObject1 = localJsonElement.getAsJsonArray().iterator(); ((Iterator) localObject1)
//							.hasNext();) {
//						localObject2 = (JsonElement) ((Iterator) localObject1).next();
//						getResult(((JsonElement) localObject2).getAsJsonObject(), paramObject);
//					}
//				} else {
//					localObject1 = (Object)getObjectProperties(paramObject);
//					for (Object localObject3 : localObject1) {
//						if (!(str.equals(localObject3)))
//							continue;
//						getSuccessfulResult = localJsonElement.toString().replace("\"", "");
//					}
//				}
//			}
//		}
//
//		return ((String) (String) getSuccessfulResult);
//	}

	public static Class<?> getJsonType(JsonElement paramJsonElement) {
		Object localObject = null;

		if (paramJsonElement.isJsonNull()) {
			localObject = Object.class;
		} else if (paramJsonElement.isJsonPrimitive()) {
			localObject = getJsonPrimitiveType(paramJsonElement);
		} else if (paramJsonElement.isJsonObject()) {
			localObject = null;
		} else if (paramJsonElement.isJsonArray()) {
			localObject = JsonArray.class;
		}
		return ((Class<?>) localObject);
	}

	private static Class<?> getJsonPrimitiveType(JsonElement paramJsonElement) {
		Object localObject = Object.class;
		JsonPrimitive localJsonPrimitive = paramJsonElement.getAsJsonPrimitive();

		if (localJsonPrimitive.isNumber()) {
			String str = localJsonPrimitive.getAsString();
			if (str.contains("."))
				try {
					Float.parseFloat(str);
					localObject = Float.TYPE;
				} catch (NumberFormatException localNumberFormatException1) {
					localObject = Double.TYPE;
				}
			else
				try {
					Integer.parseInt(str);
					localObject = Integer.TYPE;
				} catch (NumberFormatException localNumberFormatException2) {
					localObject = Long.TYPE;
				}
		} else if (localJsonPrimitive.isBoolean()) {
			localObject = Boolean.TYPE;
		} else if (localJsonPrimitive.isString()) {
			localObject = String.class;
		}

		return ((Class<?>) localObject);
	}
}