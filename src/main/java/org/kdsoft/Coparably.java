package org.kdsoft;

@FunctionalInterface
public interface Coparably<T> {
	
	int compare(T o1, T o2);
	
	boolean equals(Object obj);
	
	String toString();
	
	int hashCode();
	
}
