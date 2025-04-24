       IDENTIFICATION DIVISION.
       PROGRAM-ID. hello.
      *PROGRAMMER. Somebody
       DATA DIVISION.
       WORKING-STORAGE SECTION.
       01 I PIC 99 COMP-5.
       PROCEDURE DIVISION.
           PERFORM VARYING I FROM 1 BY 1 UNTIL I > 10
             DISPLAY 'a'
           END-PERFORM.
           DISPLAY I.
           STOP RUN.
