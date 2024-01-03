Feature: Buscar un correo en el Gmail


  Background:
    Given El usuario  esta registrado en Gmail
    When El usuario ingresa su correo electronico y le da en el boton siguinete
    And  El usuario ingresa su contrasenia y le da en siguiente
    Then El usuario se encuentra en la bandeja de entrada de su correo

  Scenario: buscar un correo de manera exitosa

    Given El usuario digital el correo que buscara
    When El usuario da click en el boton de buscar correo
    Then El usuario verifica el correo que busca