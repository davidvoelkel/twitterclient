package twitterclient;



import static org.assertj.core.api.Assertions.assertThat;

import java.io.PrintStream;

import org.junit.Test;
import org.mockito.Mockito;

public class DisplayFollowersFeature {
	
	@Test
	public void displayFollowers() throws Exception {
		
		String twitterHandle = "emergentdesigns";
		
		String follower = new TwitterClient(new TwitterRestApiClient()).displayFollowers(twitterHandle);
		
		assertThat(follower).isEqualTo("@rhosts, @davidvoelkel");
	}
}
