package com.wyd.interview.lesson5;

import java.util.ArrayList;

public class Myhashtable {
	private int size = 16;
	private ArrayList<HashEntry> _container = new ArrayList<HashEntry>(size);

	public Myhashtable() {
		for (int i = 0; i < size; i++) {
			_container.add(i, null);
		}
	}

	public ArrayList<HashEntry> getContainer() {
		return _container;
	}

	private int getIndex(int key) {
		// return (key * 40503) >>(32-4);
		return key % 16;

	}

	public boolean insert(Integer key, int value) {
		if (search(key) != null) {
			return false;
		}
		int theLocIndex = getIndex(key);
		if (theLocIndex >= 16) {
			return false;
		}
		if (_container.get(theLocIndex) == null) {
			HashEntry curEntry = new HashEntry();
			curEntry.key = key;
			curEntry.value = value;
			_container.remove(theLocIndex);
			_container.add(theLocIndex, curEntry);
			return true;

		} else if (_container.get(theLocIndex) != null) {
			HashEntry cEntry = _container.get(theLocIndex);
			HashEntry preEntry1 = cEntry;
			while (cEntry != null) {
				preEntry1 = cEntry;
				cEntry = cEntry.next;
			}
			HashEntry newEntry = new HashEntry();
			newEntry.pre = cEntry;
			newEntry.key = key;
			newEntry.value = value;
			preEntry1.next = newEntry;
			return true;
		}
		return false;
	}

	public HashEntry search(Integer key) {
		int theLocIndex = getIndex(key);
		if (_container.get(theLocIndex) == null) {
			return null;
		} else {
			HashEntry cEntry = _container.get(theLocIndex);
			while (cEntry != null) {
				if (cEntry.key == key) {
					return cEntry;
				} else {
					cEntry = cEntry.next;
				}

			}
			return null;

		}
	}

	public boolean remove(int key) {
		int theLocIndex = getIndex(key);
		if (_container.get(theLocIndex) == null) {
			return false;
		} else {
			HashEntry cEntry = _container.get(theLocIndex);
			while (cEntry != null) {
				if (cEntry.key == key) {
					if (cEntry.pre == null) {
						_container.remove(theLocIndex);
						return true;
					} else {
						cEntry.pre.next = cEntry.next;
						return true;
					}
				} else {
					cEntry = cEntry.next;
				}

			}
			return false;

		}
	}

	public boolean edit(int key, int value) {
		HashEntry cEntry = search(key);
		if (cEntry == null) {
			return false;
		}
		cEntry.value = value;
		return true;
	}

}
