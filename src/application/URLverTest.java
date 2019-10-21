package application;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class URLverTest {

	@Test
	public void test() throws IOException {
		Reader test = new Reader();
		String output = test.getURL();
		String urlTest = "https://en.wikipedia.org/wiki/Software_testing";
		assertEquals(urlTest , output);
	}

}
