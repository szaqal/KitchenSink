        IDENTIFICATION DIVISION.
        Program-ID. Init.
      *  Author. Pawel.

      *Any data items that have VALUE clauses are initialized to the appropriate value at that time. 
        DATA DIVISION.
        WORKING-STORAGE SECTION.
        01 Test-String          PIC X(5) VALUE 'HELLO'.
        01 Test-Copy-To         PIC X(5).
        01 Test-Copy-To-Shorter PIC X(2).


        01 Employee.
            05 First-Name PIC X(15) VALUE 'FIRST-NAME'.
            05 Last-Name PIC X(15) VALUE 'LAST-NAME'.

        01 Employee-Display PIC X(20).

        PROCEDURE DIVISION.
            MOVE Test-String TO Test-Copy-To.
            MOVE Test-String TO Test-Copy-To-Shorter.                    TRANCATION HAPPENS
            DISPLAY Test-Copy-To.
            DISPLAY Test-Copy-To-Shorter.

            DISPLAY First-Name.                                          GLOBALLY ACCESSIBLE
            
            DISPLAY Employee.                                            DISPLAYS PADDED VALUES
            MOVE Employee TO Employee-Display.
            DISPLAY Employee-Display.                                    TRUNCATES VALUE ABOVE to Length                    
        STOP RUN.