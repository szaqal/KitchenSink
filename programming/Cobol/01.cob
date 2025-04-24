        IDENTIFICATION DIVISION.
        Program-ID. Init.
      *  Author. Pawel.

      *Any data items that have VALUE clauses are initialized to the appropriate value at that time. 
        DATA DIVISION.
        WORKING-STORAGE SECTION.
        01 Test-String PIC X(5) VALUE 'HELLO'.


        PROCEDURE DIVISION.
           DISPLAY Test-String.
           STOP RUN.