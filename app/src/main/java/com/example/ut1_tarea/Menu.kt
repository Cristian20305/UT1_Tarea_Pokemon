package com.example.ut1_tarea

//Clase Entrenador
data class Entrenador(val nombre:String,val apellido:String,val numEntrenador:Int){

}
//Interfaz Imprimible, metodo de devolver para que los pokemons devuelvan informacion en forma de cadena
interface Imprimible{

    fun devolverInfoString():String

}
//Clase abstracta Pokemon implementamos de Imprimible
abstract class Pokemon(val id:String,val tipo:String,val nivelActual:Int,val entrenador: Entrenador,val nombrePokemon:String):Imprimible{


}
//Subclase Comun
class Comun(id: String, tipo: String, nivelActual: Int, val objetosEquipos: List<String>, entrenador: Entrenador,nombrePokemon: String)
    :Pokemon(id,tipo, nivelActual, entrenador,nombrePokemon){

    override fun devolverInfoString(): String {
        return  "ID: $id, Tipo $tipo, Nivel $nivelActual, Objetos $objetosEquipos, Obejtos equipados ${objetosEquipos.toString()}, Entrenador: ${entrenador.nombre}, ${entrenador.apellido}, Numero Entrenador ${entrenador.numEntrenador} "
    }

}
//Subclase Especial
class Especial(id: String, tipo: String, nivelActual: Int,entrenador: Entrenador,val poderCombateAdicional:String,nombrePokemon: String)
    :Pokemon(id, tipo, nivelActual,entrenador,nombrePokemon){

    override fun devolverInfoString():String {
        return "ID: $id, Tipo: $tipo, Nivel: $nivelActual, Poder de Combate Adicional: $poderCombateAdicional, Entrenador: ${entrenador.nombre}, ${entrenador.apellido}, Numero Entrenador ${entrenador.numEntrenador} "
    }

}
//Subclase Legendario
class Legenderio(id: String, tipo: String, nivelActual: Int, entrenador: Entrenador ,val ataqueEspecial:String,val habilidadOculta:String,nombrePokemon: String)
    :Pokemon(id, tipo, nivelActual,entrenador,nombrePokemon){

    override fun devolverInfoString():String {
        return "ID: $id, Tipo: $tipo, Nivel: $nivelActual, Ataque Especial: $ataqueEspecial, Habilidad Oculta: $habilidadOculta, Entrenador: ${entrenador.nombre}, ${entrenador.apellido}, Numero Entrenador ${entrenador.numEntrenador}"

    }

}
//Clase PokemonCenter para gestionar la lista de Pokemon y de mas operaciones
class PokemonCenter{

    private val  pokemons= mutableListOf<Pokemon>()

    // Metodo para registrar un nuevo Pokemon
    fun registrarNuevoPokemon(){

        //Si se detecta el pokemon mas de 100 no se pueden ingresar mas
        if(pokemons.size>=100){
            println("No se pueden registrar mas pokemon")
            return
        }
        //Datos del entrenador para Introducir
        println("Ingrese los datos del Entrenador: ")
        println("Nombre: ")
        val nombre= readln()

        println("Apellido: ")
        val apellido= readln()

        println("Numero de Entrenador: ")
        val numEntrenador= readln().toInt()
        //Llamamos a la funcion entrenador y sus atributos
        val entrenador=Entrenador(nombre,apellido,numEntrenador)

        //Datos del Pokemon para introducir
        println("Ingrese el ID del Pokemon (formato PXXXX): ")
        val id= readln()
        //• ID único del Pokémon, el cual se validará mediante una expresión regular con el formato PXXXX,
        //donde X representa un dígito (del 0 al 9).

        println("Ingrese el nombre del Pokemon: ")
        val nombrePokemon= readln()

        println("Tipo de Pokemon (fuego ,agua ,planta ,etc. )")
        val tipo= readln()

        println("Ingrese el nivel Actual de su Pokemon: ")
        val nivelActual= readln().toInt()

        //Un when (swicth) para selecionar el tipo de pokemons que es. Cada uno tiene un poder, objeto, ataque diferente
        println("Tipo de Pokemon: 1. Comun 2.Especial 3.Legendario")
        val tipoPokemon= readln()
        val pokemon=when(tipoPokemon){

            1.toString() ->{
                println("Ingrese los objetos equipados (separados por comas)")
                val objetosEquipos= readln().split(",")
                Comun(id,tipo,nivelActual,objetosEquipos,entrenador,nombrePokemon)

            }
            2.toString() -> {
                println("Ingrese el poder de comabate adicional: ")
                val poderCombateAdicional= readln()
                Especial(id,tipo,nivelActual,entrenador,poderCombateAdicional,nombrePokemon)
            }
            3.toString() ->{
                println("Ingrese el ataque especial: ")
                val ataqueEspecial= readln()
                println("Ingrese la habilidad oculta: ")
                val habilidadOculta= readln()
                Legenderio(id, tipo, nivelActual, entrenador, ataqueEspecial, habilidadOculta,nombrePokemon)
            }

            else -> {
                println("Tipo de Pokemon no valido")
                return
            }
        }
        if (registrarPokemon(pokemon)){
            println("Pokemon registrado correctamente")
        }else println("Error al registrar el Pokemon")

    }

