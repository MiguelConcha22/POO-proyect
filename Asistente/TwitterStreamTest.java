package Asistente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamTest {
	private final static String CONSUMER_KEY = "FjDMN5B53ocqiDzR5T6VUIGns";
	private final static String CONSUMER_KEY_SECRET = "UDRLKXtMM31PVdFE1fVjzIWmpIcAkoXRBGxr8YMLWAs1vrQSBk";
	private final static String ACCESS_TOKEN = "1008623227739009024-V9O10Mngick81jgGy5tErHPOh75wk1";
	private final static String ACCESS_TOKEN_SECRET = "a3OorxPyYH04N3jsmWPl7TDwcWc1ThmVbmJBH8J4pbeU5";

	private final static String USER_TO_READ = "Miguel71290502";
	
	boolean ocupado = false;
	Marco marco;
	
	List <Noticia> noticias;

	public void start(Marco marco) throws TwitterException, IOException {
		this.marco = marco;
		
		this.noticias = new ArrayList<>();

		// Twitter twitter = new TwitterFactory().getInstance();
		// twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(CONSUMER_KEY);
		builder.setOAuthConsumerSecret(CONSUMER_KEY_SECRET);
		builder.setOAuthAccessToken(ACCESS_TOKEN);
		builder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		Configuration configuration = builder.build();
		
		TwitterStreamFactory stream = new TwitterStreamFactory(configuration);
		TwitterStream twitterStream = stream.getInstance();
		
		TwitterFactory factory = new TwitterFactory(configuration);
		Twitter tw = factory.getInstance();

		StatusListener listener = new StatusListener() {
			@Override
			public void onStatus(Status status) {
				//System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
				generaNoticia("@" + status.getUser().getScreenName() + " - " + status.getText());
			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
			}

			@Override
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
			}

			@Override
			public void onScrubGeo(long userId, long upToStatusId) {
				System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
			}

			@Override
			public void onStallWarning(StallWarning warning) {
				System.out.println("Got stall warning:" + warning);
			}

			@Override
			public void onException(Exception ex) {
				ex.printStackTrace();
			}
		};
		User user = tw.showUser(USER_TO_READ);
		long[] users = new long[]{user.getId()};
        twitterStream.addListener(listener);
        FilterQuery filtre = new FilterQuery();
        filtre.follow(users);
        twitterStream.filter(filtre);

	}
	
	public void generaNoticia(String twit) {
		if(this.ocupado) {
			this.noticias.add(new Noticia(twit));
		}else {
			Noticia noticiaEntrante = new Noticia(twit);
			noticiaEntrante.mostrar(this.ocupado, marco);
			//ELIMINAR
		}
	}

	//public static void main(String[] args) throws Exception {
		//new TwitterStreamTest().start();// run the Twitter client
	//}
}