package com.jacky.DSAndDM.ElementaryDataStructure;

public interface Queue {
	/**
	 * Insert a new item into the queue.
	 * 
	 * @param x
	 *            the item to insert.
	 */
	void enqueue(Object x);

	/**
	 * Get the least recently inserted item in the queue. Does not alter the
	 * queue.
	 * 
	 * @return the least recently inserted item in the queue.
	 * @exception UnderflowException
	 *                if the queue is empty.
	 */
	Object getFront();

	/**
	 * Return and remove the least recently inserted item from the queue.
	 * 
	 * @return the least recently inserted item in the queue.
	 * @exception UnderflowException
	 *                if the queue is empty.
	 */
	Object dequeue();

	/**
	 * Test if the queue is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	boolean isEmpty();

	/**
	 * Make the queue logically empty.
	 */
	void makeEmpty();
}
