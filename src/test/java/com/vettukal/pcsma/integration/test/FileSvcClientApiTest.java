package com.vettukal.pcsma.integration.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.vettukal.pcsma.file.client.FileSvcApi;
import com.vettukal.pcsma.file.repository.File;
import com.vettukal.pcsma.file.test.TestData;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

/**
 * 
 * This integration test sends a POST request to the VideoServlet to add a new video 
 * and then sends a second GET request to check that the video showed up in the list
 * of videos. Actual network communication using HTTP is performed with this test.
 * 
 * The test requires that the VideoSvc be running first (see the directions in
 * the README.md file for how to launch the Application).
 * 
 * To run this test, right-click on it in Eclipse and select
 * "Run As"->"JUnit Test"
 * 
 * Pay attention to how this test that actually uses HTTP and the test that just
 * directly makes method calls on a VideoSvc object are essentially identical.
 * All that changes is the setup of the videoService variable. Yes, this could
 * be refactored to eliminate code duplication...but the goal was to show how
 * much Retrofit simplifies interaction with our service!
 * 
 * @author jules
 *
 */
public class FileSvcClientApiTest {

	private final String TEST_URL = "http://localhost:8080";

	private FileSvcApi videoService = new RestAdapter.Builder()
			.setEndpoint(TEST_URL).setLogLevel(LogLevel.FULL).build()
			.create(FileSvcApi.class);

	private File video = TestData.randomVideo();
	
	/**
	 * This test creates a Video, adds the Video to the VideoSvc, and then
	 * checks that the Video is included in the list when getVideoList() is
	 * called.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testVideoAddAndList() throws Exception {
		
		// Add the video
		boolean ok = videoService.addVideo(video);
		assertTrue(ok);

		// We should get back the video that we added above
		Collection<File> videos = videoService.getVideoList();
		assertTrue(videos.contains(video));
	}

}
