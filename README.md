# Laboratorio 1 - Git y Maven
## Git Basic Concepts
### Setup
- Descargar git (en este caso usamos el de windows) desde [https://gitforwindows.org/](https://gitforwindows.org/)

	![](/Imágenes/DescargarGit.PNG)

- En seguida realizamos la instalación.

	![](/Imágenes/InstalaciónGit1.PNG)
	![](/Imágenes/InstalaciónGit2.PNG)

- Verificamos que se haya instalado correctamente

	![](/Imágenes/VerificaciónGit.PNG)
### Creating a local repository
- Create a folder.

	![](/Imágenes/CrearFolder.PNG)
- Using the command line to  go to the folder created in the previous step.

	![](/Imágenes/IrFolder.PNG)
- Use **git init** command to create a new local repository

	![](/Imágenes/GitInit.PNG)
### Let's  code
- Using your favorite IDE, create a new java project using the folder you have created previously as Workspace

	![](/Imágenes/CreandoJavaProyecto1.PNG)
	![](/Imágenes/CreandoJavaProyecto2.PNG)
- Solve the **Java Anagrams** problem using java

```java
	import java.util.Scanner;

	public class Java_Anagrams {
    
		public static String[] separateWords(String w) {
	        String[] words = new String[w.length()];
	        for (int i = 0; i<w.length(); i++) words[i] = ""+w.charAt(i);
	        return words;
	    }

	    public static String[] ordenar(String[] w) {
	        String temp = "";
	        boolean restart = false;
	        int correctPosition = 0, i = 0, j = 0;
	        while (i<w.length) {
	            for(j = correctPosition; j<w.length && !restart; j++) {
	                if (i != j && w[i].compareTo(w[j]) > 0){
	                    temp = w[i];
	                    w[i] = w[j];
	                    w[j] = temp;
	                    restart = true;
	                }
	            }
	            if (restart) {
	            	restart = false;
	                i = correctPosition;
	            }
	            else {
	            	i += 1;
	            	if (j==w.length) correctPosition = i;
	            }            
	        }
	        return w;
	    }
	
	    public static int coundWords(String letter, String[] word) {
	    	int cant = 0;
	    	for(int i = 0; i<word.length; i++) {
	    		if (word[i].equals(letter)) cant += 1;
	    	}
	    	return cant;
	    }
	
	    public static boolean isAnagram(String a, String b) {
	        boolean answer = false;    
	        String[] w1 = separateWords(a.toLowerCase());
	        w1 = ordenar(w1);
	        String[] w2 = separateWords(b.toLowerCase());
	        w2 = ordenar(w2);
	        if (a.length() == b.length()) {
	        	String letter = "";
	        	boolean has = true;
	        	int cant1 = 0, cant2 = 0;
	        	for(int i = 0; i<w1.length && has; i++) {
	        		letter = w1[i];
	        		cant1 = coundWords(letter, w1);
	        		cant2 = coundWords(letter, w2);
	        		if (cant1 != cant2) has = false;
	        	}
	        	if (has) answer = true;
	        }        
	        return answer;
	    }

        public static void main(String[] args) {	    
	        Scanner scan = new Scanner(System.in);
	        String a = scan.next();
	        String b = scan.next();
	        scan.close();
	        boolean ret = isAnagram(a, b);
	        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    	}
    }
```

El ejercicio pasó en HackerRank

![](/Imágenes/Anagrams.PNG)
### Preserving our changes
* What is the purpose of  **git add .** command?

	![](/Imágenes/GitAdd.PNG)
    >Rta: El propósito de este comando es conservar los cambios realizados en un repositorio y prepararlos para la posterior confirmación.
* Why we used **git commit -m "Message"**?

	![](/Imágenes/GitCommit.PNG)
    >Rta: Lo usamos para confirmar los cambios marcándolos con un mensaje y deja listos los cambios para ser subidos.
### Using Github
Ambos miembros del equipo ya contabamos con un usuario en Github.
Unimos el repositorio local al remoto mediante **git remote add origin server**
 
![](/Imágenes/UnirRepositorio.PNG)

* What is the purpose of the **git push origin master** command?

	![](/Imágenes/GitPushOrigin.PNG)
    >Rta: Este comando sube al repositorio remoto los cambios confirmados anteriormente.
### Cloning our repository
* What is the purpose of the **git clone 'repository'** command?

	![](/Imágenes/GitClone.PNG)
    >Rta: Este comando clona un repositorio remoto creando uno local.
### Let's code
```java 
	import java.util.Scanner;

	public class ReadLines {

		public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);
			
			String line = "";
			int count = 0;
			while (scan.hasNext()) {
				line = scan.nextLine();
				count += 1;
				System.out.println(count+" "+line);
			}
			
			scan.close();
		}
    }
```

El ejercicio pasó en HackerRank

![](/Imágenes/ReadLines.PNG)

* Screenshots Commits

	![](/Imágenes/Screenshot.PNG)
* What **git pull origin master** command does?

	![](/Imágenes/GitPullOrigin.PNG)
    >Rta: Este comando baja los cambios del repositorio remoto que no están actualizados en el repositorio local.

## Maven Basic Concepts
### Install Maven
- Para instalar Maven (en este caso usamos el de windows) entramos a [https://maven.apache.org/install.html](https://maven.apache.org/install.html)

	![](/Imágenes/InstalarMaven.PNG)
- Verificamos que se haya instalado

	![](/Imágenes/VerificaciónMaven.PNG)
### Create Maven Project
* Create a new maven project using the command **mvn archetype:generate -B -DgroupId=edu.eci -DartifactId=file-spy**
	
	![](/Imágenes/CreandoProyectoMVN1.PNG)

	Para verificar que la estructura quedó correcta, miramos el árbol del proyecto

	![](/Imágenes/ArbolFileSpy.PNG)
* What do means the -B option in the command?
	>Muestra en un modo no interactivo es decir, muestra la información que está ejecutando de una forma plana.
* What do means the -D option in the command?
	>Define una propiedad del sistema, como por ejemplo groupId y artifactId.
* What do means the groupId, artifactId properties in the command?
	>**groupId:** Le da un identificador único al proyecto que normalmente se basa en la estructura que va a tener el proyecto.
	
    >**artifactId:** Es el nombre del archivo jar sin versión, en pocas palabras es el nombre real del proyecto.
* Describe the content of the directory that has been created.
	>Contiene una carpeta src la cuál incluye el proyecto como tal, es decir, las carpetas para los archivos y las pruebas. Además contiene un archivo pom, el cual se usa para hacer las configuraciones y ajustes del proyecto en cuanto a dependencias, plugins, propiedades, entre otros. En inicio, contiene dos carpetas dentro del src, main y test, cada una con la estructura definida y con una clase App prefedinida.
* Create the folders `src/main/resources` and `src/test/resources`

	![](/Imágenes/ArbolFileSpy-Resources.PNG)
### POM file
```xml
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	  <modelVersion>4.0.0</modelVersion>
	  <groupId>edu.eci</groupId>
	  <artifactId>file-spy</artifactId>
	  <packaging>jar</packaging>
	  <version>1.0-SNAPSHOT</version>
	  <name>file-spy</name>
	  <url>http://maven.apache.org</url>
	  <dependencies>
	    <dependency>
	      <groupId>junit</groupId>
	      <artifactId>junit</artifactId>
	      <version>3.8.1</version>
	      <scope>test</scope>
	    </dependency>
		<dependency>
			<groupId>org.apache.tika</groupId>
			<artifactId>tika-core</artifactId>
			<version>1.20</version>
		</dependency>
	  </dependencies>
	  <build>
	    <plugins>
	        <plugin>
	            <groupId>org.apache.maven.plugins</groupId>
	            <artifactId>maven-compiler-plugin</artifactId>
	            <configuration>
	                <source>1.8</source>
	                <target>1.8</target>
	            </configuration>
	        </plugin>
	    </plugins>
	  </build>
	</project>
```

* What do means the word SNAPSHOT in the version value?
	>Significa que es la versión de mvn que está por lanzarse y que está en tiempo de desarrollo.
* What is the purpose of the packing tag into the POM file?
	>Indica el tipo de archivo que se va a crear en el proyecto.
* What is the purpose of the dependencies and dependency tags into the POM file?
	>Permite traer proyectos ya existentes que son necesarios para que el proyecto se ejecute correctamente según lo que se necesite.
### Dependency Management
* What is the functionality of FileSpy class?
	>Esta clase hace una detección de archivos y de los cambios que les ocurre, de la siguiente manera: Define un tipo de archivo que se quiera detectar en una ruta (directorio) específica. Se genera una lista de eventos que se están escuchando en dicha ruta. Cada vez que se detectan eventos(cambios) verifica si los archivos encontrados son el mismo tipo de archivo que el definido y muestra un mensaje cada vez que encuentra uno (cuando se crea).
### Building Lifecycles and Plugins
* The three principal Maven lifecycles are `clean`, `default`and `site`. Describe each one.
    >**clean:**  Este ciclo de vida maneja la limpieza del proyecto y se compone de tres fases. 
    >`pre-clean:` ejecuta los procesos necesarios antes de la limpieza real del proyecto.
    >
    >`clean:` elimina todos los archivos generados por la compilación anterior.
    >
    >`post-clean:` ejecuta los procesos necesarios para finalizar el proyecto de limpieza.
    ***
    > **default:**  Este ciclo de vida maneja el despliegue del proyecto y se compone de las siguientes fases:
	>`validate:` valida si el proyecto es correcto o no, y si se encuentra toda la información que se necesita. 
	>
	>`compile:` compila el código fuente del proyecto.
	>
	>`test:` prueba el código fuente que ya fue compilado.
	>
	>`package:` empaqueta el código compilado en el formato que se estableció, como un JAR.
	>
	>`integration-test:` procesa y despliega el paquete en un entorno donde se puedan ejecutar pruebas de integración.
	>
	>`verify:`verifica que el paquete es válido y que cumple con los criterios de calidad.
	>
	>`install:` instala el paquete en el repositorio local, para usarlo como una dependencia en otros proyectos a nivel local.
	>
	>`deploy:` se realiza en un entorno de integración y copia el paquete final en el repositorio remoto para compartirlo con otros desarrolladores y proyectos.
	***
	> **site:**    Maneja todo lo relacionado con la documentación del proyecto.
	>`pre-site:` ejecuta los procesos necesarios para la generación del sitio del proyecto.
	>
	>`site:` genera la documentación del sitio del proyecto.
	>
	>`post-site:` ejecuta los procesos necesarios para finalizar la generación del sitio y prepara la implementación del mismo.
	>
	>`site-deploy:` implementa la documentación del sitio generado en un servidor web específico.

* Using the terminal execute the command `mvn compile`. Take the output screenshot. What is this command using for? What are transitive dependencies?

    ![](/Imágenes/1-compile.PNG)
    >`mvn compile:` compila el código fuente del proyecto.
    >
    >`dependencias transitivas:` son dependencias que no se colocan en el POM, porque son arrastradas por otras dependencias que las necesitan.
* Using the terminal execute the command `mvn package`. Take the output screenshot. What is this command using for?

	![](/Imágenes/2-package.PNG)
	>`mvn package:` empaqueta el código compilado en el formato que se estableció, como un JAR
* Using the terminal execute the command `mvn install`. Take the output screenshot. What is this command using for?

	![](/Imágenes/3-install.PNG)
    >`mvn install:` instala el paquete en el repositorio local, para usarlo como una dependencia en otros proyectos a nivel local.
* Generate a new maven project in other folder using the maven command line tools, this project should has as groupId "edu.eci" and as artifactId "another-maven-project". Take the output screenshot.

    ![](/Imágenes/generandoNuevoProyecto.PNG)
* Replace the code of the App.java class with the following code and do all the necessary steps to compile the code.

	![](/Imágenes/1.2-compile.PNG)
	>Para que el nuevo proyecto lograra compilar agregamos la siguiente dependencia al POM del proyecto
	>
	```html
		<dependency> 
		  <groupId>edu.eci</groupId> 
		  <artifactId>file-spy</artifactId> 
		  <version>1.0-SNAPSHOT</version> 
		</dependency>
	```
	>
	>En este caso como necesitamos un proyecto ya existente, las dependencias son ideales pues estas hacen uso del jar de otros proyectos y los busca y baja automáticamente
* Use the following command to execute the file-spy application `mvn exec:java -Dexec.mainClass="edu.eci.FileSpy"`. Take the output screenshot.
	
	![](/Imágenes/ejecutando_FileSpy.PNG)  
* But this time you should knew that the application detect events in a folder when you add new files and print on the screen all the files with the `text/csv` extension. Test the application using the examples files. Take the output screenshot.

	![](/Imágenes/Probando_FileSpy.PNG)
## Bibliografía
* *Tutorialspoint. [Maven - Build Life Cycle]. Recuperado de https://codesjava.com/maven-clean-lifecycle-phases*

* *CódigosJava. [Fases De Ciclo De Vida Limpias De Maven]. Recuperado de https://codesjava.com/maven-clean-lifecycle-phases*
* *Stackoverrun. (2017, 18 enero). [¿Qué es una dependencia transitiva de Maven?]. Recuperado de https://stackoverrun.com/es/q/11481805*

* *Stackoverrun. (2013, 20 marzo). [Agregar el jar de otro proyecto como un recurso usando Maven]. Recuperado de https://stackoverrun.com/es/q/4212835*

***
**Autores:**

- *Amalia Inés Alfonso Campuzano*

- *Carlos Andrés Medina Rivas*
