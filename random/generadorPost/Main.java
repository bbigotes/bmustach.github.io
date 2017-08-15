import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Post postActual = new Post();
    static Menu menu = new Menu();
    static MostrarTexto mostrarTexto = new MostrarTexto();

    public static void main(String [] buenasTardes){
       menu.mostrarMenu();
    }
}

class Menu{
    String helpText = "####";
    public void seleccionMenu(int tipo){ 
        switch (tipo) {
            case 1:
                Main.mostrarTexto.text("INGRESE TITULO");
                Main.postActual.titulo  = Main.scanner.next();
                Main.mostrarTexto.OK();
                mostrarMenu();
                break;
            case 2:
                
                Main.mostrarTexto.text("INGRESE FECHA");
                Main.postActual.fecha  = Main.scanner.next();
                Main.mostrarTexto.OK();
                mostrarMenu();
                break;
            case 3:
                
                Main.mostrarTexto.text("INGRESE FOTO");
                Main.postActual.foto  = Main.scanner.next();
                Main.mostrarTexto.OK();
                mostrarMenu();
                break;

            case 4:
                
                Main.mostrarTexto.text("INGRESE TEXTO");
                Main.postActual.texto  = Main.scanner.next();
                Main.mostrarTexto.OK();
                mostrarMenu();
                break;

            case 5:
                
                crearArchivo();
                Main.mostrarTexto.text("FIN");
                break;
            default:
                break;
        }
    }
    
     public void mostrarMenu(){    
         System.out.println(helpText+"Bmustach MENU"+helpText);
         String tituloOK = Main.postActual.titulo != null ? "-OK" : "1";
         String fechaOK = Main.postActual.fecha != null ? "-OK" : "2";
         String fotoOK = Main.postActual.foto != null ? "-OK" : "3";
         String textoOK = Main.postActual.texto != null ? "-OK" : "4";
         Main.mostrarTexto.text("("+tituloOK+")Titulo ("+fechaOK+")FECHA "+" ("+fotoOK+")FOTO ("+textoOK+")TEXTO (5) DEPLOY!");
         
        try {
              int tipoMenu = Integer.parseInt( Main.scanner.next() );
              Main.menu.seleccionMenu(tipoMenu);
        } catch (Exception e) {
            mostrarMenu();
        }
    }

    public void crearArchivo(){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(Main.postActual.titulo+".html"), "utf-8"));

            Main.postActual.plantilla=Main.postActual.plantilla.replace("[FECHA]",Main.postActual.fecha);
            Main.postActual.plantilla=Main.postActual.plantilla.replace("[TITULO]",Main.postActual.titulo);
            Main.postActual.plantilla=Main.postActual.plantilla.replace("[IMAGEN]",Main.postActual.foto + ".png");
            Main.postActual.plantilla=Main.postActual.plantilla.replace("[TEXTO]",Main.postActual.texto);

            writer.write(Main.postActual.plantilla);
        } catch (IOException ex) {
        // report
        } finally {
        try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}

class Post{
    String titulo;
    String foto;
    String texto;
    String fecha;
    String plantilla = 
    		"<!DOCTYPE html> "+
"<html>"+

"<head>"+
"  <meta charset='utf-8'>"+
"  <meta http-equiv=\"X-UA-Compatible\" content=\"chrome=1\">"+
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">"+
"  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">"+
"  <link href=\"https://fonts.googleapis.com/css?family=Poppins\" rel=\"stylesheet\">"+
"  <title>Bblog</title>"+
"</head>"+
"<body>"+
"  <div id=\"contenedor\">"+
"    <div id=\"main\" style=\"padding:0 16px;\">"+
"<h2>Bblog /Bbigotes / Bmustach </h2>"+
"<hr>"+
"<h2>[FECHA]  [TITULO] </h2>"+
"<img src=\"img/[IMAGEN]\" width=\"15%\" height=\"15%\" />"+
"<p>"+
"  [TEXTO]"+
"</p>"+
"</div>"+
"</div>"+
"</body>"+
"<hr>"+
"<footer>"+
"  <ol class=\"breadcrumb\">"+
"  <li><a href=\"../blog.html\">Volver/Back</a></li>"+
"</ol>"+
"  <center>"+
"    <a class=\"twitter-follow-button\" href=\"https://twitter.com/Bbigotes\">Tweets by Bbigotes</a>"+
"    <script async src=\"platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>"+
"    <p>Since 1988!</p>"+
"  </center>"+
"</footer>"+

"<script>"+
"  (function (i, s, o, g, r, a, m) {"+
"    i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {"+
"      (i[r].q = i[r].q || []).push(arguments)"+
"    }, i[r].l = 1 * new Date(); a = s.createElement(o),"+
"      m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)"+
"  })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');"+

"  ga('create', 'UA-88581538-1', 'auto');"+
"  ga('send', 'pageview');"+

"</script>"+

"</html>";
    		

}

class MostrarTexto{
    String helpText = "--";
    public void text(String texto){
           System.out.println(helpText+texto+helpText);
    }

    public void OK(){
        System.out.println("OK!");
    }
}