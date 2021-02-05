@updateEmployeeWorkShift
Feature: UpdateEmployeeContacts

	@updateEmployeeWorkShiftSuccess
  Scenario: Update Employee Work Shift success
    Given url 'http://localhost:9057/api/v1/employeeWorkshift/update'
    And request {"PCodigoEmpleado":"M11234","PFechaInicio":"01/01/2020","PFechaFin":"28/01/2020","PTurno":"2","PSCodigoError":"","PSDescripcionError":""}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Sin error","PSCodigoError":"0"}
        
  @updateEmployeeWorkShiftSuccessIncorrectlyFormattedDate
  Scenario: Update Employee Work Shift success with incorrectly formatted date
    Given url 'http://localhost:9057/api/v1/employeeWorkshift/update'
    And request {"PCodigoEmpleado":"M11234","PFechaInicio":"01/01/2020","PFechaFin":"01/2020","PTurno":"2","PSCodigoError":"","PSDescripcionError":""}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Fecha de finalización con formato (DD/MM/AAAA) inadecuado","PSCodigoError":"6"}