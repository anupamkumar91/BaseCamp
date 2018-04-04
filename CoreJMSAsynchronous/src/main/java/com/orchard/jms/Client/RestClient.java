package com.orchard.jms.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {

	public static void main(String[] args) throws InterruptedException {
		int n = 3;
		while (n > 0) {
			try {

				URL url = new URL("http://localhost:8080/CoreJMSAsynchronous/webapi/consumer");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "text/plain");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("failed http error code is: " + conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				System.out.println("output from the server: ");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					System.out.println();
				}

				conn.disconnect();

			} catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}
			n--;
			Thread.sleep(4000);

		}
	}
}