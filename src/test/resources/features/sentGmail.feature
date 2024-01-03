Feature: Enviar un correo en Gmail

 Background:
  Given El usuario  esta registrado en Gmail
  When El usuario ingresa su correo electronico y le da en el boton siguinete
  And  El usuario ingresa su contrasenia y le da en siguiente
  Then El usuario se encuentra en la bandeja de entrada de su correo

  Scenario: Enviar un correo en Gmail de manera exitosa

    Given El usuario selecciona la opcion de redactar  en la bandeja de entrada
    When El usuario ingresa los destinatarios del correo con un asunto
    And El usuario diligencia el correo
    Then El usuario envia el mensaje
    And El usuario verifica que se envio el mensaje