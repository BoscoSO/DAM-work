# StudentsDB-v2

Este repositorio almacenará a solución á versión 2 da práctica da aplicación que permite xestionar os datos da base de datos de estudantes.

Nesta versión pídese usar como modelo de datos da táboa o [Generic Domain Table Model](https://mestre.iessanclemente.net/pluginfile.php/41248/mod_resource/content/1/GenericDomainTableModel.java) que vimos en clase.

## Especificacións

Crea unha aplicación Java que permita xestionar os datos de estudiantes almacenados na base de datos.

A base de datos almacena unha táboa co **DNI**, **nome**, **apelidos** e **idade** dos estudantes.

A aplicación conterá unha pantalla principal que mostrará un JTable e catro botóns (Alta, Baixa, Edición e Saír) correctamente distribuídos.

Cada vez que se inicie a aplicación deben mostrarse no **JTable** os datos almacenados na base de datos. Debes utilizar como modelo de datos o **DefaultTableModel**.

Cando se pulse o botón **Alta**, abrirase un diálogo modal para solicitar os datos do novo estudante a inserir na base de datos. Este diálogo conterá dous botóns: **Aceptar** e **Cancelar**. No caso de pulsar o botón **Aceptar**, a base de datos e o JTable actualizaranse e no caso de pulsar o botón **Cancelar** non.

O botón **Baixa** permitirá dar de baixa o estudante seleccionado na táboa. Se non hai ningúnha fila seleccionada na táboa, mostrarase unha mensaxe informativa. Se hai algunha fila seleccionada pedirase a confirmación da acción a realizar. No caso de confirmala, o estudante eliminarase da base de datos e do JTable.

O botón **Edición** permitirá modificar os datos do estudante seleccionado na táboa. Igual que no caso anterior, se non hai ningunha fila seleccionada, mostrarase unha mensaxe informativa. En caso contrario, abrirase unha nova ventá modal que conteña un  formulario cuberto cos datos actuais do estudante, permitindo á persoa usuaria da apliación modificar tales datos. O formulario conterá dous botóns (**Aceptar** e **Cancelar**) que permitirán gardar ou descartar os cambios. No caso de pulsar o botón **Aceptar**, deben actualizarse os datos na base de datos e no **JTable**.

Ao pulsar o botón **Saír** a aplicación pedirá confirmación para finalizar, o que fará en caso afirmativo.

Sempre que se produza algún erro, debe mostrarse por pantalla unha mensaxe de aviso dando información do ocorrido.

Debes implementar a aplicación de tal forma que cando se realice unha actualización da base de datos, os cambios tamén se vexan reflectidos no **JTable**.

Ao usar un modelo de datos xenérico para a táboa, fai que o editor da columna idade sexa apropiado para o tipo de datos numérico.

Cada vez que se actualicen os datos na táboa, deben actualizarse tamén na base de datos.

Retos adicionais:

- Engade á táboa a funcionalidade de ordenación por columna.

## Explicación do repositorio

A estrutura do repositorio é a seguinte:

```bash
.
├── doc
│   └── README.md
└── README.md
└── studentsDB-v2
    └── baseDatos
    └── src
        └── studentsDB
            ├── dto
            ├── gui
            ├── loxica
            └── sql
```

Explicación da estrutura de ficheiros e directorios:

- `README.md` raiz: contén as instrucións da tarefa. **NON debe modificarse**.
- `doc`: aquí debes incluír calquera documentación que consideres necesaria.
- `studentsDB-v2`: proxecto NetBeans para a codificación da práctica. Ten un JFrame inicial chamado PantallaPrincipal (non cambies o seu nome).
- `studentsDB-v2/baseDtatos`: directorio para almacenar os datos da base de datos.

    Paquetes:

  - `dto`: conterá a clase Student.java coas propiedades para almacenar os valores da base de datos, constructor, getters, setters, un método toArray e un método toString.
  - `gui`: conterá os JFrames e demáis ventás das que estará composta a aplicación.
  - `loxica`: conterá a clase Loxica.java que implementa todos os métodos que realizan operacións coa base de datos.
  - `sql`: contén o ficheiro co código sql necesario para a creación de táboas da aplicación.

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

- Para crear a nova rama debes estar no directorio do repositorio.
- Non traballes na rama master. Podes ter máis ramas no repositorio, pero a solución será entregada na rama `rb-login`.

### Revisa se se produciron actualizacións nas especificacións

Cada vez que retomes o teu traballo, asegúrate de ter a última versión das especificacións. Para iso:

1. (Só a primeira vez). Engade como remoto o repositorio da profesora dende o que fixeches o fork.
    - `git remote add profesora <urlRepositorioProfesora>`
2. (Cada vez que retomes o traballo). Revisa as novidades e descarga as actualizacións do repositorio da profesora.
    - `git fetch profesora master`
3. (Cada vez que haxa novidades). Fusiona as novidades coa túa rama `rb-login`. Non deberían producirse conflitos.
    - Asegúrate de estar na túa rama `rb-login`: `git checkout <rb-login>`
    - Inclúe na túa rama actual as novidades: `git merge profesora/master`
4. (Cada vez que finalices a sesión de traballo). Sube a nova versión do proxecto ao repositorio.
    - `git add --all`
    - `git commit -m "mensaxe"`
    - `git push origin <rb-login>`
