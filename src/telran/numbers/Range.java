package telran.numbers;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
	private int min;
	private int max;
	private Range(int min, int max) {
		this.min = min;
		this.max = max;
	};
	@Override
	public Iterator<Integer> iterator() {
		return new RangeIterator();
	}
	public static Range getRange(int min, int max) {
		if (max <= min) {
			throw new IllegalArgumentException("max less or equal min");
		}
		return new Range(min, max);
	}

	//inner class
	//внутри объекта иннер класса есть доступ к полям внешнего класса
	private class RangeIterator implements Iterator<Integer> {
		int current = min;
		@Override
		public boolean hasNext() {
			return current <= max;
		}

		@Override
		public Integer next() {
			return current++;
		}
		
	}
}
