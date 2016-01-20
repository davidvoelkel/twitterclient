package twitterclient;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TwitterClientTest {
	@Test
	public void displayFollowers() throws Exception {
		
		Twitter twitter = Mockito.mock(Twitter.class);
		Mockito.when(twitter.fetchFollowers("emergentdesigns"))
							.thenReturn(Arrays.asList("rhosts", "davidvoelkel"));
		
		String follower = new TwitterClient(twitter).displayFollowers("emergentdesigns");
		
		assertThat(follower).isEqualTo("@rhosts, @davidvoelkel");
	}
}
