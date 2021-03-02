
       IDENTIFICATION DIVISION.
       PROGRAM-ID. hello.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
      *Group number 01-49 
       01 GROUP-ONE.
      *Typically 05/10/15 etcc to make room for root level groups
           05 SOME-VALUE                  PIC X             VALUE "N".
       PROCEDURE DIVISION.
           DISPLAY "VALUE:"SOME-VALUE.
           STOP RUN.
