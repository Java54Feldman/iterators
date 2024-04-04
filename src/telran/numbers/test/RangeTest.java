package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.numbers.Range;

class RangeTest {

	@Test
	void IterableIteratorTest() {
		Integer[] expected = {5, 6, 7, 8, 9, 10};
		Range range = Range.getRange(5, 10);
		Integer[] actual = new Integer[expected.length];
		assertArrayEquals(expected, toArrayFromIterable(new Integer[6], range));
	}
	private <T> T[] toArrayFromIterable(T[] array, Iterable<T> iterable) {
		int index = 0;
		for(T obj: iterable) {
			array[index++] = obj;
		}
		return array;
	}

}
