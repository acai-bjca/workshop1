# Workshop1
1. What is the purpose of  **git add .** command?
Rta: El propósito de este comando es conservar los cambios realizados en un repositorio y prepararlos para la posterior confirmación.
2. Why we used **git commit -m "Message"**?
Rta: Lo usamos para confirmar los cambios marcándolos con un mensaje y deja listos los cambios para ser subidos.
3. What is the purpose of the **git push origin master** command?
Rta: Este comando sube al repositorio remoto los cambios confirmados anteriormente.
4. What is the purpose of the **git clone repository** command?
Rta: Este comando clona un repositorio remoto creando uno local.
5. What **git pull origin master** command does?
Rta: Este comando baja los cambios del repositorio remoto que no están actualizados en el repositorio local.

### Imagen de los commits
![enter image description here](https://github.com/acai-bjca/workshop1/blob/master/Screenshot.PNG)

# Workshop2
1. What do means the -B option in the command?
	Muestra en un modo no interactivo es decir, muestra la información que está ejecutando de una forma plana.
2. What do means the -D option in the command?
Define una propiedad del sistema, como por ejemplo groupId y artifactId.
3. What do means the groupId, artifactId properties in the command?
groupId: Le da un identificador único al proyecto que normalmente se basa en la estructura que va a tener el proyecto.
artifactId: Es el nombre del archivo jar sin versión, en pocas palabras es el nombre real del proyecto.
4. Describe the content of the directory that has been created.
Contiene una carpeta src la cuál incluye el proyecto como tal, es decir, las carpetas para los archivos y las pruebas. Además contiene un archivo pom, el cual se usa para hacer las configuraciones y ajustes del proyecto en cuanto a dependencias, plugins, propiedades, entre otros.
5. What do means the word SNAPSHOT in the version value?
Significa que es la versión de mvn que está por lanzarse y que está en tiempo de desarrollo.
6. What is the purpose of the packing tag into the POM file?
Indica el tipo de archivo que se va a crear en el proyecto.
7. What is the purpose of the dependencies and dependency tags into the POM file?
Permite traer proyectos ya existentes que son necesarios para que el proyecto se ejecute correctamente según lo que se necesite.

8. What is the functionality of FileSpy class?