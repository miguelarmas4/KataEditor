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
        lineWidth = 2;

        formattedTextExpected = new StringBuilder();
        formattedTextExpected.append("Te").append("\n");
        formattedTextExpected.append("ne").append("\n");;
        formattedTextExpected.append("ri").append("\n");;
        formattedTextExpected.append("fe");

        StringBuilder strAnswer = txtEditor.formatText(originalText, lineWidth);
        assertEquals(formattedTextExpected,  strAnswer);

    }

}
