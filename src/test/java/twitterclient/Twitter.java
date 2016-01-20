package twitterclient;

import java.util.List;

public interface Twitter {

	List<String> fetchFollowers(String twitterHandle);

}
