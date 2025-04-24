       IDENTIFICATION DIVISION.
       PROGRAM-ID. hello.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       77 SOME-VALUE                  PIC X             VALUE "N".
       77 SOME-VALUE-COPY             PIC X             VALUE "N".
       PROCEDURE DIVISION.
           ACCEPT SOME-VALUE
           MOVE SOME-VALUE TO SOME-VALUE-COPY
           DISPLAY "VALUE:"SOME-VALUE-COPY.
           STOP RUN.
