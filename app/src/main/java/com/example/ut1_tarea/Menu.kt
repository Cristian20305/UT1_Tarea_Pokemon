package com.example.ut1_tarea

//Clase Entrenador
data class Entrenador(val nombre:String,val apellido:String,val numEntrenador:Int){

}
//Interfaz Imprimible, metodo de devolver para que los pokemons devuelvan informacion en forma de cadena
interface Imprimible{

    fun devolverInfoString():String

}
//Clase abstracta Pokemon implementamos de Imprimible
abstract class Pokemon(val id:String,val tipo:String,val nivelActual:Int,val entrenador: Entrenador):Imprimible{


}
//Subclase Comun
class Comun(id: String, tipo: String, nivelActual: Int, val objetosEquipos:List<String>, entrenador: Entrenador):Pokemon(id, tipo, nivelActual, entrenador){

    override fun devolverInfoString(): String {
        return  "ID: $id, Tipo $tipo, Nivel $nivelActual, Objetos $objetosEquipos, Obejtos equipados ${objetosEquipos.toString()}, Entrenador: ${entrenador.nombre}, ${entrenador.apellido}, Numero Entrenador ${entrenador.numEntrenador} "
    }

}
//Subclase Especial
class Especial(id: String, tipo: String, nivelActual: Int,entrenador: Entrenador,val poderCombateAdicional:String) :Pokemon(id, tipo, nivelActual,entrenador){

    override fun devolverInfoString():String {
        return "ID: $id, Tipo: $tipo, Nivel: $nivelActual, Poder de Combate Adicional: $poderCombateAdicional, Entrenador: ${entrenador.nombre}, ${entrenador.apellido}, Numero Entrenador ${entrenador.numEntrenador} "
    }

}
//Subclase Legendario
class Legenderio(id: String, tipo: String, nivelActual: Int, entrenador: Entrenador ,val ataqueEspecial:String,val habilidadOculta:String) :Pokemon(id, tipo, nivelActual,entrenador){

    override fun devolverInfoString():String {
        return "ID: $id, Tipo: $tipo, Nivel: $nivelActual, Ataque Especial: $ataqueEspecial, Habilidad Oculta: $habilidadOculta, Entrenador: ${entrenador.nombre}, ${entrenador.apellido}, Numero Entrenador ${entrenador.numEntrenador}"

    }

}
//Clase PokemonCenter para gestionar la lista de Pokemon y de mas operaciones
class PokemonCenter{

    private val  pokemons= mutableListOf<Pokemon>()

    // Metodo para registrar un nuevo Pokemon
    fun registrarPokemon(pokemon: Pokemon):Boolean {

        //Si tenemos un hueco en la lista añadidos un nuevo Pokemon
        return if (pokemons.size<100){
            pokemons.add(pokemon)
            true
        } else{
            println("No se pueden resgistrar más Pokemon. Has alcanzado el limite.")
            false
        }


    }
    //Metodo para obetner un listado de pokemon
    fun listadoPokemon():List<String>{



    }
    // Metodo para obtener información detallada de un Pokemon
    fun informacionPokemon(id: String):String{

    }
    // Metodo para incrementar el nivel de un Pokemon
    fun incrementarNivel(id: String, cantidad:Int):Boolean {

    }
    // Metodo para disminuir el nivel de un Pokemon
    fun disminuirNivel(id: String,cantidad: Int):Boolean{

    }
    // Metodo para consultar el nivel actual de un Pokemon
    fun consultarNivel(id: String): Int{

    }


}

fun main(){

    val pokemonCenter=PokemonCenter()

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
            //Llamar a los metodos de pokemonCenter mas los datos que añadamos
            1->pokemonCenter.registrarPokemon()
            2->pokemonCenter.listadoPokemon()
            3->{
                println("Dime el nombre (ID) del Pokemon que buscas")

            }
            4->{}
            5->{}
            6->{}
            7-> println("Saliendo de la aplicacion. !Vuelve luego¡")
        }

    } while (opcion!=7)


}