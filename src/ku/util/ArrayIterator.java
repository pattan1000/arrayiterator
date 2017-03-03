package ku.util;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * ArrayIterator class that provides an Iterator for any array.
 * 
 * @author Pattara Phobasakul
 * 
 * @param <T>
 *            is the type of element in ArrayIterator
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;

	/** check is the attribute that check if remove()method can use or not use */
	private boolean check;

	/** cursor is the index of the array */
	private int cursor;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to repeat
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.check = false;
		this.cursor = 0;

	}

	/**
	 *  Skip null values  by return the next non-null element from array.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if no more elements to return.
	 */
	@Override
	public T next() {
		if (this.hasNext()) {
			T next = array[cursor];
			this.cursor++;
			this.check = true;
			return next;
		} else
			throw new NoSuchElementException();
	}

	/**
	 * Return true if next() has more non-null elements , False if no more.
	 * 
	 * @return true if the iteration has more non-null elements,
	 *         false if no more.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < this.array.length; i++) {
			if (this.array[i] != null) {
				this.cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove last element returned by next(). 
	 * 
	 * 
	 * @throws IllegalStateException
	 *             if the next() method has not used, or the
	 *             remove() method has called after the last
	 *             call of the next() method.
	 */
	@Override
	public void remove() {
		if (check) {
			array[cursor - 1] = null;
			check = false;
		} else
			throw new IllegalStateException();
	}

}
