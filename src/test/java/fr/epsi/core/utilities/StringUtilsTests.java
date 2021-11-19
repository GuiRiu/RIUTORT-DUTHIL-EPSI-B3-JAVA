package fr.epsi.core.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import fr.epsi.core.MathUtils;
import fr.epsi.core.StringUtils;

class StringUtilsTests {
	@Nested
	@DisplayName("StringUtils.isPalindrome")
	class PalindromeMethod {
		@ParameterizedTest(name = "{0} is palindrome")
		@ValueSource(strings = { "kayak", "radar", "laval", "non", "bob" })
		void is_palindrome(String sentences) {
			assertTrue(StringUtils.isPalindrome(sentences));
		}

		@ParameterizedTest(name = "{0} is not palindrome")
		@ValueSource(strings = { "patate", "route", "pelle", "botte", "short" })
		void is_not_palindrome(String sentences) {
			assertFalse(StringUtils.isPalindrome(sentences));
		}
	}

	@Nested
	@DisplayName("StringUtils.cesar")
	class CesarMethod {
		@ParameterizedTest(name = "{0} encoded with step of {2}")
		@CsvFileSource(resources = "/data/stringcesar.csv", numLinesToSkip = 1)
		void cesar_encode(String answers, String sentences, int step) {
			assertEquals(answers, StringUtils.cesarEncode(sentences, step));
		}

		@ParameterizedTest(name = "{0} decoded with step of {2}")
		@CsvFileSource(resources = "/data/stringcesardecoded.csv", numLinesToSkip = 1)
		void cesar_decode(String answers, String sentences, int step) {
			assertEquals(answers, StringUtils.cesarDecode(sentences, step));
		}
	}
}
