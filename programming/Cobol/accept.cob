
       IDENTIFICATION DIVISION.
       PROGRAM-ID. hello.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       77 SOME-VALUE                  PIC X             VALUE "N".
       PROCEDURE DIVISION.
           ACCEPT SOME-VALUE
           DISPLAY "VALUE:"SOME-VALUE.
           STOP RUN.
