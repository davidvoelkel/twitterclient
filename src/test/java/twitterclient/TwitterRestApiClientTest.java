package twitterclient;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwitterRestApiClientTest {
	private TwitterRestApiClient twitterRestApiClient;

	@Test
	public void fetchFollowers() throws Exception {
		List<String> followers = twitterRestApiClient.fetchFollowers("emergentdesigns");
		assertThat(followers).containsExactly("rhosts", "davidvoelkel");
	}

	@Before
	public void createClient() {
		twitterRestApiClient = new TwitterRestApiClient();
	}
	
	@Test
	public void fetchFollowersInJson() throws Exception {
		String twitter = "emergentdesigns";

		String json = twitterRestApiClient.fetchFollowersInJson(twitter);

		assertThat(json).contains("rhosts", "davidvoelkel");
	}

	@Test
	public void parseFollowersFromJson() throws Exception {
		String json = "{\"users\":[{\"id\":90007895,\"id_str\":\"90007895\",\"name\":\"Robert\",\"screen_name\":\"rhosts\",\"location\":\"Munich\",\"description\":\"Software Craftsman, Continuous Delivery, Agile Methods, Dad, Hacker,  Coffee adicted. #docker #iojs\",\"url\":null,\"entities\":{\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":384,\"friends_count\":1329,\"listed_count\":25,\"created_at\":\"Sat Nov 14 19:53:20 +0000 2009\",\"favourites_count\":972,\"utc_offset\":3600,\"time_zone\":\"Berlin\",\"geo_enabled\":false,\"verified\":false,\"statuses_count\":427,\"lang\":\"en\",\"status\":{\"created_at\":\"Tue Jan 12 07:56:25 +0000 2016\",\"id\":686819004573417473,\"id_str\":\"686819004573417473\",\"text\":\"RT @codecentric: Beim @softwerkskammer Meetup M\\u00fcnchen spricht am Donnerstag der Kollege @davidvoelkel \\u00fcber #CQRS &amp; Eventsourcing https:\\/\\/t.\\u2026\",\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\/download\\/android\\\" rel=\\\"nofollow\\\"\\u003eTwitter for Android\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweeted_status\":{\"created_at\":\"Tue Jan 12 07:27:04 +0000 2016\",\"id\":686811615765790720,\"id_str\":\"686811615765790720\",\"text\":\"Beim @softwerkskammer Meetup M\\u00fcnchen spricht am Donnerstag der Kollege @davidvoelkel \\u00fcber #CQRS &amp; Eventsourcing https:\\/\\/t.co\\/DlPvqVJKp9\",\"source\":\"\\u003ca href=\\\"https:\\/\\/about.twitter.com\\/products\\/tweetdeck\\\" rel=\\\"nofollow\\\"\\u003eTweetDeck\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweet_count\":3,\"favorite_count\":0,\"entities\":{\"hashtags\":[{\"text\":\"CQRS\",\"indices\":[90,95]}],\"symbols\":[],\"user_mentions\":[{\"screen_name\":\"softwerkskammer\",\"name\":\"Softwerkskammer\",\"id\":373799064,\"id_str\":\"373799064\",\"indices\":[5,21]},{\"screen_name\":\"davidvoelkel\",\"name\":\"David V\\u00f6lkel\",\"id\":434292898,\"id_str\":\"434292898\",\"indices\":[71,84]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/DlPvqVJKp9\",\"expanded_url\":\"https:\\/\\/www.codecentric.de\\/wissen\\/community\\/detail\\/?community=32858#community-detail\",\"display_url\":\"codecentric.de\\/wissen\\/communi\\u2026\",\"indices\":[116,139]}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"de\"},\"retweet_count\":3,\"favorite_count\":0,\"entities\":{\"hashtags\":[{\"text\":\"CQRS\",\"indices\":[107,112]}],\"symbols\":[],\"user_mentions\":[{\"screen_name\":\"codecentric\",\"name\":\"codecentric AG\",\"id\":16497594,\"id_str\":\"16497594\",\"indices\":[3,15]},{\"screen_name\":\"softwerkskammer\",\"name\":\"Softwerkskammer\",\"id\":373799064,\"id_str\":\"373799064\",\"indices\":[22,38]},{\"screen_name\":\"davidvoelkel\",\"name\":\"David V\\u00f6lkel\",\"id\":434292898,\"id_str\":\"434292898\",\"indices\":[88,101]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/DlPvqVJKp9\",\"expanded_url\":\"https:\\/\\/www.codecentric.de\\/wissen\\/community\\/detail\\/?community=32858#community-detail\",\"display_url\":\"codecentric.de\\/wissen\\/communi\\u2026\",\"indices\":[143,144]}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"de\"},\"contributors_enabled\":false,\"is_translator\":false,\"is_translation_enabled\":false,\"profile_background_color\":\"131516\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme14\\/bg.gif\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme14\\/bg.gif\",\"profile_background_tile\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/613305461991940096\\/crP1gIiQ_normal.png\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/613305461991940096\\/crP1gIiQ_normal.png\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/90007895\\/1435058612\",\"profile_link_color\":\"009999\",\"profile_sidebar_border_color\":\"EEEEEE\",\"profile_sidebar_fill_color\":\"EFEFEF\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"has_extended_profile\":false,\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null,\"muting\":null,\"blocking\":null,\"blocked_by\":null},{\"id\":434292898,\"id_str\":\"434292898\",\"name\":\"David V\\u00f6lkel\",\"screen_name\":\"davidvoelkel\",\"location\":\"Munich\",\"description\":\"software craftsman @softwerkskammer munich, TDD, DDD, software design, DevOp, @codecentric\",\"url\":\"http:\\/\\/t.co\\/7ngrzOjz8p\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"http:\\/\\/t.co\\/7ngrzOjz8p\",\"expanded_url\":\"http:\\/\\/www.davidvoelkel.de\",\"display_url\":\"davidvoelkel.de\",\"indices\":[0,22]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":358,\"friends_count\":519,\"listed_count\":19,\"created_at\":\"Sun Dec 11 17:37:20 +0000 2011\",\"favourites_count\":97,\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"verified\":false,\"statuses_count\":860,\"lang\":\"de\",\"status\":{\"created_at\":\"Tue Jan 19 14:39:03 +0000 2016\",\"id\":689457045372690433,\"id_str\":\"689457045372690433\",\"text\":\"Emergent Microservices https:\\/\\/t.co\\/ZoPVenIHtx by @mashooq @codurance\",\"source\":\"\\u003ca href=\\\"http:\\/\\/www.tweetcaster.com\\\" rel=\\\"nofollow\\\"\\u003eTweetCaster for Android\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweet_count\":1,\"favorite_count\":2,\"entities\":{\"hashtags\":[],\"symbols\":[],\"user_mentions\":[{\"screen_name\":\"mashooq\",\"name\":\"Mashooq Badar\",\"id\":55192873,\"id_str\":\"55192873\",\"indices\":[50,58]},{\"screen_name\":\"codurance\",\"name\":\"codurance\",\"id\":1921539895,\"id_str\":\"1921539895\",\"indices\":[59,69]}],\"urls\":[{\"url\":\"https:\\/\\/t.co\\/ZoPVenIHtx\",\"expanded_url\":\"https:\\/\\/shar.es\\/1hobCX\",\"display_url\":\"shar.es\\/1hobCX\",\"indices\":[23,46]}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"lang\":\"en\"},\"contributors_enabled\":false,\"is_translator\":false,\"is_translation_enabled\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/619511527238807552\\/mslsMwUH_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/619511527238807552\\/mslsMwUH_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/434292898\\/1436539537\",\"profile_link_color\":\"0084B4\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"has_extended_profile\":false,\"default_profile\":true,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null,\"muting\":null,\"blocking\":null,\"blocked_by\":null}],\"next_cursor\":0,\"next_cursor_str\":\"0\",\"previous_cursor\":0,\"previous_cursor_str\":\"0\"}";
		
		List<String> followers = twitterRestApiClient.parseFollowersFromJson(json);

		assertThat(followers).containsExactly("rhosts", "davidvoelkel");
	}
}
