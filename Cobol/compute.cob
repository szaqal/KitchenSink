       IDENTIFICATION DIVISION.
       PROGRAM-ID. hello.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       77 SOME-VALUE    PIC S99.
       PROCEDURE DIVISION.
           COMPUTE SOME-VALUE = 2*5.
           DISPLAY "VALUE:"SOME-VALUE.
           STOP RUN.
