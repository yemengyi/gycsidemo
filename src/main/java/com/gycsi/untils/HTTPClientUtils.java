package com.gycsi.untils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTTPClient 工具类
 * 
 * @author Lynch 2014-09-15
 *
 */
public class HTTPClientUtils {

	private static final JsonNodeFactory factory = new JsonNodeFactory(false);

	/**
	 * Send SSL Request
	 * 
	 * @return
	 */
	public static ObjectNode sendHTTPRequest(String urlString, Object dataBody, RequestMethod method) {

		HttpClient httpClient = getClient(true);

		ObjectNode resObjectNode = factory.objectNode();

		try {

			HttpResponse response = null;
			URL url = new URL(urlString);

			if (method.equals(RequestMethod.POST)) {
				HttpPost httpPost = new HttpPost(url.toURI());

				httpPost.setEntity(new StringEntity(dataBody.toString(), "UTF-8"));

				response = httpClient.execute(httpPost);
			} else if (method.equals("PUT")) {
				HttpPut httpPut = new HttpPut(url.toURI());

				httpPut.setEntity(new StringEntity(dataBody.toString(), "UTF-8"));

				response = httpClient.execute(httpPut);
			} else if (method.equals(RequestMethod.GET)) {
				HttpGet httpGet = new HttpGet(url.toURI());

				response = httpClient.execute(httpGet);
			} else if (method.equals("DELETE")) {
				HttpDelete httpDelete = new HttpDelete(url.toURI());

				response = httpClient.execute(httpDelete);
			}

			HttpEntity entity = response.getEntity();
			if (null != entity) {
				String responseContent = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);

				ObjectMapper mapper = new ObjectMapper();
				JsonFactory factory = mapper.getJsonFactory();
				JsonParser jp = factory.createJsonParser(responseContent);

				resObjectNode = mapper.readTree(jp);
				resObjectNode.put("statusCode", response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

		return resObjectNode;
	}

	/**
	 * DownLoadFile
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws IOException
	 */
	public static File downLoadFile(URL url, File localPath) {

		HttpClient httpClient = getClient(true);

		try {

			HttpGet httpGet = new HttpGet(url.toURI());

            HttpResponse response = httpClient.execute(httpGet);

			HttpEntity entity = response.getEntity();
			InputStream in = entity.getContent();
			FileOutputStream fos = new FileOutputStream(localPath);

			byte[] buffer = new byte[1024];
			int len1 = 0;
			while ((len1 = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len1);
			}

			fos.close();

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

		return localPath;
	}

	/**
	 * 上传文件
	 *
	 * @throws ParseException
	 * @throws IOException
	 */
	public static ObjectNode uploadFile(String url, String path) throws ParseException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		ObjectNode resObjectNode = factory.objectNode();

		try {
			String filePath = new String(path);
			HttpPost httpPost = getMultipartPost(url);

			File file = new File(filePath);
//			FileBody bin = new FileBody(file);

			MultipartEntityBuilder mBuilder = get_COMPATIBLE_Builder("UTF-8");
			mBuilder.addBinaryBody("media", file, ContentType.APPLICATION_OCTET_STREAM, file.getName());
			HttpEntity reqEntity = mBuilder.build();

			httpPost.setEntity(reqEntity);

			System.out.println("发起请求的页面地址 " + httpPost.getRequestLine());
			// 发起请求 并返回请求的响应
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					String responseContent = EntityUtils.toString(entity, "UTF-8");
					EntityUtils.consume(entity);

					ObjectMapper mapper = new ObjectMapper();
					JsonFactory factory = mapper.getJsonFactory();
					JsonParser jp = factory.createJsonParser(responseContent);

					resObjectNode = mapper.readTree(jp);
					resObjectNode.put("statusCode", response.getStatusLine().getStatusCode());
				}
			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}

		return resObjectNode;
	}

	private static String getBoundaryStr(String str) {
		return "------------" + str;
	}

	private static MultipartEntityBuilder get_COMPATIBLE_Builder(String charSet) {
		MultipartEntityBuilder result = MultipartEntityBuilder.create();
		result.setBoundary(getBoundaryStr("7da2e536604c8"))
				.setCharset(Charset.forName(charSet))
				.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		return result;
	}

	private static HttpPost getMultipartPost(String url) {
		HttpPost post = new HttpPost(url);
		post.addHeader("Connection", "keep-alive");
		post.addHeader("Accept", "*/*");
		post.addHeader("Content-Type", "multipart/form-data;boundary="
				+ getBoundaryStr("7da2e536604c8"));
		post.addHeader("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		return post;
	}

	/**
	 * Create a httpClient instance
	 * 
	 * @param isSSL
	 * @return HttpClient instance
	 */
	public static HttpClient getClient(boolean isSSL) {

		HttpClient httpClient = new DefaultHttpClient();
		if (isSSL) {
			X509TrustManager xtm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};

			try {
				SSLContext ctx = SSLContext.getInstance("TLS");

				ctx.init(null, new TrustManager[] { xtm }, null);

				SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);

				httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));

			} catch (Exception e) {
				throw new RuntimeException();
			}
		}

		return httpClient;
	}

	/**
	 * Check illegal String
	 * 
	 * @param regex
	 * @param str
	 * @return
	 */
	public static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		return matcher.lookingAt();
	}
}
