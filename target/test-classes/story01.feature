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
    When Hago click en el link contact us
    Then Ingreso a la pagina contact us