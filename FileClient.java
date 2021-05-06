import java.io.*;
import java.util.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class FileClient {
    public static void main(String argv[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(argv, null);
            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("FileTransfer", " ");
            // Resolve the object reference in naming
            NameComponent path[] = { nc };
            FileInterfaceOperations fileRef = FileInterfaceHelper.narrow(ncRef.resolve(path));

            if (argv.length < 1) {
                System.out.println("Usage: java FileClient filename");
            }

            // save the file
            int operador;
            System.out.println(argv[0]);
            if(argv[0].equals("ContarLineas")){
                System.out.println(argv[1]);
                System.out.println("hola");
                System.out.println(fileRef.ContarLineas(argv[1]));
            }
            if(argv[0].equals("ContarVocales")){
                System.out.println(fileRef.ContarVocales(argv[1]));
            }
            if(argv[0].equals("Escribe")){
                fileRef.Escribe(argv[1],argv[2]);
                System.out.println("Escritura exitosa.");
            }
            if(argv[0].equals("Imprimir")){
                System.out.println(fileRef.Imprimir(argv[1]));
            }
            if(argv[0].equals("Respaldar")){
                fileRef.Respaldar(argv[1], argv[2]);
                System.out.println("Respaldo exitoso.");
            }
            if(argv[0].equals("Copiar")){
                fileRef.Copiar(argv[1], argv[2]);
                System.out.println("El archivo fue copiado exitosamente.");
            }
            if(argv[0].equals("Renombrar")){
                fileRef.Renombrar(argv[1], argv[2]);
                System.out.println("El archivo fue renombrado correctamente.");
            }
            if(argv[0].equals("Borrar")){
                if (fileRef.Borrar(argv[1])) {
                    System.out.println("El archivo fue eliminado correctamente.");
                } else {
                    System.out.println("Hubo un error al eliminar el archivo.");
                }
            }

        } catch (Exception e) {
            System.out.println("FileClient Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}