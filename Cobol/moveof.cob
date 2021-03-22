       IDENTIFICATION DIVISION.
       PROGRAM-ID. hello.
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       01 ACCT-REC-KEY.
           05 SSN       PIC X             VALUE "N".
       77 SOME-VALUE                  PIC X             VALUE "N".
       PROCEDURE DIVISION.
           ACCEPT SOME-VALUE
           MOVE SOME-VALUE TO SSN OF ACCT-REC-KEY
           DISPLAY "VALUE:"SSN OF ACCT-REC-KEY
           STOP RUN.
