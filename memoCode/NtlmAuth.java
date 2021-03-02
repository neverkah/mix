import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class NtlmAuth {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(
				"huangzj", "1234.com", "", "test"));

		HttpHost target = new HttpHost("192.168.112.133", 80, "http");

		// Make sure the same context is used to execute logically related
		// requests
		HttpClientContext context = HttpClientContext.create();
		context.setCredentialsProvider(credsProvider);

		// Execute a cheap method first. This will trigger NTLM authentication
		HttpGet httpget = new HttpGet("/");
		CloseableHttpResponse response1 = httpclient.execute(target, httpget,
				context);
		try {
			HttpEntity entity1 = response1.getEntity();
			System.out.println("--------------------------------------");
			System.out.println("Response content:\r\n "
					+ EntityUtils.toString(entity1, "UTF-8"));
			System.out.println("--------------------------------------");
		} finally {
			response1.close();
		}
		/*
		 * // Execute an expensive method next reusing the same context (and
		 * connection) HttpPost httppost = new HttpPost("/ntlm-protected/form");
		 * httppost.setEntity(new StringEntity("lots and lots of data"));
		 * CloseableHttpResponse response2 = httpclient.execute(target,
		 * httppost, context); try { HttpEntity entity2 = response2.getEntity();
		 * } finally { response2.close(); }
		 */
	}

}
