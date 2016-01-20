package twitterclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class TwitterRestApiClient implements Twitter {

	@Override
	public List<String> fetchFollowers(String twitterHandle) {
		String json = fetchFollowersInJson(twitterHandle);
		return parseFollowersFromJson(json);
	}

	String fetchFollowersInJson(String twitter) {
		HttpGet request = new HttpGet(url(twitter));
		setAuthorization(request);
		try {
			CloseableHttpResponse response = client().execute(request);
			return toString(response.getEntity().getContent());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void setAuthorization(HttpGet request) {
		request.addHeader("Authorization",	  																							   
				"Bearer *********************** PLEASE INSERT YOUR TWITTER BEARER TOKEN AND DON'T CHECK IT IN ************************************************");
	}

	private String toString(InputStream inputStream) {
		Scanner s = new Scanner(inputStream).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	private CloseableHttpClient client() {
		return HttpClientBuilder.create().build();
	}

	private String url(String twitter) {
		return "https://api.twitter.com/1.1/followers/list.json?screen_name=" + twitter;
	}

	List<String> parseFollowersFromJson(String json) {
		JSONArray users = users(json);
		return screenNames(users);
	}

	private List<String> screenNames(JSONArray users) {
		List<String> followers = new ArrayList<>();
		IntStream.range(0, users.length())
			.forEach(i -> followers.add(users.getJSONObject(i).getString("screen_name")));
		return followers;
	}

	private JSONArray users(String json) {
		return new JSONObject(json).getJSONArray("users");
	}

}
