public class Editor {
    public Editor() {
    }

    public String formatText(String strOriginal, int lineWidth) {

        int spacePos = strOriginal.indexOf(" ");
        if (lineWidth >= strOriginal.length() & spacePos == -1) {
            return strOriginal;
        }

        int breakPos = (spacePos > -1 && spacePos < lineWidth)
                ? (spacePos == 0 && spacePos < strOriginal.length() - 1)
                        ? (strOriginal.charAt(spacePos + 1) == ' ')
                                ? spacePos + 1
                                : spacePos
                        : spacePos
                : lineWidth;

        String cuttedText = strOriginal.substring(0, breakPos).concat("\n");;
        String uncuttedText = strOriginal.substring(breakPos);

        if (spacePos==0) {
            uncuttedText = uncuttedText.replaceFirst(" ", "");
        }

        return cuttedText.concat(formatText(uncuttedText, lineWidth));
    }

}
