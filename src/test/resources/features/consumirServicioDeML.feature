#language: es
# Author: Matias S Famá

Característica: creacion cliente desde el servicio
  Yo como QA Automatizador
  Deseo interactuar con el servicio de Mercado Libre
  Para garantizar que funcione correctamente

  Escenario: El analista de calidad verifica la respuesta del servicio de Mercado Libre
    Dado el Analista desea consumir el servicio llamado 'departments'
    Entonces su status debe ser '200' y visualizar la pagina de 'departments'