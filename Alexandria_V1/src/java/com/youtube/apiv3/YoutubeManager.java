/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtube.apiv3;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abril.gonzalez
 */
public class YoutubeManager {

	/**
	 * Objeto Youtube para hacer peticiones a la API.
	 */
	private static YouTube youtube;
	/**
	 * Instancia JSON factory.
	 */
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();
	/**
	 * Instancia HTTP transport.
	 */
	public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	/**
	 * Carpeta donde se guardarán tokens de autorización.
	 */
	private static final String CREDENTIALS_DIRECTORY = ".oauth-credentials";
	/**
	 * Callback URI.
	 */
	private static final String CALLBACK_URI = "http://localhost:8089/Alexandria_V1/oauth2callback";
	/**
	 * MIME type.
	 */
	private static final String VIDEO_FILE_FORMAT = "video/*";
	/**
	 * Nombre de video.
	 */
	private static final String SAMPLE_VIDEO_FILENAME = "sample-video.mp4";
	private static GoogleAuthorizationCodeFlow flow;
	private static String loginUrl = null;

	public static GoogleCredential getServiceCredential(InputStream key) throws IOException {
		List<String> scopes = new ArrayList();
		scopes.add("https://www.googleapis.com/auth/youtube.upload");
		return GoogleCredential.fromStream(key).createScoped(scopes);
	}

	private static void buildLoginUrl(InputStream secrets) throws IOException {
		List<String> scopes = new ArrayList();
		scopes.add("https://www.googleapis.com/auth/youtube.upload");
		// Load client secrets.
		Reader clientSecretReader = new InputStreamReader(secrets);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, clientSecretReader);
		// This creates the credentials datastore at ~/.oauth-credentials/${credentialDatastore}
		FileDataStoreFactory fileDataStoreFactory = new FileDataStoreFactory(new File(System.getProperty("user.home") + "/" + CREDENTIALS_DIRECTORY));
		DataStore<StoredCredential> datastore = fileDataStoreFactory.getDataStore("uploadvideo");
		flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, scopes).setCredentialDataStore(datastore).build();
		GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
		loginUrl = url.setRedirectUri(CALLBACK_URI).setAccessType("offline").build();
		clientSecretReader.close();
		secrets.close();
	}

	public static String getLoginUrl(InputStream secrets) throws IOException {
		if (loginUrl == null) {
			buildLoginUrl(secrets);
		}
		Logger.getLogger(YoutubeManager.class.getName()).log(Level.INFO, "Login URL: {0}", loginUrl);
		return loginUrl;
	}

	public static Credential authorize(String authCode) throws IOException {
		GoogleTokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(CALLBACK_URI).execute();
		Logger.getLogger(YoutubeManager.class.getName()).log(Level.INFO, "Token: {0}", response);
		Credential credential = flow.createAndStoreCredential(response, "user");
		Logger.getLogger(YoutubeManager.class.getName()).log(Level.INFO, "Credential: {0}", credential);
		System.out.println("Credential access token is " + credential.getAccessToken());
		System.out.println("Credential refresh token is " + credential.getRefreshToken());
		return credential;
	}

	public static void uploadVideo(Credential credential, InputStream is) throws IOException {
		// This object is used to make YouTube Data API requests.
		youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName("youtube-cmdline-uploadvideo-sample").build();
		System.out.println("Uploading: " + SAMPLE_VIDEO_FILENAME);
		// Add extra information to the video before uploading.
		Video videoObjectDefiningMetadata = new Video();
		// Set the video to be publicly visible. This is the default
		// setting. Other supporting settings are "unlisted" and "private."
		VideoStatus status = new VideoStatus();
		status.setPrivacyStatus("public");
		videoObjectDefiningMetadata.setStatus(status);
		// Most of the video's metadata is set on the VideoSnippet object.
		VideoSnippet snippet = new VideoSnippet();
		// This code uses a Calendar instance to create a unique name and
		// description for test purposes so that you can easily upload
		// multiple files. You should remove this code from your project
		// and use your own standard names instead.
		Calendar cal = Calendar.getInstance();
		snippet.setTitle("Test Upload via Java on " + cal.getTime());
		snippet.setDescription("Video uploaded via YouTube Data API V3 using the Java library " + "on " + cal.getTime());
		// Set the keyword tags that you want to associate with the video.
		List<String> tags = new ArrayList<>();
		tags.add("test");
		tags.add("example");
		tags.add("java");
		tags.add("YouTube Data API V3");
		tags.add("erase me");
		snippet.setTags(tags);
		// Add the completed snippet object to the video resource.
		videoObjectDefiningMetadata.setSnippet(snippet);
		InputStreamContent mediaContent = new InputStreamContent(VIDEO_FILE_FORMAT, is);
		// Insert the video. The command sends three arguments. The first
		// specifies which information the API request is setting and which
		// information the API response should return. The second argument
		// is the video resource that contains metadata about the new video.
		// The third argument is the actual video content.
		YouTube.Videos.Insert videoInsert = youtube.videos().insert("snippet,statistics,status", videoObjectDefiningMetadata, mediaContent);
		// Set the upload type and add an event listener.
		MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();
		// Indicate whether direct media upload is enabled. A value of
		// "True" indicates that direct media upload is enabled and that
		// the entire media content will be uploaded in a single request.
		// A value of "False," which is the default, indicates that the
		// request will use the resumable media upload protocol, which
		// supports the ability to resume an upload operation after a
		// network interruption or other transmission failure, saving
		// time and bandwidth in the event of network failures.
		uploader.setDirectUploadEnabled(false);
		MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
			@Override
			public void progressChanged(MediaHttpUploader uploader) throws IOException {
				switch (uploader.getUploadState()) {
					case INITIATION_STARTED:
						System.out.println("Initiation Started");
						break;
					case INITIATION_COMPLETE:
						System.out.println("Initiation Completed");
						break;
					case MEDIA_IN_PROGRESS:
						System.out.println("Upload in progress");
						System.out.println("Upload percentage: " + uploader.getProgress());
						break;
					case MEDIA_COMPLETE:
						System.out.println("Upload Completed!");
						break;
					case NOT_STARTED:
						System.out.println("Upload Not Started!");
						break;
				}
			}
		};
		uploader.setProgressListener(progressListener);
		// Call the API and upload the video.
		Video returnedVideo = videoInsert.execute();
		// Print data about the newly inserted video from the API response.
		System.out.println("\n================== Returned Video ==================\n");
		System.out.println("  - Id: " + returnedVideo.getId());
		System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
		System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
		System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
		System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());
	}
}
