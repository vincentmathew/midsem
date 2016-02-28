package com.vettukal.pcsma.file.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * An interface for a repository that can store Video
 * objects and allow them to be searched by title.
 * 
 * @author jules
 *
 */
@Repository
public interface FileRepository extends CrudRepository<File, Long>{

	// Find all videos with a matching title (e.g., Video.name)
	public Collection<File> findByName(String title);
	
}
