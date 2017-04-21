import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest {

	@Test
	public void test() {
		MyTask task = new MyTask();

		assertArrayEquals(new String[]{
				"i"}, 
				task.getMissedWords(
						"i am using HackerRank i to improve programming",
						"i am using HackerRank to improve programming"));
		
		assertArrayEquals(new String[]{
				"i","am"}, 
				task.getMissedWords(
						"i am using HackerRank to improve programming",
						"using HackerRank to improve programming"));
		
		assertArrayEquals(new String[]{
				"i","i","i"}, 
				task.getMissedWords(
						"i am using HackerRank i to improve programming i and i",
						"am using HackerRank to improve programming and i"));
		
		assertArrayEquals(new String[]{
				"i", "am", "using", "to","improve","programming"}, 
				task.getMissedWords(
						"i am using HackerRank to improve programming",
						"HackerRank"));
		
		assertArrayEquals(new String[]{
				"using",
				"to",
				"programming",
				"i"}, 
				task.getMissedWords(
						"i am using HackerRank to i improve programming i",
						"i am HackerRank i improve "));
		
		assertEquals("twenty two", task.getWordsFromNumber(22));
		assertEquals("minus nineteen million eight hundred thirty five thousand seven hundred thirty", task.getWordsFromNumber(-19835730));
		assertEquals("ten thousand three hundred forty one", task.getWordsFromNumber(10341));

		assertEquals("He", task.firstRepeatedWord("He:had quite-enougth:of;this,nonsense;He.had"));
		
		assertEquals(2, task.getPalindromesNumber("madamqweraalaa"));
		assertEquals(1, task.getPalindromesNumber("no x in nixon"));
		assertEquals(1, task.getPalindromesNumber("asdfggfdsa"));
		assertEquals(3, task.getPalindromesNumber("was it a car or a cat i saw"));
		
		assertEquals(-16, task.simpleCalculator("-10-1-5"));
		assertEquals(600, task.simpleCalculator("-100+200+500"));
	}

}
