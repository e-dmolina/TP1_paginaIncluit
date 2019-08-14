Feature: Ver el numero de team members
  COMO usuario QUIERO entrar a las 4 pantallas y verificar sus caracteristicas principales

  Scenario: El numero de team members es 450
    Given Ingreso al sitio de Incluit
    When Hago click en el link why-incluit
    Then Veo que el número de team members es "450"

  Scenario: La pantalla what we do existe
    Given Ingreso al sitio de Incluit
    When Hago click en el link what we do
    Then Ingresa a la página what we do

  Scenario: En la pagina studios el studio Mobile existe
    Given Ingreso al sitio de Incluit
    When Hago click en el link studios
    Then El studio "MOBILE" existe

  Scenario: La pantalla contact us existe
    Given Ingreso al sitio de Incluit
    When Hago click en el link what we do
    And Hago click en el link contact us
    Then Ingreso a la pagina contact us

  Scenario: El formulario se envia y muestra un mensaje de confirmacion
    Given Me encuentro en la pagina de contact us
    When Ingreso el nombre "Cosme Fulanito"
    And El E-Mail "cosmefulanito@gmail.com"
    And Ingreso el subject "Este es un mensaje autogenerado"
    And Ingreso el mensaje "Este es un mensaje autogenerado de prueba para el trabajo practico de automatizacion."
    And Hago click en el boton SEND
    Then Se envia el formulario y muestra el texto "Thank you for your message. We will be in touch with you soon!"
    When Hago click en home
    Then Ingresa a la pagina home
