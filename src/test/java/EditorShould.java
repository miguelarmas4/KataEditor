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

    @Test
    void lineBreaksOnSpacesIfExists() {
        originalText = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.";
        lineWidth = 40;

        formattedTextExpected = new StringBuilder();
        formattedTextExpected.append("Lorem Ipsum es simplemente el texto de ").append("\n");
        formattedTextExpected.append("relleno de las imprentas y archivos de ").append("\n");
        formattedTextExpected.append("texto. Lorem Ipsum ha sido el texto de ").append("\n");
        formattedTextExpected.append("relleno estándar de las industrias ").append("\n");
        formattedTextExpected.append("desde el año 1500, cuando un impresor ").append("\n");
        formattedTextExpected.append("(N. del T. persona que se dedica a la ").append("\n");
        formattedTextExpected.append("imprenta) desconocido usó una galería ").append("\n");
        formattedTextExpected.append("de textos y los mezcló de tal manera ").append("\n");
        formattedTextExpected.append("que logró hacer un libro de textos ").append("\n");
        formattedTextExpected.append("especimen. No sólo sobrevivió 500 ").append("\n");
        formattedTextExpected.append("años, sino que tambien ingresó como ").append("\n");
        formattedTextExpected.append("texto de relleno en documentos ").append("\n");
        formattedTextExpected.append("electrónicos, quedando esencialmente ").append("\n");
        formattedTextExpected.append("igual al original. Fue popularizado en ").append("\n");
        formattedTextExpected.append("los 60s con la creación de las hojas ").append("\n");
        formattedTextExpected.append("\"Letraset\", las cuales contenian ").append("\n");
        formattedTextExpected.append("pasajes de Lorem Ipsum, y más ").append("\n");
        formattedTextExpected.append("recientemente con software de ").append("\n");
        formattedTextExpected.append("autoedición, como por ejemplo Aldus ").append("\n");
        formattedTextExpected.append("PageMaker, el cual incluye versiones ").append("\n");
        formattedTextExpected.append("de Lorem Ipsum.");
        StringBuilder strAnswer = txtEditor.formatText(originalText, lineWidth);

        System.out.println(strAnswer.toString());
        assertEquals(formattedTextExpected.toString(), strAnswer.toString());
    }

}
