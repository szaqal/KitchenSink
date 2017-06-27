package javaee.sample.model;

import java.util.List;


import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import com.google.common.collect.Lists;

public class ModelTest {

	private static final List<Class<?>> TESTABLE_BEANS = Lists.newArrayList(Customer.class, Tune.class, TuneOrder.class);
	
	private BeanTester tester = new BeanTester();
	
	private EqualsMethodTester equalsTester = new EqualsMethodTester();
	
	private HashCodeMethodTester hashTester = new HashCodeMethodTester();
	

	@Test
	public void testBeans() {
		TESTABLE_BEANS.forEach(tester::testBean);
	}
	
	@Test
	public void testEquals() {
		TESTABLE_BEANS.forEach(equalsTester::testEqualsMethod);
	}
	
	@Test
	public void testHashCode() {
		TESTABLE_BEANS.forEach(hashTester::testHashCodeMethod);
	}

}
