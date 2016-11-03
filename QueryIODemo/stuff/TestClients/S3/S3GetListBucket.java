package S3;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus; //from authentication
	
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class S3GetListBucket {
//GET SERVICE	
	
	
	/*
 	 * This program fetches list of all buckets
	 * @param serverURL: URL of S3 Compatible REST server(http://<S3 server IP> : <S3 server port> /queryio/). For example: http://192.168.0.1:6678/queryio/
	 * @param token: authorization token.
	 */
	public static void getService(String serverURL, String token) throws Exception {
		URL url = null;
		HttpURLConnection httpCon = null;
		InputStream is = null;
		try {
			/* append "/" at end of serverURL */
			if (!serverURL.endsWith("/")) {
				serverURL = serverURL + "/";
			}	
			url = new URL(serverURL);	//URL object with serverURL

			//Returns a URLConnection object that represents a connection to the remote object referred to by the URL.
			httpCon = (HttpURLConnection) url.openConnection();

			httpCon.setDoOutput(true);	// to use the URL connection for output
			httpCon.setRequestMethod("GET");	//GET request is used.

			httpCon.setRequestProperty("authorization", token);	//Provides token for authorization

			httpCon.connect();	//Opens a communications link to the resource reference by the URL

			if (httpCon.getResponseCode() == HttpStatus.SC_OK) {	//Check for OK response code
				is = httpCon.getInputStream();
				// Process response here
				StringWriter writer = new StringWriter();
				IOUtils.copy(is, writer, "UTF-8");
				System.out.println(writer.toString());
			}
		} finally {
			try {
				if (is != null)
					is.close();	//close InputStream
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (httpCon != null) {
				httpCon.disconnect();	//disconnect connection	
			}
		}
	}

	
	
	
	public static String login(String serverURL, String username,
			String password) throws Exception {
		URL url = null;
		HttpURLConnection httpCon = null;
		String token = null;
		try {
			/* appending "/" at the end of serverURL */
			if (!serverURL.endsWith("/")) {
				serverURL = serverURL + "/";
			}
			url = new URL(serverURL); //create a new URL object

			//Returns a URLConnection object that represents a connection to the remote object referred to by the URL.
			httpCon = (HttpURLConnection) url.openConnection();			
			
			httpCon.setDoOutput(true);	// to use the URL connection for output
			httpCon.setRequestMethod("GET");	//GET request to be used

			httpCon.addRequestProperty("username", username);	//set username property of HttpURLConnection
			httpCon.addRequestProperty("password", password);	//set password property of HttpURLConnection

			httpCon.connect();	//Opens a communications link to the resource reference by the URL

			if (httpCon.getResponseCode() == HttpStatus.SC_OK) {
				token = httpCon.getHeaderField("authorization");	//get authorization token
				// Use this token in subsequent requests for the current
				// session.
			}
		} finally {	//close connection
			if (httpCon != null) {
				httpCon.disconnect();
			}
		}

		return token;
	}
	
	public static void main(String argv[])
	{
		try {
			String token;
			token= login("http://192.168.0.1:6678/queryio","admin","admin");
			System.out.print("Reply Token: "+token);
			getService("http://192.168.0.1:6678/queryio", token);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



