# Caso2-Poo


#Link al modelo de las estructra del programa: https://miro.com/app/board/uXjVOgZtKnc=/


#La simulación del yate se basa principalmente en la clase "Constanes" que se encuentra en el paquete "Yate" en donde se pueden realizar diversos cambios, desde la velocidad de consumo de energia, la velocidad en que las baterias se cargan, la duración total de la simulación, la velocidad maxima del yate, entre otras; estas estan instanciadas con el respectivo nombre de la acción para evitar confuciones.

#En la clase main es donde se ejecuta el programa, en este se derivan algunos hilos "Threads" para tener en cuenta el tiempo transcurrido en la simulación y que incluso se consuma la bateria mientras se realizan otras accinoes, esto en una clase hilo llamada consumo.

#Las clases se encuentran en el archivo "src", siendo Yate el paquete donde se encuentra la clase main.
