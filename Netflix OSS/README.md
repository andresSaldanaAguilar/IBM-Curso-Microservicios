# Correr el proyecto 
Link al video del proyecto corriendo:
https://drive.google.com/open?id=1rd_KQ3KBVm7_lR0rLPsBVy6RXc2eaNja

# Correr el proyecto

1. Clonar el repositorio en tu computadora
2. Importar los proyectos maven dentro del directorio Netflix OSS en tu IDE (Eclipse, STS, VS Code)
3. Correr el comando Maven Clean
4. Correr el comando Maven Install
5. Correr primeramente 'EurekaServer' , ya que es el servicio de registro.
6. Correr secundariamente 'ZuulServer', que es el servicio que proveera el balanceo de cargas con Ribbon.
7. Correr el servidor de configuracion, que provee las propiedades compartidas por servicios
8. Correr el servicio REST

# Probar el proyecto

Para probar su funcionamiento, podemos hacer una peticion GET a la siguiente URI:

http://localhost:8762/escom-chistes-service/hello

