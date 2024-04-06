package telran.numbers;

import java.util.Iterator;
import java.util.function.Predicate;

public class RangePredicate extends Range {
	private Predicate<Integer> predicate;

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
		// TODO
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
