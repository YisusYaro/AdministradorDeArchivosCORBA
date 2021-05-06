import java.io.*;

public class FileServant extends _FileInterfaceImplBase {

    public String ContarLineas(String archivo) {
        int NumLineas = 0;
        String lineas = "";
        File file = new File(archivo);
        FileReader fr = null;
        BufferedReader br = null;

        System.out.println(archivo);

        file = new File(archivo);
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((lineas = br.readLine()) != null) {
                    NumLineas++;
                }
            } catch (IOException e) {
                System.out.println("Error al leer la linea del archivo.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo.");
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }

        return NumLineas + "";
    }

    public String ContarVocales(String archivo) {
        String lineas = "";
        int Vocales = 0;
        File file = new File(archivo);
        FileReader fr = null;
        BufferedReader br = null;

        file = new File(archivo);
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((lineas = br.readLine()) != null) {
                    String fraseMin = lineas.toLowerCase();

                    for (int i = 0; i < fraseMin.length(); ++i) {
                        switch (fraseMin.charAt(i)) {
                            case 'a':

                            case 'e':

                            case 'i':

                            case 'o':

                            case 'u':

                                Vocales++;
                                break;
                            default:
                                // se ignoran las dem�s letras
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer la linea del archivo.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo.");
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
        return Vocales + "";
    }

    public void Escribe(String archivo, String contenido) {
        try {
            OutputStream out = new FileOutputStream(archivo);
      
            // Converts the string into bytes
            byte[] dataBytes = contenido.getBytes();
      
            // Writes data to the output stream
            out.write(dataBytes);
      
            // Closes the output stream
            out.close();
          }
      
          catch (IOException e) {
            System.out.println("Error.");
          }
    }

    public String Imprimir(String archivo) {
        String lineas = "";
        String texto = "";
        File file = new File(archivo);
        FileReader fr = null;
        BufferedReader br = null;

        file = new File(archivo);
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((lineas = br.readLine()) != null) {
                    texto = texto + lineas + "\n";
                }
            } catch (IOException e) {
                System.out.println("Error al leer la linea del archivo.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo.");
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
        return texto;
    }

    public void Respaldar(String archivo, String respaldo) {
        String lineas = "";
        File file = new File(archivo);
        FileReader fr = null;
        BufferedReader br = null;

        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            fichero = new FileWriter(respaldo);
            pw = new PrintWriter(fichero);

            while ((lineas = br.readLine()) != null) {
                pw.println(lineas);
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo.");
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
                fr.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }

    public void Copiar(String archivo, String archivin) {
        String lineas = "";
        File file = new File(archivo);
        FileReader fr = null;
        BufferedReader br = null;

        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            fichero = new FileWriter(archivin, true);
            pw = new PrintWriter(fichero);

            while ((lineas = br.readLine()) != null) {
                pw.println(lineas);
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo.");
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
                fr.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }

    public void Renombrar(String archivo, String renombrado) {
        String lineas = "";
        File file = new File(archivo);
        FileReader fr = null;
        BufferedReader br = null;

        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            fichero = new FileWriter(renombrado);
            pw = new PrintWriter(fichero);

            while ((lineas = br.readLine()) != null) {
                pw.println(lineas);
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo.");
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
                fr.close();
                file.delete();
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }

    public boolean Borrar(String archivo) {
        File f = new File(archivo);
        return f.delete();
    }

}