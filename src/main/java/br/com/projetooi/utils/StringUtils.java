package br.com.projetooi.utils;

public class StringUtils {
	
	public static boolean isNotNullOrBlank(String str){
		if(str == null && "".equals(str)){
			return false;
		}
		return true;
	}

}
