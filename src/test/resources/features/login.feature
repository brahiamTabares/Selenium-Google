Feature: Iniciar sesion en el Gmail

  Scenario: Iniciar sesion en Gmail exitosamente

    Given El usuario  esta registrado en Gmail
    When El usuario ingresa su correo electronico y le da en el boton siguinete
     And  El usuario ingresa su contrasenia y le da en siguiente
     Then El usuario se encuentra en la bandeja de entrada de su correo







