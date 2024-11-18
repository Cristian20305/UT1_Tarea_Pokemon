package com.example.ut1_tarea

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

        println("Seleccione una opción: ")

        val opcion= readln().toInt()
        if (opcion !in 1..7){
            println("Opción no válida. Inténtalo de nuevo ")
        }

        when(opcion){
            //Llamar a los metodos de pokemonCenter mas los datos que añadamos
            1->pokemonCenter.registrarNuevoPokemon()
            2->{
                val listado=pokemonCenter.listadoPokemon()
                if (listado.isEmpty()){
                    println("Listado de Pokemon registrados vacio ")
                }else{
                    println("Listado de Pokemon registrados: ")
                    listado.forEach { println(it) }
                }

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
            4->{
                println("Dime el ID (PXXXX) del Pokemon que deseas incrementar el nivel ")
                val id= readln()
                println("¿Cuanto deseas incrementar el nivel ?")
                val cantidad= readln().toInt()
                val resultado=pokemonCenter.incrementarNivel(id, cantidad)
                if (resultado){
                    println("El nivel del Pokémon con ID $id fue incrementado en $cantidad ")
                }else{
                    println("No se encontro ningun Pokemon con el $id introducido")
                }
            }
            5->{
                println("Dime el ID (PXXXX) del Pokemon que deseas disminuir el nivel ")
                val id= readln()
                println("¿Cuanto deseas disminuir el nivel ?")
                val cantidad= readln().toInt()
                val resultado=pokemonCenter.disminuirNivel(id, cantidad)
                if (resultado){
                    println("El nivel del Pokémon con ID $id fue disminuido en $cantidad ")
                }else{
                    println("No se puede disminuir el nivel. Verifica que el ID sea correcto y que el nivel no baje de 1")
                }

            }
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