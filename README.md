# Introducción a GitHub

Buenas :), soy Jimmy, y si estás aquí es por tres razones:

1. Estás en HCA y no le entiendes a que están haciendo.
2. Estás en AYP y no le entiendes a que están haciendo.
3. Estás en cualquiera de las dos anteriores y le entiendes, pero te da flojera el programarlo tu mismo y viniste a copiartelo.

Este repositorio fue creado como ayuda para las personas de estas materias, y tiene código hecho en Java, Python y en C/C++, pero creí que era una buena idea el enseñar a utilizar a los nuevos ingenieros o científicos de datos, una herramienta tan importante como Git y Github.
## Table of contents
- - [¿Qué es Git?](#qu%C3%A9-es-git)
  - [¿Qué es GitHub?](#qu%C3%A9-es-github)

- [Pasos para obtener este repositorio en tu computadora](#pasos-para-obtener-este-repositorio-en-tu-computadora)

  - [Instalar Git](#instalar-git)

    - [Windows](#windows)

    - [Mac](#mac)

    - [Linux](#linux)

      - [Ubuntu/Debian](#ubuntudebian)
      - [Fedora](#fedora)
      - [Cent OS](#cent-os)
      - [Arch](#arch)
      - [Gentoo](#gentoo)

  - [Verificar la instalación de Git](#verificar-la-instalaci%C3%B3n-de-git)

  - [Crear una cuenta en GitHub](#crear-una-cuenta-en-github)

  - [Clonar el repositorio con la rama que quieres](#clonar-el-repositorio-con-la-rama-que-quieres)

## ¿Qué es Git?
Git es un sistema de control de versiones decentralizado, se escucha muy rimbombante y todo, pero lo que hace es mantener un historial del código para si hay alguna falla catastrófica en la implementación de un método, puedas recuperar tu trabajo desde un punto de guardado, es como darle a guardar en un videojuego.

## ¿Qué es GitHub?
GitHub es una compañía actualmente propiedad de Microsoft, y es la forja de código más grande del mundo, GitHub es quien guarda todo el código que estás viendo en este repositorio, y a pesar que existen otras alternativas, GitHub es la opción más popular. Podemos pensar en GitHub como un disco duro enorme, y Git es el sistema que maneja este disco duro.

# Pasos para obtener este repositorio en tu computadora

## Instalar Git
Primero tienes que instalar Git antes de poder clonar el repositorio a tu máquina

### Windows
Si utilizas Windows, puedes buscar en internet el instalador o dirigirte a la siguiente [página](https://git-scm.com/download/win).

Te va a dar muchas opciones de instalación, por favor utiliza todas las recomendadas o, si no están recomendadas, las que estén por default, por favor no actives nada que sea experimental, a menos que quieras investigar lo que hacen.


### Mac
La forma más sencilla de obtener paquetes en Mac es utilizando `homebrew`, que funciona como los diferentes manejadores de paquetes en Linux. Para instalar `homebrew` sigue estos pasos:

1. Abre `Terminal` en tu Mac, si te deja hacerlo como administrador, aún mejor.
2. Copia el siguiente comando y pegalo en tu terminal: `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
3. Aparecerá texto en tu Terminal pidiendo que le des autorización con tu contraseña, te dirá que está a punto de instalar varios directorios y que presiones una tecla, normalmente es <kbd>Return</kbd>.

Después de que hayas instalado `homebrew` y completado todos los pasos puedes correr el siguiente comando para instalar Git: `brew install git`, otra vez te va a pedir autorización de instalar más cosas, dile que sí.

### Linux
Si estás utilizando Linux, muy probablemente ya conoces Git y sabes lo que haces, pero por cualquier cosa aquí dejo las instalaciones para diferentes distros:

#### Ubuntu/Debian

```bash
sudo apt-get update
sudo apt-get install git
```

#### Fedora

```bash
sudo dnf install git
```

#### Cent OS

```bash
sudo yum install git
```

#### Arch

```bash
sudo pacman -Sy git
```

#### Gentoo

```bash
sudo emerge --ask --verbose dev-vcs/git
```

## Verificar la instalación de Git
Después de haber instalado git, para verificar que esté correctamente instalado vamos a ingresar el comando `git` en la terminal, debería mostrar el menú de ayuda con los comandos posibles, en dado caso que muestre que el comando `git` no existe, tenemos un problema y tienes que revisar la instalación de Git.


## Crear una cuenta en GitHub
Puedes crear una cuenta gratis en GitHub, además con tu correo institucional del ITAM tienes acceso a GitHub Pro gratis, cuando te estás registrando te debería de dar la opción para hacerlo y no te tomará más de 10 minutos el hacerlo. Recuerda, GitHub es una empresa de Microsoft, por lo que tu información no está siendo enviada a alguien que no la tiene ya ;).

## Clonar el repositorio con la rama que quieres
Cuando hablamos de clonar un repositorio, hablamos de, mediante la terminal obtener la información que se encuentra en este repositorio, si clonamos todo el repositorio, va a incluir el código en todos los lenguajes, por lo que solo queremos clonar una rama específica, podríamos decir que las ramas son las divisiones de los repositorios.

Primero, utiliza la terminal para moverte a la carpeta deseada, si estás en Linux/Mac puedes utilizar el comando `ls` para ver que carpetas están en ese directorio, si estás en Windows, puedes utilizar `dir` para lo mismo. Para cambiar de carpeta puedes utilizar `cd` seguido del directorio al que te quieres mover, en mi caso iré a la carpeta *documentos*

```bash
cd Documents
```

Para clonar una rama específica, utilizamos el siguiente comando

```bash
git clone --branch <branch-name> --single-branch <git-url>

# también puedes utilizar
git clone -b <branch-name> --single-branch <git-url>
```

donde en `<branch-name>`  es el nombre de la rama a copiar y `<git-url>` es la URL de la página en donde estás, por favor no incluyas `<>` cuando reemplaces los valores. Muy probablemente te pida que hagas login con tus credenciales de GitHub, ingresa el usuario y contraseña que acabas de crear en el anterior paso, ten cuidado de mayúsculas y minúsculas, ya que también aplican para el usuario. Al clonar un repositorio, se nos creará una carpeta automáticamente con el nombre del repositorio, por lo que no necesitas crear una.

¡Felicidades :)! Ahora tienes toda la información del repositorio en tu computadora, y lo puedes abrir con cualquier editor de texto o IDE que quieras, happy hacking :)!


