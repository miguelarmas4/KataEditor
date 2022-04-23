public class Editor {
    public Editor() { }

    public StringBuilder formatText(String strOriginal, int lineWidth) {
        StringBuilder strResult = new StringBuilder();

        for (int actualPosition = 0; actualPosition < strOriginal.length(); actualPosition += lineWidth) {
            if (actualPosition > 0) {
                strResult.append("\n");
            }

            if (actualPosition + lineWidth > strOriginal.length()) {
                strResult.append(strOriginal.substring(actualPosition) );
            } else {
                strResult.append(strOriginal.substring(actualPosition, actualPosition+lineWidth) );
            }
        }

        return strResult;

    }


}
