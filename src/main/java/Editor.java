public class Editor {
    public Editor() { }

    public StringBuilder formatText(String strOriginal, int lineWidth) {
        StringBuilder strResult = new StringBuilder();

        int actualPosition = 0;
        while (actualPosition + lineWidth <= strOriginal.length()) {
            if (actualPosition > 0) {
                strResult.append("\n");
            }
            strResult.append(strOriginal.substring(actualPosition, actualPosition+lineWidth) );
            actualPosition += lineWidth;
        }

        return strResult;

    }


}
