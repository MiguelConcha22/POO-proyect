package Asistente;

//NO SE OCUPA

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
//import twitter4j.auth.AccessToken;
//import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {
	private final static String CONSUMER_KEY = "FjDMN5B53ocqiDzR5T6VUIGns";
	private final static String CONSUMER_KEY_SECRET = "UDRLKXtMM31PVdFE1fVjzIWmpIcAkoXRBGxr8YMLWAs1vrQSBk";
	private final static String ACCESS_TOKEN = "1008623227739009024-V9O10Mngick81jgGy5tErHPOh75wk1";
	private final static String ACCESS_TOKEN_SECRET = "a3OorxPyYH04N3jsmWPl7TDwcWc1ThmVbmJBH8J4pbeU5";

	private final static String USER_TO_READ = "sitiodelsuceso";

	public void start() throws TwitterException, IOException {

		// Twitter twitter = new TwitterFactory().getInstance();
		// twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(CONSUMER_KEY);
		builder.setOAuthConsumerSecret(CONSUMER_KEY_SECRET);
		builder.setOAuthAccessToken(ACCESS_TOKEN);
		builder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		Configuration configuration = builder.build();
		TwitterFactory factory = new TwitterFactory(configuration);
		Twitter twitter = factory.getInstance();

		// SE UTILIZA PARA OBTENER LOS ACCESS TOKENS A TRAVES DE UN PIN
		// *****************************************************************************************

		/*RequestToken requestToken = twitter.getOAuthRequestToken();
		System.out.println("Authorization URL: \n" + requestToken.getAuthorizationURL());

		AccessToken accessToken = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (null == accessToken) {
			try {
				System.out.print("Input PIN here: ");
				String pin = br.readLine();

				accessToken = twitter.getOAuthAccessToken(requestToken, pin);

			} catch (TwitterException te) {

				System.out.println("Failed to get access token, caused by: " + te.getMessage());

				System.out.println("Retry input PIN");

			}
		}

		System.out.println("Access Token: " + accessToken.getToken());
		System.out.println("Access Token Secret: " + accessToken.getTokenSecret());
		*/
		// ******************************************************************************************

		// PUBLICA EN MI TWITTER
		twitter.updateStatus("test1");
		twitter.updateStatus("test2");

		System.out.println("\nReading Twitter Timeline:");

		try {
			// I'm reading your timeline
			ResponseList<Status> estados = twitter.getUserTimeline(USER_TO_READ);
			for (Status each : estados) {

				System.out.println("Sent by: @" + each.getUser().getScreenName() + " - " + each.getUser().getName()
						+ "\n" + each.getText() + "\n");
			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
			System.exit(-1);
		}

	}

	public static void main(String[] args) throws Exception {
		new TwitterTest().start();// run the Twitter client
	}
}