package sml;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class

/**
 * a Hashmap class with String {@code label} and {@code address} associated to the label.
 * <p>the addLabel method checks if there is a duplicate before storing in map.
 * <p>the getAddress method checks the content of label if null throws exception.
 * <p>the toString method returns a list of labels Map
 * <p>the equals boolean returns a match of the same type of labels 
 * <p>the reset method to clear all the mappings in the labels Map 
 * @author Harris
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
		Objects.requireNonNull(label);
		// TODO: Add a check that there are no label duplicates.
		if (labels.containsKey(label) == true){
			throw new NullPointerException();
		}else{
			labels.put(label, address);
		}
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// TODO: Where can NullPointerException be thrown here?
		//       (Write an explanation.)
			/* NullPointerException if the label found null
			* otherwise the program fetch the label
			*/
		//       Add code to deal with non-existent labels.
		if (label == null){
			throw new NullPointerException();
		}else{
			return labels.get(label);
		}
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers).
		return labels.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + " -> " + e.getValue())
                .collect(Collectors.joining(", ", "[", "]")) ;
	}

	// TODO: Implement equals and hashCode (needed in class Machine).
	@Override
	public boolean equals(Object o) {
		if (o instanceof Labels) {
			Labels other = (Labels) o;
			return labels.equals(other.labels);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return labels.hashCode();
	}

	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
