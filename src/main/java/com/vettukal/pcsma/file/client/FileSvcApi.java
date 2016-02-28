package com.vettukal.pcsma.file.client;

import java.util.Collection;

import com.vettukal.pcsma.file.repository.File;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * This interface defines an API for a VideoSvc. The
 * interface is used to provide a contract for client/server
 * interactions. The interface is annotated with Retrofit
 * annotations so that clients can automatically convert the
 * 
 * 
 * @author jules
 *
 */
public interface FileSvcApi {
	
	public static final String TITLE_PARAMETER = "title";

	// The path where we expect the VideoSvc to live
	public static final String FILE_SVC_PATH = "/file";

	// The path to search videos by title
	public static final String VIDEO_TITLE_SEARCH_PATH = FILE_SVC_PATH + "/find";

	@GET(FILE_SVC_PATH)
	public Collection<File> getVideoList();
	
	@POST(FILE_SVC_PATH)
	public boolean addVideo(@Body File v);
	
	@GET(VIDEO_TITLE_SEARCH_PATH)
	public Collection<File> findByTitle(@Query(TITLE_PARAMETER) String title);
	
}
