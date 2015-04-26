package com.ricardolorenzo.icalendar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import com.ricardolorenzo.file.lock.FileLockException;


/**
 * Provides an abstraction of calendar paths with in a CalDAVStore
 * 
 * @author bsutton
 *
 */
public interface StorePath
{
	boolean exists();

	StorePath getParentFile();

	Reader getReader() throws FileNotFoundException, IOException;

	/**
	 * Write's the calendar entity to the store.
	 * @param entity 
	 * @throws FileLockException 
	 * @throws IOException 
	 */
	void write(String entity) throws IOException, FileLockException;

	StorePathLock lock();

	String getAbsolutePath();

}
