
       IDENTIFICATION DIVISION.
       PROGRAM-ID. hello.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       77 SOME-VALUE                  PIC X(30)             VALUE "N".
       77 RESULT-VALUE                PIC X(30)             VALUE "N".
       PROCEDURE DIVISION.
           ACCEPT SOME-VALUE
           STRING SOME-VALUE DELIMITED SPACE 
                  SOME-VALUE DELIMITED SIZE 
                  INTO RESULT-VALUE
           DISPLAY "VALUE:"RESULT-VALUE.
           STOP RUN.
