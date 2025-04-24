        IDENTIFICATION DIVISION.
        Program-ID. Init.
      *  Author. Pawel.

        DATA DIVISION.
        WORKING-STORAGE SECTION.

        01 Employee PIC X(10).
        01 EmployeeData REDEFINES Employee.
            05 FirstName PIC X(5).
            05 LastName PIC X(5).


        PROCEDURE DIVISION.
            MOVE 'First' TO FirstName.
            MOVE 'Last' TO LastName.

            DISPLAY "EMP:"Employee.

            DISPLAY "F:"FirstName.
            DISPLAY "L:"LastName.

            MOVE 'AAAAAAA' TO Employee.
            DISPLAY "F:"FirstName.
            DISPLAY "L:"LastName.    

        STOP RUN.    
