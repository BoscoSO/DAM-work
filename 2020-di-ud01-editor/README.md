# Editor

A clase `JTextComponent` é a base dos compoñentes de texto de Swing. Esta clase proporciona as seguintes características:

* Un modelo, `document`, que xestiona o contido do compoñente. O documento almacena o contido textual en obxectos `Element`.
* A vista, que mostra en pantalla o compoñente.
* Un controlador, `editor kit`, que le e escribe texto e implementa mecanismos de edición mediante [`actions`](https://docs.oracle.com/javase/tutorial/uiswing/misc/action.html).
* Soporte para realizar accións de desfacer e refacer.
* Información para saber onde está colocado o cursor (`caret`) e `change listeners` para o mesmo.

[Máis información](https://docs.oracle.com/javase/tutorial/uiswing/components/generaltext.html).

**NOTA**: JTextPane necesita que o `document` usado sexa un `StyledDocument`.

## Especificacións

Crea unha aplicación Java Swing que simule un editor de texto.

A aplicación debe ter un Text Pane onde se visualizará o texto.

Engade á aplicación un menú e unha barra de ferramentas coas utilidades para:

* Abrir un ficheiro de texto e visualizalo no editor.
* Cambiar o estilo do texto: grosa, cursiva e subliñado.
* Engade tamén un botón para cambiar a cor da letra usando un JColorChooser.

## Explicación do repositorio

A estrutura do repositorio é a seguinte:

```bash
.
├── doc
│   └── README.md
├── README.md
└── editor
    └── src
        └── editor
            └── gui
```

Explicación da estrutura de ficheiros e directorios:

* `README.md` raíz: contén as instrucións da tarefa. **NON debe modificarse**.
* `doc`: aquí debes incluír calquera documentación que consideres necesaria.
* `editor`: proxecto NetBeans para a codificación da práctica. Ten un JFrame inicial chamado PantallaPrincipal (non cambies o seu nome).

    Paquetes:

* `gui`: conterá os JFrames e demáis ventás das que estará composta a aplicación.

## Documentación

Escribe a documentación en formato Markdown. Podes consultar a seguinte [Guía Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

Enlaza todos os ficheiros necesarios usando a sintaxe Markdown

Se inclúes imaxes, colócaas no directorio doc/imaxes.

## Instrucións

### Fork

Fai un fork do repositorio orixinal e configúrao de forma privada.

Outorga permisos de developer á profesora (usuario cparis-fp) no teu repositorio.

### Clona o repositorio na túa máquina de traballo

`git clone <url do teu fork>`

### Crea a túa rama persoal de traballo ou release branch

Crea a túa propia rama de traballo.

Crea unha nova rama a partir de `master` que se chame como o teu login no curso (rb = release branch):

`git checkout -b <rb-login>`

Se o que queres é descargar a túa rama do repositorio remoto debes executar o comando:

`git checkout -b <rb-login> origin/<rb-login>`

**NOTAS**:

* Para crear a nova rama debes estar no directorio do repositorio.
* Non traballes na rama master. Podes ter máis ramas no repositorio, pero a solución será entregada na rama `rb-login`.

### Revisa se se produciron actualizacións nas especificacións

Cada vez que retomes o teu traballo, asegúrate de ter a última versión das especificacións. Para iso:

1. (Só a primeira vez). Engade como remoto o repositorio da profesora dende o que fixeches o fork.
    * `git remote add profesora <urlRepositorioProfesora>`
2. (Cada vez que retomes o traballo). Revisa as novidades e descarga as actualizacións do repositorio da profesora.
    * `git fetch profesora master`
3. (Cada vez que haxa novidades). Fusiona as novidades coa túa rama `rb-login`. Non deberían producirse conflitos.
    * Asegúrate de estar na túa rama `rb-login`: `git checkout <rb-login>`
    * Inclúe na túa rama actual as novidades: `git merge profesora/master`
4. (Cada vez que finalices a sesión de traballo). Sube a nova versión do proxecto ao repositorio.
    * `git add --all`
    * `git commit -m "mensaxe"`
    * `git push origin <rb-login>`
