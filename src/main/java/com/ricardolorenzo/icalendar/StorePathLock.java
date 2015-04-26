package com.ricardolorenzo.icalendar;


public interface StorePathLock
{

	void lock() throws StorePathLockException;

	void unlock();

}
