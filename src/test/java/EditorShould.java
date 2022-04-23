import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorShould {
    String originalText = "";
    int lineWidth = 0;
    StringBuilder formattedTextExpected;
    Editor txtEditor = new Editor();

    @Test
    void initialTextDivision() {
        originalText = "Tenerife";
        lineWidth = 3;

        formattedTextExpected = new StringBuilder();
        formattedTextExpected.append("Ten").append("\n");
        formattedTextExpected.append("eri").append("\n");
        formattedTextExpected.append("fe");

        StringBuilder strAnswer = txtEditor.formatText(originalText, lineWidth);
        assertEquals(formattedTextExpected.toString(), strAnswer.toString());

    }

    @Test
    void widthExactlyLastSubstringWidth() {
        originalText = "Tenerifes";
        lineWidth = 3;

        formattedTextExpected = new StringBuilder();
        formattedTextExpected.append("Ten").append("\n");
        formattedTextExpected.append("eri").append("\n");
        formattedTextExpected.append("fes");

        StringBuilder strAnswer = txtEditor.formatText(originalText, lineWidth);
        assertEquals(formattedTextExpected.toString(), strAnswer.toString());
    }

}
