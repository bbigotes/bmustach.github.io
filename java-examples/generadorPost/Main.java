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
         String tituloOK = Main.postActual.titulo != null ? "-OK" : "";
         String fechaOK = Main.postActual.fecha != null ? "-OK" : "";
         String fotoOK = Main.postActual.foto != null ? "-OK" : "";
         String textoOK = Main.postActual.texto != null ? "-OK" : "";
         Main.mostrarTexto.text(" (1)Titulo"+tituloOK+" (2)FECHA "+fechaOK+" (3)FOTO "+fotoOK+" (4)TEXTO"+textoOK +" (5) DEPLOY!");
        
        try {
              int tipoMenu = Integer.parseInt( Main.scanner.next() );
              Main.menu.seleccionMenu(tipoMenu);
        } catch (Exception e) {
            System.out.println("mostrar menu");
            mostrarMenu();
        }
       
        
    }

    public void crearArchivo(){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(Main.postActual.titulo+".txt"), "utf-8"));
            writer.write(Main.postActual.texto);
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
}

class MostrarTexto{
    String helpText = "####";
    public void text(String texto){
           System.out.println(helpText+texto+helpText);
    }

    public void OK(){
        System.out.println("OK!");
    }
}