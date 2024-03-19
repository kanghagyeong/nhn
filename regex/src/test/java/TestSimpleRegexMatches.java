import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class TestSimpleRegexMatches {

    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;

        while (matcher.find()) {
            matches++;
        }

        return matches;
    }

    @Test
    public void givenText_whenSimpleRegexMatches_thenCorrect() {
        String source = "foo";
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher(source);

        assertTrue(matcher.find());
    }

    @Test
    public void givenText_whenSimpleRegexMatchesTwice_thenCorrect() {
        String source = "foofoo";
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher(source);

        int matches = 0;
        while (matcher.find()) {
            matches++;
        }

        assertEquals(matches, 2);
    }

    @Test
    public void givenText_whenMatchesWithDoMetach_thenCorrect() {
        int matches = runTest(".", "foo");

        assertTrue(matches > 0);
    }

    @Test
    public void givenOPSet_whenMatchesAny_thenCorrect() {
        int matches = runTest("[abc]", "ba"); // abc 중에 있는지 ?

        assertEquals(2, matches);
    }

    @Test
    public void givenOPSet_whenMatchesAllCombinations_thenCorrect() {
        int matches = runTest("[bcr]at", "bat cat rat");

        assertEquals(3, matches);
    }

    @Test
    public void givenNORSet_whenMatchesNon_thenCorrect() {
        int matches = runTest("[^abc]", "ag");  // abc를 제외한 나머지가 있는지 ?

        assertTrue(matches > 0);
    }

    @Test
    public void givenUpperCaseRange_whenMatchesUpperCase_thenCorrect() {
        int matches = runTest("[A-Z]", "Two Uppercase alphabets 34 overall"); //A에서 Z까지 대문자 몇 개 ?

        assertEquals(2, matches);
    }

    @Test
    public void givenLowerCaseRange_whenMatchesLowerCase_thenCorrect() {
        int matches = runTest("[a-z]", "Two Uppercase alphabets 34 overall"); // 소문자
        assertEquals(26, matches);
    }

    @Test
    public void givenBothLowerAndUpperCaseRange_whenMatchesAllLetters_thenCorrect() {
        int matches = runTest("[a-zA-Z]", "Two Uppercase alphabets 34 overall"); //

        assertEquals(28, matches);
    }

    @Test
    public void givenTwoSets_whenMatchesUnion_thenCorrect() {
        int matches = runTest("[1-3[7-9]]", "123456789");

        assertEquals(matches, 6);
    }

    @Test
    public void givenOneOrManyQuantifier_whenMatches_thenCorrect() {
        int matches = runTest("//a+", "hi");

        assertFalse(matches > 0);
    }

    @Test
    public void givenCapturingGroup_whenMatchesBackReference_thenCorrect() {
        int matches = runTest("(\\d\\d)(ab)\\1\\2", "12ab12ab12");

        assertEquals(matches, 1);
    }

    @Test
    public void givenTextAndWrongInput_whenMatchFailatBeginning_thenCorrect() {
        int matches = runTest("^dog", "are dogs are friendly?");

        assertFalse(matches > 0);
    }

    @Test
    public void givenText_whenMatchesAtWordBoundary_thenCorrect() {
        int matches = runTest("\\bdog\\b", "a dog is friendly");

        assertTrue(matches > 0);

    }

    @Test
    public void testIntegerPattern() {
        String regex = "\\b[+-]?[0-9]{1,10}\\b";
        assertEquals(1, runTest( regex, "0"));
        assertEquals(1, runTest( regex, "1"));
        assertEquals(1, runTest( regex, "123"));
        assertEquals(0, runTest( regex, "12345678901"));
        assertEquals(1, runTest( regex, "0"));
        assertEquals(1, runTest( regex, "-1"));
        assertEquals(1, runTest( regex, "-123"));
        assertEquals(0, runTest( regex, "-12345678901"));
        
    }
}