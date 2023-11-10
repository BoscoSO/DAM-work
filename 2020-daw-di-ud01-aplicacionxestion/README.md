# Aplicación de xestión

Este repositorio almacenará a solución á práctica da aplicación de xestión. MODIFICACIÓN

## Especificacións

Crea unha aplicación Java que simule un xogo de memoria con, polo menos 8 cartas.


Repositorio para almacenar a aplicación de xestión de clientes ou de alumnado.
- A aplicación debe ter unha táboa onde se mostran datos.
- A táboa debe ter un modelo personalizado que estende o GenericDomainTableModel.
- A columna data da táboa debe mostrarse co formato dd-MM-yyyy.
- Deben poder modificarse as diferentes columnas da táboa.

## Explicación do repositorio

A estrutura da documentación é a seguinte:

```bash
.
├── doc
│   ├── README.md
│   └── Traballo.md
└── README.md
└── AplicacionXestion
```

Explicación da estrutura de ficheiros e directorios:

- README.md raiz: contén as instrucións da tarefa. **NON debe modificarse**.
- `doc`: aquí debes incluír calquera documentación que consideres necesaria.
- `AplicacionXestion`: proxecto NetBeans para a codificación da práctica. Ten un JFrame inicial chamado PantallaPrincipal (non cambies o seu nome).

## Documentación

Escribe a documentación en formato Markdown. Podes consultar a seguinte [Guía Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

Enlaza todos os ficheiros necesarios usando a sintaxe Markdown

Se inclúes imaxes, colócaas no directorio doc/imaxes.

## Instrucións

### Fork

Fai un fork do repositorio orixinal e configúrao de forma privada. Habilita as issues e outorga permisos á profesora.

### Clona o repositorio na túa máquina de traballo

`git clone <url do teu fork>`

### Crea a túa rama persoal de traballo ou release branch

Crea a túa propia rama de traballo.

Crea unha nova rama a partir de `master` que se chame como o teu login no curso (rb = release branch):

`git checkout -b <rb-login>`

Non traballes na rama master. Podes ter máis ramas no repositorio, pero a solución será entregada na rama `rb-login`.

### Revisa se se produciron actualizacións nas especificacións

Cada vez que retomes o teu traballo, asegúrate de ter a última versión das especificacións. Para iso:

1. (Só a primeira vez). Engade como remoto o repositorio da profesora dende o que fixeches o fork.
    - `git remote add profesora <urlRepositorioProfesora>`
2. (Cada vez que retomes o traballo). Revisa as novidades e descarga as actualizacións do repositorio da profesora.
    - `git fetch profesora master`
3. (Cada vez que haxa novidades). Fusiona as novidades coa túa rama `rb-login`. Non deberían producirse conflitos.
    - Asegúrate de estar na túa rama `rb-login`: `git checkout rb-login`
    - Inclúe na túa rama actual as novidades: `git merge profesora/master`