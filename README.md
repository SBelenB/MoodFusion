# Aplicación de Registro de Pacientes 🏥
## Descripción del Proyecto
CRUD diseñado para el registro de pacientes en un centro médico. Permite almacenar nombre, apellido y número de teléfono del paciente, buscar los datos asociados a los números de id de paciente y modificar el registro o eliminarlo.

## Lenguaje utilizado
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)


### Pre-requisitos 📋

Antes de poder ejecutar la aplicación necesitás una base de datos local configurada, para ello debes tener instalado MySQL en tu máquina y un administrador de bases de datos como <b><a href="https://dev.mysql.com/downloads/workbench/">_MySQL Workbench_</a></b>

### Creación de la base de datos

Ejecuta el siguiente comando SQL

```sql
CREATE DATABASE IF NOT EXISTS pacientes;
USE pacientes;
```

### Creación de tabla

```sql
CREATE TABLE paciente (
id int Primary key,
nombre varchar(50),
telefono varchar(20)
);
```

Opcionalmente podés agregar datos de ejemplo a la tabla

```sql
INSERT INTO paciente (id, nombre, telefono) VALUES
  (1001, 'Juan Pérez', '123-456-7890'),
  (1002, 'María Rodríguez', '987-654-3210'),
  (1003, 'Carlos Gómez', '555-123-4567'),
  (1004, 'Ana Martínez', '111-222-3333'),
  (1005, 'Roberto Sánchez', '444-555-6666'),
  (1006, 'Laura González', '777-888-9999'),
  (1007, 'Pedro Ramírez', '999-888-7777'),
  (1008, 'Isabel Flores', '666-555-4444');
```

## Ejecución

Clona el repositorio desde la línea de comandos

```bash
cd Desktop
git clone https://github.com/SBelenB/CRUDRegistroDePacientes.git
```

### Compilación con Maven

1. Compila e instala dependencias
```bash
mvn clean install
```

2. Ejecuta la aplicación
```bash
mvn exec:java
```

### Compilación desde IDE

1. Realizá un Clean & Build sobre el proyecto.

2. Ejecuta el proyecto con la opción Run.

## Capturas de pantalla 🚀

![image](https://i.imgur.com/7EBtFhs.png)
