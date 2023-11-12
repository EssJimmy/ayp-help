# Tres diferentes formas de importar una dependencia en Python
import pandas as pd  # importando la libreria entera
from matplotlib import pyplot as plt  # importando un paquete solo
# import matplotlib.pyplot as plt   otra forma de hacerlo


def conditionals(number: int):
    if number < 10:  # if sirve para verificar condiciones, y por ende son llamados condicionales
        print('Es menor que 10')
    elif number == 10:  # elif sirve en dado caso que la condicion de if no se haya cumplido, pero queremos comparar
        # otra cosa
        print('Es igual a 10')
    else:  # else es el ultimo pedazo, si ya no queda ninguna accion disponible, entramos aqui
        print('Es mayor que 10')


# definimos que la funcion recibe un float como parametro y regresa una tupla
def operators(number: float) -> tuple:

    suma = number + 10  # suma sencilla
    resta = number - 10  # resta sencilla
    mult = number*10  # multiplicacion sencilla
    div = number/10  # division sencilla
    mod = number % 10  # el operador % (modulo) se encarga de sacar el residuo de la divison

    return suma, resta, mult, div, mod


# definicion de una funcion generica
def mi_funcion(parametros):  # python usa su notacion con guiones para mejor legibilidad
    x = parametros + 10

    return x


def main():
    print("Hello world!")  # imprime valores a la consola
    print('Hello again!')  # no importa si usamos comillas dobles o sencillas

    x = mi_funcion(10)  # llamada a la funcion creada y la guardamos en una variable
    print(x)  # imprimimos el valor que guardamos en la variable
    print(operators(10))


# las tres comillas se utilizan para un comentario multilinea
"""
    Tipos de variables en Python:
        str    -    Cadenas de texto
        int    -    Numeros enteros
        float  -    Numeros decimales
        bool   -    Comparaciones logicas (verdadero o falso)
"""


if __name__ == '__main__':
    main()
