# language: es

Característica: Ingreso de usuario
  Como usuario
  Quiero iniciar session
  Para usar la pagina correspondiente


  Escenario: loguearse con usuario y contraseña valido
    Dado El usuario ingresa a la pagina de SauceDemo
    Cuando Completa con los datos
      | username      | password     |
      | standard_user | secret_sauce |
    Entonces debe visualizar un la pagina correspondiente

  Esquema del escenario: loguearse con los campos usuario y contraseña vacios
    Dado El usuario ingresa a la pagina de SauceDemo
    Cuando Completa con los datos
      | username   | password   |
      | <username> | <password> |
    Entonces debe visualizar cartel en rojo indicando el error correspondiente

    Ejemplos:

      | username      | password     |
      |               |              |
