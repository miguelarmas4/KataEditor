import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorShould {
    Editor txtEditor = new Editor();

    @Test
    void splitLineWhenWordDoNotFitOnLineWidth() {

        assertEquals("",txtEditor.formatText("",3));
        assertEquals("mas",txtEditor.formatText("mas",5));
        assertEquals("long\nword", txtEditor.formatText("longword", 4));
        assertEquals("areall\nylongw\nord", txtEditor.formatText("areallylongword", 6));

    }

    @Test
    void breakingLineAtSpacePositionAvoidingOneSpaceWhenFindingDoubleSpace() {

        assertEquals("\ndef", txtEditor.formatText(" def", 3));
        assertEquals(" \ndef", txtEditor.formatText("  def", 3));
        assertEquals("abc\n\ndef", txtEditor.formatText("abc def", 3));
        assertEquals("abc\n \ndef", txtEditor.formatText("abc  def", 3));

        assertEquals("abc\n \ndef\n\nghi\n\njkl", txtEditor.formatText("abc  def ghi jkl", 5));
        assertEquals("abc\n \ndef\n \nghi\n \njkl", txtEditor.formatText("abc  def  ghi  jkl", 5));

    }

    @Test
    void expectedExceptionNegativeLength() {
        Assertions.assertThrows( StringIndexOutOfBoundsException.class, () -> {
            txtEditor.formatText("word", -4);
        }, "Lines with negative length not allowed");
    }

    @Test
    void expectedExceptionZeroLength() {
        Assertions.assertThrows( StackOverflowError.class, () -> {
            txtEditor.formatText("Word", 0);
        }, "Cannot be zero");
    }

}
