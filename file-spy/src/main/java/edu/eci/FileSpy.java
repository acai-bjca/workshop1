package edu.eci;

import java.nio.file.*;

import org.apache.tika.Tika;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class FileSpy {
    private static final String FILE_TYPE = "text/csv";
    private static final String DIR_TO_WATCH = "E:\\Amalia\\Downloads\\7\\ARSW\\Laboratorios\\Lab1";

    public static void main(String[] args) throws Exception {    	
        Path dir = Paths.get(DIR_TO_WATCH);        
        Tika tika = new Tika(); //1
        WatchService watchService = FileSystems.getDefault().newWatchService(); //2
        dir.register(watchService, ENTRY_CREATE); //3

        WatchKey key;
        do {
            key = watchService.take(); //4

            key.pollEvents().stream().filter(e -> { //5
                Path filename = (Path) e.context(); //6
                String type = tika.detect(filename.toString()); //7
                return FILE_TYPE.equals(type); //8
            }).forEach(e -> //
                System.out.printf("File found: %s%n", e.context())
            );
        } while (key.reset());
    }
    
    /*1. Tika: marco de análisis y detección de contenido, detecta y extrae metadatos y texto de más de mil tipos de archivos diferentes.
    2. WatchService: Un servicio de vigilancia que vigila los objetos registrados en busca de cambios y eventos. 
    	 Busca que se pueda actualizar la visualización de los cambios en la lista de archivos cuando se crean o eliminan archivos.
    3. Se registra un watchservice en el directorio dado, con el evento ENTRY_CREATE (es decir que escuche cuando se crea un nuevo archivo)
    4. Toma eventos de la key que está en espera
    5. Stream<List<WatchEvent>> Devuelve una lista de eventos para que puedan ser recorridos.
    6. Toma cada evento de la lista y obtiene el camino donde ocurrió el evento.
    7. Toma la ruta para detectar el tipo/extensión del archivo.
    8. Compara el tipo de archivo que se quiere detectar con el que se encontró anteriormente
    9. Si los tipos de archivo son iguales, muestra el mensaje.
  */
}

