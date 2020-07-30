[![Build Status](https://travis-ci.org/GEscandar/TP2-Kahoot.svg?branch=master)](https://travis-ci.org/GEscandar/TP2-Kahoot)
[![codecov](https://codecov.io/gh/GEscandar/TP2-Kahoot/branch/master/graph/badge.svg)](https://codecov.io/gh/GEscandar/TP2-Kahoot)


# TP2 Algoritmos 3: KAHOOT

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo 8

* **Integrante 1** - [German Escandar](https://github.com/GEscandar)
* **Integrante 2** - [Javier Zardain](https://github.com/Jaz05)
* **Integrante 3** - [Santiago Guerra](https://github.com/SantiG95)
* **Integrante 4** - [Miroslav Sapunar](https://github.com/MiroslavSapunar)
* **Integrante 5** - [Nicolas De Sousa](https://github.com/Nicodoxia)

Corrector: **{Diego}**

### Pre-requisitos

Listado de software/herramientas necesarias para el proyecto

```
java 11
maven 3.6.0
...
```

## Ejecutando las pruebas

```bash
    mvn test
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
    <browser> ./target/site/jacoco/index.html
```

## Ejecutando la aplicación

Se deberá ejecutar el siguiente comando dentro del directorio del proyecto:

```bash
	mvn javafx:run
```

## Diagramas

Diagrama de clases principal del proyecto:

<img src="https://github.com/GEscandar/TP2-Kahoot/blob/master/docs/out/diagramaClases-Principal-TP2/DiagramaUML-Clases-TP2.png?raw=true">

Para la clase abstracta ScoreAugmenter, se creó un diagrama de clases en detalle:

<img src="https://github.com/GEscandar/TP2-Kahoot/blob/master/docs/out/DiagramaUML-DetalleAugmentatio/DiagramaUML-DetalleAugmentation-TP2.png?raw=true">

Lo mismo para el detalle de la clase abstracta Question:

<img src="https://github.com/GEscandar/TP2-Kahoot/blob/master/docs/out/DiagramaClases-DetallePreguntas-TP2/DiagramaUML-DetallePreguntas-TP2.png?raw=true">

Diagrama de Secuencia para calculo de puntaje a un jugador:

<img src="https://github.com/GEscandar/TP2-Kahoot/blob/master/docs/out/DiagramaSecuencia-PreguntaT-F/Diagrama%20Secuencia%20TP2%20-%20Prueba%20para%20pregunta%20True%20False%20asignando%20puntaje%20a%20Jugador%20-%20Entrega%200.png?raw=true">

## Licencia

Este repositorio está bajo la Licencia MIT
