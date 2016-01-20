package twitterclient;

import java.util.stream.Collectors;

public class TwitterClient {

	private Twitter twitter;

	public TwitterClient(Twitter twitter) {
		this.twitter = twitter;
	}

	public String displayFollowers(String twitterHandle) {
		return twitter.fetchFollowers(twitterHandle).stream()
				.map(follower -> "@" + follower)
				.collect(Collectors.joining(", "));
	}

}
