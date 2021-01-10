package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.AccessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matcher;

public class StringCalculatorApplicationTests {

	@Test
	public void sumsEmptyStringTo0() {
		assertThat(StringCalculatorApplicationTests.sum(""), is(0));
	}

	private void assertThat(Object sum, Matcher<Integer> matcher) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void sumsSingleNumberToItself() {
		assertThat(StringCalculatorApplicationTests.sum("5"), is(5));
		assertThat(StringCalculatorApplicationTests.sum("42"), is(42));
	}

	@Test
	public void sumsTwoNumbersSeperatedByComma() {
		assertThat(StringCalculatorApplicationTests.sum("1,2"), is(3));
		assertThat(StringCalculatorApplicationTests.sum("1,3"), is(4));
	}

	@Test
	public void sumsThreeNumbersSeperatedByComma() {
		assertThat(StringCalculatorApplicationTests.sum("1,2,3"), is(6));
	}

	@Test
	public void sumsNumbersDelimitedByNewline() {
		assertThat(StringCalculatorApplicationTests.sum("1\n2"), is(3));
	}

	private static Object sum(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void sumsNumbersDelimitedByCommaOrNewline() {
		assertThat(StringCalculatorApplicationTests.sum("1,2\n3"), is(6));
	}

	@Test
	public void usesDelimiterSepcified() {
		assertThat(StringCalculatorApplicationTests.sum("//;\n1;2"), is(3));
		assertThat(StringCalculatorApplicationTests.sum("//.\n2.3.1"), is(6));
	}


	@Test
	public void throwsOnNegativeNumber() {
		
		

		assertThat(StringCalculatorApplicationTests.sum("-3"),is(-3));
	}

	@Test
	public void throwsOnNegativeNumbersWithAllNumbersInExceptionMessage() {
		
		assertThat(StringCalculatorApplicationTests.sum("1,-3,5,-5,-13"),mm(-3,-5,-13));
	}

	private Matcher<Integer> mm(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	private Matcher<Integer> is(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void mapsNumbersAbove1000ToLastThreeDigits() {
		assertThat(StringCalculatorApplicationTests.sum("1002"), is(2));
		assertThat(StringCalculatorApplicationTests.sum("1040,10002"), is(42));
	}

	@Test
	public void acceptsDelimiterOfArbitraryLength() {
		assertThat(StringCalculatorApplicationTests.sum("//[***]\n1***2***3"), is(6));
	}

	@Test
	public void acceptsMultipleDelimiters() {
		assertThat(StringCalculatorApplicationTests.sum("//[-][;]\n1-2;3"), is(6));
		assertThat(StringCalculatorApplicationTests.sum("//[--][...]\n2--3...4"), is(9));
	}
}
