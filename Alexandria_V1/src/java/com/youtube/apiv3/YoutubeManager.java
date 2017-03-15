/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtube.apiv3;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.youtube.YouTube;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
	 * MIME type.
	 */
	private static final String VIDEO_FILE_FORMAT = "video/*";
	/**
	 * Nombre de video.
	 */
	private static final String SAMPLE_VIDEO_FILENAME = "sample-video.mp4";

	public Credential authorize(InputStream secrets) throws IOException {
		List<String> scopes = new ArrayList();
		scopes.add("https://www.googleapis.com/auth/youtube.upload");
		// Load client secrets.
		Reader clientSecretReader = new InputStreamReader(secrets);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, clientSecretReader);
		// This creates the credentials datastore at ~/.oauth-credentials/${credentialDatastore}
		FileDataStoreFactory fileDataStoreFactory = new FileDataStoreFactory(new File(System.getProperty("user.home") + "/" + CREDENTIALS_DIRECTORY));
		DataStore<StoredCredential> datastore = fileDataStoreFactory.getDataStore("uploadvideo");
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, scopes).setCredentialDataStore(datastore).build();
		// Build the local server and bind it to port 8080
		System.out.println("localReceiver start");
		LocalServerReceiver localReceiver = new LocalServerReceiver.Builder().setPort(8090).build();
		System.out.println("localReceiver done");
		// Authorize.
		Credential credential = new AuthorizationCodeInstalledApp(flow, localReceiver).authorize("user");
		System.out.println("credential done");
		clientSecretReader.close();
		secrets.close();
		return credential;
	}
}
