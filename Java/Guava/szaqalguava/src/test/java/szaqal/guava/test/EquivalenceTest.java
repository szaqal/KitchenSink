package szaqal.guava.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
public class EquivalenceTest {

	@Test
	public void testEquivalence() {
		Sample sample1 = new Sample(3, "ddd");
		Sample sample2 = new Sample(3, "ddd");
		Sample sample3 = new Sample(4, "ddd");
		
		ArrayList<Sample> samples = Lists.newArrayList(sample1, sample2, sample3);
		Equivalence<Sample> equals = new SampleEquivalence();
		
		assertTrue(equals.equivalent(sample1, sample2));
		assertFalse(equals.equivalent(sample2, sample3));
		
		Collection<Sample> filter = Collections2.filter(samples, equals.equivalentTo(sample3));
		assertTrue(1 == filter.size());
	}

	private class SampleEquivalence extends Equivalence<Sample> {

		@Override
		protected boolean doEquivalent(Sample sample1, Sample sample2) {
			return sample1.equals(sample2);
		}

		@Override
		protected int doHash(Sample sample1) {
			return sample1.hashCode();
		}

	}

	private class Sample {

		private int number;

		private String text;

		public Sample(int number, String text) {
			super();
			this.number = number;
			this.text = text;
		}

		public int getNumber() {
			return number;
		}

		public String getText() {
			return text;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(text.hashCode(), Integer.valueOf(number).hashCode());
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Sample)) {
				return false;
			}
			Sample sample = (Sample) obj;
			return Objects.equal(text, sample.getText()) && Objects.equal(Integer.valueOf(number), Integer.valueOf(sample.getNumber()));
		}
	}

}
