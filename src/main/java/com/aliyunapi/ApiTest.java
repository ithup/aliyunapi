package com.aliyunapi;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class ApiTest {

	public static void main(String[] args) {
		String host = "http://idcard.market.alicloudapi.com";
		String path = "/lianzhuo/idcard";
		String method = "GET";
		String appcode = "0bcc079bdb9a4f8aa68bf24ab8962b8f";
		Map<String, String> headers = new HashMap<String, String>();
		// �����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("cardno", "520221199505053016");
		querys.put("name", "�˻�Ҫ");

		try {
			/**
			 * ��Ҫ��ʾ����: HttpUtils���
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/
			 * src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java ����
			 *
			 * ��Ӧ�����������
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/
			 * pom.xml
			 */
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			System.out.println(response.toString());
			// ��ȡresponse��body
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