    fun registrarPokemon(pokemon: Pokemon):Boolean {

        //Si tenemos un hueco en la lista añadidos un nuevo Pokemon, luego lo llamamos en nuevo pokemon
        return if (pokemons.size<100){
            pokemons.add(pokemon)
            true
        } else{
            println("No se pueden resgistrar más Pokemon. Has alcanzado el limite.")
            false
        }


    }
    //Metodo para obetner un listado de pokemon en forma de un array de cadenas
    fun listadoPokemon():Array<String>{

        //Creamos otra lista mutable para alamacenar la informacion basica de cada pokemon
        val lista= mutableListOf<String>()

        for (pokemon in pokemons){
            lista.add("ID: ${pokemon.id}, Nombre ${pokemon.nombrePokemon} , Tipo ${pokemon.tipo}, Nivel: ${pokemon.nivelActual}")
        }
        //Convertir la lista mutable a un array y devolverlo
        return lista.toTypedArray()

    }
    // Metodo para obtener información detallada de un Pokemon como cadena, o null si el pokemon no existe
    fun informacionPokemon(id: String): String? {

        //Recorremos la lista de pokemon
        for (pokemon in pokemons){
            //Verificamos si el id coincide con el que introducimos
            if (pokemon.id ==id){
                //Si coincide devolvemos toda su informacion
                return pokemon.devolverInfoString()
            }
        }
        //Si no existe devolvemos null
        return null

    }
//    // Metodo para incrementar el nivel de un Pokemon
//    fun incrementarNivel(id: String, cantidad:Int):Boolean {
//
//    }
//    // Metodo para disminuir el nivel de un Pokemon
//    fun disminuirNivel(id: String,cantidad: Int):Boolean{
//
//    }
    // Metodo para consultar el nivel actual de un Pokemon
    fun consultarNivel(id: String): Int{

        //Recorremos la lista de pokemon
        for (pokemon in pokemons){
            //Verificamos si el id coincide con el que introducimos
            if (pokemon.id==id){

                //Si coincide devolvemos el nivel actual del Pokemon se lo encontramos
                 return pokemon.nivelActual
            }

        }
        //Si no lo encontramos el Pokemon, devolvemos -1
        return -1

    }


}

fun main(){

    val pokemonCenter=PokemonCenter()

    println("BIENVENIDO A GESTION POKEMON")


    do {

        println("********************")
        println("1. Registrar un nuevo Pokemon")
        println("2. Listado de los Pokemon resgistrados (ID,Nombre,Pokemon)")
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
            1->pokemonCenter.registrarNuevoPokemon()
            2->{val listado=pokemonCenter.listadoPokemon()
                println("Listado de Pokemon registrados:")
                listado.forEach { println(it) }
            }
            3->{
                println("Dime el nombre (ID PXXXX) del Pokemon que buscas")
                val id= readln()
                val info=pokemonCenter.informacionPokemon(id)
                if (info!=null){
                    println("Informacion detallada del Pokemon")
                    println(info)
                }else{
                    println("No se encontro ningun Pokemon con el ID introducido")
                }

            }
            4->{}
            5->{}
            6->{
                println("Dime el ID (PXXXX) del pokemon para consultar su nivel")
                val id= readln()
                val nivel=pokemonCenter.consultarNivel(id)
                if (nivel!=-1){
                    println("El nivel del Pokemon con ID $id es: $nivel")
                }else{
                    println("No se encontro ningun Pokemon con el ID introducido $id")
                }
            }
            7-> println("Saliendo de la aplicacion. !Vuelve luego¡")
        }

    } while (opcion!=7)


}