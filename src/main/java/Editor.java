public class Editor {
    public Editor() { }

    public String formatearTexto(int ancho, int largo, String texto) {

        String resultado = "";

        //int largo = 2;
        for (int i = 0; i < texto.length(); i++) {
            if (i==largo) {
                resultado += texto.substring(ancho) + "\r\n" + texto.substring(ancho, texto.length());
            }
        }

        return resultado;
    }

}
