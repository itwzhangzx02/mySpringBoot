package com.itwzhangzx.boot.utils;

import com.itwzhangzx.boot.constant.RequestMethod;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * https://way.jd.com/he/freeweather?city=beijing&
 * appkey=需要在京东万象申请
 *
 * **/
public class HttpUtil {

	public static  String  getMessageByPost(String urlStr ,HashMap<String,String> params) throws Exception {
		HttpURLConnection con =null;
		OutputStream outStrm = null;
		InputStream in = null;
		try{
			URL url =new URL(urlStr);
			//建立连接
			con = (HttpURLConnection) url.openConnection();
			//连接方式
			con.setRequestMethod(RequestMethod.POST.toString());
			//不使用缓存
			con.setUseCaches(false);
			//POST方式，参数需要放在http请求中
			con.setDoOutput(true);
			//拼接参数
			if (params!=null && params.size()>0){
				StringBuffer bf = new StringBuffer();
				for (Map.Entry<String,String> entry : params.entrySet()) {
					bf
							.append("&")
							.append(entry.getKey())
							.append("=")
							.append(entry.getValue());
				}
				//将第1处的“&”去掉
				outStrm = con.getOutputStream();
				outStrm.write(bf.toString().substring(1).getBytes("UTF-8"));
			}
			con.connect();
			//获取网站返回
			in = con.getInputStream();
			StringBuilder out = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, Charset.forName("UTF-8"));
			char[] buffer = new char[4096];
			int bytesRead;
			while((bytesRead=reader.read(buffer))!=-1){
				out.append(buffer,0,bytesRead);
			}
			return out.toString();
		}finally {
			if(outStrm!=null) outStrm.close();//close的时候，会先flush
			if(in!=null) in.close();
			if(con!=null) con.disconnect();
		}
	}

}
