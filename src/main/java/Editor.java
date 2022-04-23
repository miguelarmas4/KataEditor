public class Editor {
    public Editor() { }

    public StringBuilder formatText(String strOriginal, int lineWidth) {
        StringBuilder strResult = new StringBuilder();
        int changePosition = 0;

        for (int actualPosition = 0; actualPosition < strOriginal.length(); actualPosition += lineWidth) {

            if (actualPosition > 0) {
                strResult.append("\n");
            }

            if (changePosition != 0) {
                actualPosition -= changePosition;
                changePosition = 0;
            }

            if (actualPosition + lineWidth > strOriginal.length()) {  // <-- End of text
                strResult.append(strOriginal.substring(actualPosition) );
            } else {

                int breakPos = findBreakPoint(strOriginal, actualPosition, lineWidth);
                strResult.append(strOriginal.substring(actualPosition, breakPos) );
                changePosition = lineWidth - breakPos + actualPosition;

            }
        }

        return strResult;

    }

    public int findBreakPoint(String strOriginal, int actualPosition, int lineWidth) {
        for (int i = lineWidth-2; i >=0; i--){
            if(strOriginal.substring(actualPosition+i, actualPosition+i+1).equals(" ")) {
                return actualPosition + i + 1;
            }
        }
        return actualPosition+lineWidth;
    }


}
