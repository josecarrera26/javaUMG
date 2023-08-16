# javaUMG
Java UMG 2023 2
Sincronizar repositorio, paso a paso
  1. crear una carpeta local
  2. click derecho dentro de la carpeta y seleccionar git bash here
  3. escribir los siguientes comandos en la consola:
  4. git init
  4. git add .
  5. git commit -m "fisrt commit"
  6. si solicita configurar correo y usuario:
     git config --global user.email "escribaaquisucorreo@correo.com"
     git config --global user.name "escribir nombre"
     escribir nuevamente el comando 5  
  8. git branch -m main
  9. git remote -v
  10. git remote add origin https://github.com/josecarrera26/javaUMG.git
  11. si solicita iniciar sesion en el navegaro, iniciar sesion en el navegador
  13. git remote -v

Publicar nueva version del software
Luego de sincronizar el repositorio remoto y hacer cambios en el codigo del programa, se deben ejecutar los siguientes comandos en la consola de git bash:
  1. git satus
  2. git add .
  3. git commit -m "comentario con detalles de lo que se implemento"
  4. git push 

Solicitar ultima version del software
antes de empezar algun cambio en el codigo, devemos ejecutar el comando en la consola de git bash:
  1. git pull

Clonar repositorio para integrantes del equipo
  1. git clone
  2. realizar un cambio comentado en el archivo que contiene el metodo main y guardarlo.
  3. git add .
  4. git commit -m "mensaje"
  5. git push
