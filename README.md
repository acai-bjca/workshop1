# Workshop1
## Git Basic Concepts
* What is the purpose of  **git add .** command?
    >Rta: El propósito de este comando es conservar los cambios realizados en un repositorio y prepararlos para la posterior confirmación.
* Why we used **git commit -m "Message"**?
    >Rta: Lo usamos para confirmar los cambios marcándolos con un mensaje y deja listos los cambios para ser subidos.
* What is the purpose of the **git push origin master** command?
    >Rta: Este comando sube al repositorio remoto los cambios confirmados anteriormente.
* What is the purpose of the **git clone 'repository'** command?
    >Rta: Este comando clona un repositorio remoto creando uno local.
* Screenshots Commits
	![](https://github.com/acai-bjca/workshop1/blob/master/Screenshot.PNG)
* What **git pull origin master** command does?
    >Rta: Este comando baja los cambios del repositorio remoto que no están actualizados en el repositorio local.
## Maven Basic Concepts
### Create Maven Project
* What do means the -B option in the command?
	>Muestra en un modo no interactivo es decir, muestra la información que está ejecutando de una forma plana.
* What do means the -D option in the command?
	>Define una propiedad del sistema, como por ejemplo groupId y artifactId.
* What do means the groupId, artifactId properties in the command?
	>**groupId:** Le da un identificador único al proyecto que normalmente se basa en la estructura que va a tener el proyecto.
	
    >**artifactId:** Es el nombre del archivo jar sin versión, en pocas palabras es el nombre real del proyecto.
* Describe the content of the directory that has been created.
	>Contiene una carpeta src la cuál incluye el proyecto como tal, es decir, las carpetas para los archivos y las pruebas. Además contiene un archivo pom, el cual se usa para hacer las configuraciones y ajustes del proyecto en cuanto a dependencias, plugins, propiedades, entre otros.
### POM file
* What do means the word SNAPSHOT in the version value?
	>Significa que es la versión de mvn que está por lanzarse y que está en tiempo de desarrollo.
* What is the purpose of the packing tag into the POM file?
	>Indica el tipo de archivo que se va a crear en el proyecto.
* What is the purpose of the dependencies and dependency tags into the POM file?
	>Permite traer proyectos ya existentes que son necesarios para que el proyecto se ejecute correctamente según lo que se necesite.
### Dependency Management
* What is the functionality of FileSpy class?
	>Esta clase hace una detección de archivos y de los cambios que les ocurre, de la siguiente manera: Define un tipo de archivo que se quiera detectar en una ruta (directorio) específica. Se genera una lista de eventos que se están escuchando en dicha ruta. Cada vez que se detectan eventos(cambios) verifica si los archivos encontrados son el mismo tipo de archivo que el definido y muestra un mensaje cada vez que encuentra uno.
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
    ![](https://github.com/acai-bjca/workshop1/blob/master/1-compile.PNG)
    >`mvn compile:` compila el código fuente del proyecto.
    >
    >`dependencias transitivas:` son dependencias que no se colocan en el POM, porque son arrastradas por otras dependencias que las necesitan.
* Using the terminal execute the command `mvn package`. Take the output screenshot. What is this command using for?
	![](https://github.com/acai-bjca/workshop1/blob/master/2-package.PNG)
	>`mvn package:` empaqueta el código compilado en el formato que se estableció, como un JAR
* Using the terminal execute the command `mvn install`. Take the output screenshot. What is this command using for?
	![](https://github.com/acai-bjca/workshop1/blob/master/3-install.PNG)
    >`mvn install:` instala el paquete en el repositorio local, para usarlo como una dependencia en otros proyectos a nivel local.
* Generate a new maven project in other folder using the maven command line tools, this project should has as groupId "edu.eci" and as artifactId "another-maven-project". Take the output screenshot.
    ![](https://github.com/acai-bjca/workshop1/blob/master/generandoNuevoProyecto.PNG)
* Replace the code of the App.java class with the following code and do all the necessary steps to compile the code.
	![](https://github.com/acai-bjca/workshop1/blob/master/1.2-compile.PNG)
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
	![](https://github.com/acai-bjca/workshop1/blob/master/ejecutando_FileSpy.PNG)  
* But this time you should knew that the application detect events in a folder when you add new files and print on the screen all the files with the `text/csv` extension. Test the application using the examples files. Take the output screenshot.
	![](https://github.com/acai-bjca/workshop1/blob/master/Probando_FileSpy.PNG)
***
##Bibliografía
* *Tutorialspoint. [Maven - Build Life Cycle]. Recuperado de https://codesjava.com/maven-clean-lifecycle-phases*

* *CódigosJava. [Fases De Ciclo De Vida Limpias De Maven]. Recuperado de https://codesjava.com/maven-clean-lifecycle-phases*
* *Stackoverrun. (2017, 18 enero). [¿Qué es una dependencia transitiva de Maven?]. Recuperado de https://stackoverrun.com/es/q/11481805*

* *Stackoverrun. (2013, 20 marzo). [Agregar el jar de otro proyecto como un recurso usando Maven]. Recuperado de https://stackoverrun.com/es/q/4212835*

***
**Amalia Inés Alfonso Campuzano**

**Carlos Andrés Medina Rivas**