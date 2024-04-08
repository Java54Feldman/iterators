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
		long current = (long)min - 1;
		//оператор кастинг (long). тип переменной поменять нельзя
		//long current = min - 1l; same
		RangePredicateIterator() {
			if(predicate == null) {
				predicate = x -> true;
			}
			setCurrent();
		}

		@Override
		public boolean hasNext() {
			return current <= max;
		}

		@Override
		public Integer next() {
			while (!hasNext()) {
				throw new NoSuchElementException();
			}
			int result = (int)current;
			setCurrent();
			return result;
		}
		private void setCurrent() {
			current++;
			while(current <= max && !predicate.test((int) current)) {
				current++;
			}
		}
		
	}
}
