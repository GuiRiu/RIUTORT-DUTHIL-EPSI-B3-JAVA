package fr.epsi.core.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import fr.epsi.core.MathUtils;

class MathUtilsTests {
	@Nested
	@DisplayName("MathUtils.factorial")
	class FactorialMethod {
		@ParameterizedTest(name = "factorial of {0} is {1}")
		@CsvFileSource(resources = "/data/factorial.csv", numLinesToSkip = 1)
		void factorial_of_positive_numbers(int number, double expected) {
			assertEquals(expected, MathUtils.factorial(number));
		}
	}

	@Nested
	@DisplayName("MathUtils.isPrimeNumber")
	class PrimeNumberMethod {
		@ParameterizedTest(name = "{0} is a prime number")
		@ValueSource(ints = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 })
		void prime_number(int number) {
			assertTrue(MathUtils.isPrimeNumber(number));
		}

		@ParameterizedTest(name = "{0} is not a prime number")
		@ValueSource(ints = { 0, 1, 4, 6, 8, 9, 10, 12, 14, 15 })
		void not_prime_number(int number) {
			assertFalse(MathUtils.isPrimeNumber(number));
		}
	}
}
