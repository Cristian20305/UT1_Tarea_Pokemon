Proyecto de pokemon en kotlin aqui se explicara la tarea mas detallamente.

1º Diagrama de flujo de datos hecho y subido como foto

2º Explicacion del funcionamineto del codigo a continuacion:

# Introducción
Este programa está basado en Pokemon y permite al usuario interactuar con un entrenador, capturar Pokemon, gestionar un equipo y hasta poner habilidades a ciertos Pokemon. Todo está organizado de forma sencilla para que el menú principal guíe al usuario por las distintas opciones disponibles.

En este informe te explico cómo se ha diseñado el programa, por qué se ha estructurado así, y las decisiones importantes que he tomado para que funcione correctamente.

# Informe del Desarrollo de la Aplicación

## **Estructura del Programa**

El programa tiene varias clases y una interfaz que son el núcleo de todo. A continuación, se explican las principales:

### **Clases de Pokémon**

#### **`Pokemon` (Clase abstracta):**
- Es la base de todos los Pokémon del programa. Aquí están los atributos y métodos comunes, como:
  - `nombre`
  - `id`
  - `tipo`
  - `nivelActual`
- Como es abstracta, tiene un método `devolverInfoString()` que cada tipo de Pokémon tiene que implementar. Esto permite que cada tipo tenga su propia información acorde a sus datos y características específicas: **Común**, **Especial** y **Legendario**.

#### **Clases específicas de Pokémon:**
1. **`Comun`:**  
   - Son los Pokémon más básicos.  
   - Contienen una lista de objetos equipados como atributo propio.  
   - Sobrescriben el método `devolverInfoString()` para mostrar su información específica.  
   
2. **`Especial`:**  
   - Son más avanzados y tienen un poder de combate adicional.  
   - Sobrescriben el método `devolverInfoString()` para mostrar su información específica.  

3. **`Legendario`:**  
   - Son los mejores del programa, con habilidades únicas como:
     - Un ataque especial.
     - Habilidad oculta propia.  
   - Sobrescriben el método `devolverInfoString()` para mostrar su información específica.  

---

### **Entrenador**

El `Entrenador` es el encargado de gestionar la introducción de un Pokémon. Sus características principales son:
- Tiene un `nombre` y un `número de entrenador` específico.
- Permite realizar diversas acciones relacionadas con los Pokémon:
  - Añadir Pokémon.
  - Listar todos los Pokémon con su información detallada.
  - Obtener información de un Pokémon en concreto.
  - Incrementar el nivel de un Pokémon.
  - Disminuir el nivel de un Pokémon.
  - Consultar el nivel actual de un Pokémon.

---

### **PokemonCenter**

Este simula un Centro Pokémon y es responsable de:
- Gestionar todas las acciones relacionadas con:
  - Registrar un nuevo Pokémon.
  - Ver datos de Pokémon.
  - Realizar validaciones para evitar errores al introducir datos.
- Almacenar todos los Pokémon en una lista, que se utiliza para atender las solicitudes del programa principal.
- Proporcionar métodos que buscan en la lista para resolver las peticiones del usuario.

---

### **Interfaz**

#### **`Imprimible`:**
- Esta interfaz define el método `devolverInfoString()`.
- Es útil para imprimir información detallada, principalmente de los Pokémon.
- **¿Por qué usar una interfaz?**  
  Porque es más flexible que la herencia. Otras clases, aunque no estén relacionadas directamente con `Pokemon`, también pueden implementar este método para mostrar información.

---

### **Menú Principal**

El menú es el punto de entrada al programa y permite realizar las siguientes acciones:
1. Capturar un Pokémon y añadirlo al entrenador.
2. Listar todos los Pokémon que están disponibles.
3. Obtener información detallada de un Pokémon.
4. Aumentar el nivel de un Pokémon en concreto.
5. Disminuir el nivel de un Pokémon en concreto.
6. Consultar el nivel actual de un Pokémon.
7. Salir del programa.

- El menú está diseñado para ser sencillo y fácil de usar.  
- Todas las operaciones se realizan a través del `PokemonCenter`, que guarda los datos en una lista y valida los formatos para evitar errores.

---

## **Decisiones Importantes**

1. **Clase Abstracta para Pokémon:**  
   Usar una clase abstracta permite definir una base común para todos los Pokémon. Las clases específicas (`Comun`, `Especial`, `Legendario`) se enfocan únicamente en lo que las hace diferentes.

2. **Diseño Modular:**  
   Separar el código en clases específicas facilita su mantenimiento. Cada clase tiene una responsabilidad clara:
   - Pokémon están organizados en una jerarquía.
   - El `Entrenador` y el `PokemonCenter` tienen funciones específicas bien definidas.

3. **Uso de la Interfaz:**  
   La interfaz `Imprimible` proporciona flexibilidad al no depender de la herencia directa. Esto permite que cualquier clase pueda mostrar información implementando el método `devolverInfoString()`.

4. **Interactividad del Menú:**  
   El menú está diseñado para ser claro y directo. Permite navegar entre las opciones y realizar acciones sin complicaciones, siempre validando los datos introducidos para evitar errores.

---

## **Conclusión**

El programa está diseñado para ser fácil de usar, extensible y cumplir con el objetivo de simular una experiencia simple y entretenida basada en Pokémon.  
El uso de conceptos como **herencia**, **polimorfismo** y **abstracción** no solo hace que el código sea más limpio, sino también más fácil de mantener y ampliar en el futuro si es necesario.

