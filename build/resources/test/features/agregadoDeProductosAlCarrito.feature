# language: es

Característica: Ingreso de usuario
  Como usuario
  Quiero iniciar session
  Para usar la pagina correspondiente

  Antecedentes: loguearse con usuario y contraseña valido
    Dado El usuario ingresa a la pagina de SauceDemo
    Cuando Completa con los datos
      | username     | password     |
      | problem_user | secret_sauce |
    Entonces debe visualizar un la pagina correspondiente

  Escenario: Visualizacion de la palabra Remover luego de hacer click en el boton de añadir al carrito
    Cuando Añado el producto Sauce Labs Backpack con el boton al carrito
    Entonces Se visualiza la palabra Remove en color rojo

  #Caso de prueba para falla intencional
  Escenario: Agregar Sauce Labs Backpack al carrito por titulo
    Dado Selecciona Sauce Labs Backpack por titulo
    Cuando Añado producto Al carrito
    Entonces debe visualizar el elemento correspondiente
