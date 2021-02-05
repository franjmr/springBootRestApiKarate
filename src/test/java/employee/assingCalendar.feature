@assingEmployeeCalendar
Feature: Assign

	@assingEmployeeCalendarSuccess
  Scenario: Assign Employee Calendar success
    Given url 'http://localhost:9057/api/v1/employeeCalendar/assign'
    And request {PCodigoEmpleado:'M11234',PFechaInicio:'01/01/2020',PFechaFin:'28/01/2020',PCalendario1:'1',PCalendario2:'2',PCalendario3:'3',PSecuencia:1,PSCodigoError:'',PSDescripcionError:''}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Sin error","PSCodigoError":"0"}
    
  @assingEmployeeCalendarWithoutEmployeeCode  
  Scenario: Assign Employee Calendar without employee code
    Given url 'http://localhost:9057/api/v1/employeeCalendar/assign'
    And request {PFechaInicio:'01/01/2020',PFechaFin:'28/01/2020',PCalendario1:'1',PCalendario2:'2',PCalendario3:'3',PSecuencia:1,PSCodigoError:'',PSDescripcionError:''}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Código de empleado nulo","PSCodigoError":"1"}
  
  @assingEmployeeCalendarWithoutFirstCalendar  
  Scenario: Assign Employee Calendar without first calendar
    Given url 'http://localhost:9057/api/v1/employeeCalendar/assign'
    And request {PCodigoEmpleado:'M11234',PFechaInicio:'01/01/2020',PFechaFin:'28/01/2020',PCalendario2:'2',PCalendario3:'3',PSecuencia:1,PSCodigoError:'',PSDescripcionError:''}
    When method POST
    Then status 200
    And match $ == {"PSDescripcionError":"Calendario #1 nulo","PSCodigoError":"8"}