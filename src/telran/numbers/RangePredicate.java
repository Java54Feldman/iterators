package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate extends Range {
	private Predicate<Integer> predicate = num -> true;
//	лямбда-выражение num -> true означает, что для любого переданного значения num будет возвращено true

	protected RangePredicate(int min, int max) {
		super(min, max);
	}

	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}

	public static RangePredicate getRange(int min, int max) {
		checkMinMax(min, max);
		return new RangePredicate(min, max);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RangePredicateIterator();
	}

	private class RangePredicateIterator implements Iterator<Integer> {
		int current = min;

		@Override
		public boolean hasNext() {
			boolean res = false;
			int value = current;
			while(value <= max && !(res = predicate.test(value++)));
			return res;
		}

		@Override
		public Integer next() {
			while (!hasNext()) {
				throw new NoSuchElementException();
			}
			while(!predicate.test(current++));
			return current - 1;
		}
		
	}
}
