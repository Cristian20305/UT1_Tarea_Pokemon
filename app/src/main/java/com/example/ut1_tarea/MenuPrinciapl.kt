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

        val opcion=try {
            readln().toInt()
        } catch (e:NumberFormatException){
            println("ERROR. Debes introducir un numero comprendido entre 1 y 7.")
            -1
        }
        // Validamos que la opción este en el rango de 1 a 7
        if (opcion !in 1..7) {

            //Opcion fuera del rango y no es -1 error de formato se muestra un mensaje
            if (opcion != -1) {
                println("Opcion no valida. Intentalo de nuevo con un numero dentro del ranro 1 y 7")
            }
            //Necestimaos el continue para que vuelva al principio del do while sin ejecutar el resto del codigo
            continue
        }

        when(opcion){
            //Llamar a los metodos de pokemonCenter mas los datos que añadamos

            //Registramos un nuevo Pokemon
            1->pokemonCenter.registrarNuevoPokemon()
            2->{
                //Listado de todos los Pokemon que tenemos en memorias
                val listado=pokemonCenter.listadoPokemon()
                //Validacion, si por casualidad esta vacio mostramos mensaje de error
                if (listado.isEmpty()){
                    println("Listado de Pokemon registrados vacio ")
                }else{
                    //Si hay registrados los mostramos
                    println("Listado de Pokemon registrados: ")
                    //Sobre listado recorremos todo los elemetos y los vamos imprimiendo cada uno
                    listado.forEach { println(it) }
                }

            }
            3->{
                //Informacion de un Pokemon por ID
                println("Dime el nombre (ID PXXXX) del Pokemon que buscas")
                val id= readln()
                val info=pokemonCenter.informacionPokemon(id)
                // Si la variable "info" no es nula, mostramos su informacion
                // Guardamos la informacion en una variable y luego la imprimimos
                if (info!=null){
                    println("Informacion detallada del Pokemon")
                    println(info)
                }else{
                    //Si el id esta mal introducido, mostramos mensaje de que no se ha encontrado a nadie con ese ID
                    println("No se encontro ningun Pokemon con el ID introducido")
                }

            }
            4->{
                //Incremntar Nivel
                println("Dime el ID (PXXXX) del Pokemon que deseas incrementar el nivel ")
                val id= readln()
                println("¿Cuanto deseas incrementar el nivel ?")
                val cantidad= readln().toInt()
                val resultado=pokemonCenter.incrementarNivel(id, cantidad)
                // Si resultado es verdadero, incrementamos el nivel del Pokemon correspondiente
                if (resultado){
                    println("El nivel del Pokémon con ID $id fue incrementado en $cantidad ")
                }else{
                    // Si resultado es falso, significa que el ID introducido no es valido
                    println("No se encontro ningun Pokemon con el $id introducido")
                }
            }
            5->{
                //Disminuir nivel de Pokemon
                println("Dime el ID (PXXXX) del Pokemon que deseas disminuir el nivel ")
                val id= readln()
                println("¿Cuanto deseas disminuir el nivel ?")
                val cantidad= readln().toInt()
                val resultado=pokemonCenter.disminuirNivel(id, cantidad)
                // Si resultado es verdadero, disminuimos el nivel del Pokemon correspondiente
                if (resultado){
                    println("El nivel del Pokémon con ID $id fue disminuido en $cantidad ")
                }else{
                    // Si resultado es falso, significa que el ID introducido no es valido o que el nivel es mas bajo de 1
                    println("No se puede disminuir el nivel. Verifica que el ID sea correcto y que el nivel no baje de 1")
                }

            }
            6->{
                //Consultar nivel Pokemon por ID
                println("Dime el ID (PXXXX) del pokemon para consultar su nivel")
                val id= readln()
                // Consultamos el nivel del Pokemon utilizando el ID proporcionado.
                val nivel=pokemonCenter.consultarNivel(id)
                // Verificamos si el nivel es valido (diferente de -1)
                if (nivel!=-1){
                    // Si el nivel es valido, mostramos el nivel del Pokemon
                    println("El nivel del Pokemon con ID $id es: $nivel")
                }else{
                    // Si el nivel es -1, significa que no se encontra un Pokémon con ese ID.
                    println("No se encontro ningun Pokemon con el ID introducido $id")
                }
            }
            //Salimos de la aplicacion
            7-> println("Saliendo de la aplicacion. !Vuelve luego¡")
        }

    } while (opcion!=7)


}