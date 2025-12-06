import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveTesting {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

//countSubstrings()

    @Test
    public void testCountSubstringsNoMatch() {
        assertEquals(0, RecursivePractice.countSubstrings("abc", "zzz"));
    }
    @Test
    public void testCountSubstringsShortWord() {
        assertEquals(0, RecursivePractice.countSubstrings("hi", "hello"));
    }
    @Test
    public void testCountSubstringsOverlap() {
        assertEquals(2, RecursivePractice.countSubstrings("banana", "ana"));
    }
    @Test
    public void testCountSubstringsStartsHere() {
        assertEquals(1, RecursivePractice.countSubstrings("apple", "app"));
    }

//digitMatch()

    @Test
    public void testDigitMatchBasic() {
        assertEquals(1, RecursivePractice.digitMatch(5, 15));
    }
    @Test
    public void testDigitMatchNone() {
        assertEquals(0, RecursivePractice.digitMatch(123, 890));
    }
    @Test
    public void testDigitMatchMultiple() {
        assertEquals(4, RecursivePractice.digitMatch(1072503891, 62530841));
    }
    @Test
    public void testDigitMatchStopsEarly() {
        assertEquals(0, RecursivePractice.digitMatch(9, 18));
    }

//multiplyOdds()

    @Test
    public void testMultiplyOddsBase() {
        assertEquals(1, RecursivePractice.multiplyOdds(1));
    }
    @Test
    public void testMultiplyOddsRecursive() {
        assertEquals(105, RecursivePractice.multiplyOdds(4));
    }
    @Test
    public void testMultiplyOddsException() {
        assertThrows(IllegalArgumentException.class, () -> RecursivePractice.multiplyOdds(0));
    }

//findsecondlargest()

    @Test
    public void testSecondLargest() {
        int[] arr = {1, 5, 3};
        assertEquals(3, RecursivePractice.findSecondLargest(arr));
    }
    @Test
    public void testSecondLargestLargestRepeated() {
        int[] arr = {7, 1, 7};
        assertEquals(7, RecursivePractice.findSecondLargest(arr));
    }
    @Test
    public void testSecondLargestNegatives() {
        int[] arr = {-10, -3, -20};
        assertEquals(-10, RecursivePractice.findSecondLargest(arr));
    }
    @Test
    public void testSecondLargestTwoElements() {
        int[] arr = {4, 10};
        assertEquals(4, RecursivePractice.findSecondLargest(arr));
    }

//Permutation()

    @Test
    public void testPermutationBase() {
        assertEquals(1.0, RecursivePractice.permutation(6, 0));
    }
    @Test
    public void testPermutationRecursive() {
        assertEquals(840.0, RecursivePractice.permutation(7, 4));
    }
    @Test
    public void testPermutationException() {
        assertThrows(IllegalArgumentException.class, () -> RecursivePractice.permutation(2, 5));
    }

//subsetsOfSize()

    @Test
    public void testSubsetsOfSizeSize2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        RecursivePractice.subsetsOfSize(list, 2);
        String output = outContent.toString().trim();

        assertTrue(output.contains("[A, B]"));
        assertTrue(output.contains("[A, C]"));
        assertTrue(output.contains("[B, C]"));
    }
    @Test
    public void testSubsetsOfSizeSize1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("X");
        list.add("Y");

        RecursivePractice.subsetsOfSize(list, 1);
        String output = outContent.toString().trim();

        assertTrue(output.contains("[X]"));
        assertTrue(output.contains("[Y]"));
    }
    @Test
    public void testSubsetsOfSizeTwo() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        RecursivePractice.subsetsOfSize(list, 2);

        String output = outContent.toString().trim();
        assertTrue(output.contains("[A, B]"));
        assertTrue(output.contains("[A, C]"));
        assertTrue(output.contains("[B, C]"));
    }
    @Test
    public void testSubsetsOfSizeTooLarge() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        RecursivePractice.subsetsOfSize(list, 3);
        String output = outContent.toString().trim();

        assertEquals("", output);
    }
    @Test
    public void testSubsetsOfSizeExactFit() {
        ArrayList<String> list = new ArrayList<>();
        list.add("P");
        list.add("Q");

        RecursivePractice.subsetsOfSize(list, 2);
        String output = outContent.toString().trim();

        assertTrue(output.contains("[P, Q]"));
    }
}

