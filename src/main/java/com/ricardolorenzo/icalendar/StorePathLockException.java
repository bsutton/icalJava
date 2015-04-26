package com.ricardolorenzo.icalendar;


/**
 * Used to throw exceptions which occur when attempting to lock a StorePath
 * @author bsutton
 *
 */
public class StorePathLockException extends Exception
{
	private static final long serialVersionUID = 1L;

	public StorePathLockException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
