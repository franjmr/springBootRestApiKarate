@updateEmployeeContacts
Feature: UpdateEmployeeContacts

	@updateEmployeeContactsSuccess
  Scenario: Update Employee Contacts success
    Given url 'http://localhost:9057/api/v1/employeeContact/update'
    And request {"PCodigoEmpleado":"M11234","PTelefonoFijo":"999999999","PTelefonoMovil":"6666666666","PEMail":"email@email.com","PTipoDomicilio":"9","PCodigoDomicilio":"999","PSCodigoError":"","PSDescripcionError":""}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Sin error","PSCodigoError":"0"}
    
  @updateEmployeeContactsEmptyEmployeeCode
  Scenario: Update Employee Contacts with empty employee code
    Given url 'http://localhost:9057/api/v1/employeeContact/update'
    And request {"PCodigoEmpleado":"","PTelefonoFijo":"999999999","PTelefonoMovil":"6666666666","PEMail":"email@email.com","PTipoDomicilio":"9","PCodigoDomicilio":"999","PSCodigoError":"","PSDescripcionError":""}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Código de empleado nulo","PSCodigoError":"1"}
    
  @updateEmployeeContactsIncorrectlyFormattedDate
  Scenario: Update Employee Contacts with incorrectly formatted date
    Given url 'http://localhost:9057/api/v1/employeeContact/update'
    And request {"PCodigoEmpleado":"","PTelefonoFijo":"999999999","PTelefonoMovil":"6666666666","PEMail":"email@email.com","PTipoDomicilio":"9","PCodigoDomicilio":"999","PSCodigoError":"","PSDescripcionError":""}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Código de empleado nulo","PSCodigoError":"1"}
    
  @updateEmployeeContactsAddressRelatedFields
  Scenario: Update Employee Contacts with address related fields
    Given url 'http://localhost:9057/api/v1/employeeContact/update'
    And request {"PCodigoEmpleado":"M11234","PTelefonoFijo":"999999999","PTelefonoMovil":"6666666666","PEMail":"email@email.com","PTipoDomicilio":"9","PCodigoDomicilio":"","PSCodigoError":"","PSDescripcionError":""}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Deben informarse ambos o ninguno de los datos de domicilio","PSCodigoError":"9"}