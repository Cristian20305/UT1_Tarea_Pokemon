package com.example.ut1_tarea

fun main(){

    val  pokemons= mutableListOf<String>()
    val maximoPokemons=100 //maximo de registro 100 pokemons

    println("BIENVENIDO A GESTION POKEMON")


    do {

        println("********************")
        println("1. Registrar un nuevo Pokemon")
        println("2. Listado de Pokemon (ID,Nombre,Pokemon)")
        println("3. Obtener informacion detallada de un Pokemon")
        println("4. Incrementar el nivel de un Pokemon")
        println("5. Diminuir el nivel de un Pokemon")
        println("6. Consultar el nivel actual de un Pokemon")
        println("7. Salir de la aplicacion")

        println("Selecciones una opción: ")

        val opcion= readln().toInt()
        if (opcion !in 1..7){
            println("Opción no válida. Inténtalo de nuevo ")
        }

        when(opcion){
            1->{}
            2->{}
            3->{}
            4->{}
            5->{}
            6->{}
            7-> println("Saliendo de la aplicacion. !Vuelve luego¡")
        }

    } while (opcion!=7)


}
//Clase Entrenador
data class Entrenador(val nombre:String,val apellido:String,val numEntrenador:Int){

}
//Interfaz Imprimible
interface Imprimible{

}
//Clase abstracta Pokemon
abstract class Pokemon(val id:String,val tipo:String,val nivelActual:Int,val entrenador: Entrenador):Imprimible{


}
//Subclase Comun
class Comun(id: String, tipo: String, nivelActual: Int, val objetosEquipos:List<String>, entrenador: Entrenador):Pokemon(id, tipo, nivelActual, entrenador){


}
//Subclase Especial
class Especial(id: String, tipo: String, nivelActual: Int,entrenador: Entrenador,val poderCombateAdicional:String) :Pokemon(id, tipo, nivelActual,entrenador){

}
//Subclase Legendario
class Legenderio(id: String, tipo: String, nivelActual: Int, entrenador: Entrenador ,val ataqueEspecial:String,val habilidadOculta:String) :Pokemon(id, tipo, nivelActual,entrenador){


}
//Clase PokemonManager para gestionar la lista de Pokemon
class PokemonManager{

}