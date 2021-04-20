       IDENTIFICATION DIVISION.
       PROGRAM-ID. testing.
       
       DATA DIVISION.
       WORKING-STORAGE SECTION.
      * X - ALPHANUMERIC
       77 SOME-VALUE-1                PIC X             VALUE "AAA".
       77 SOME-VALUE-2                PIC XX             VALUE "AAA".
       77 SOME-VALUE-3                PIC X(2)             VALUE "AAA".
      * 9 - Numeric
       77 SOME-VALUE-4                PIC 9(3)             VALUE 1000.
       77 SOME-VALUE-5                PIC 9(4)             VALUE 1000.
       77 SOME-VALUE-6                PIC +Z,ZZZ,ZZ9.99    VALUE 100000.
       77 SOME-VALUE-7                PIC Z,ZZZ,ZZ9.99    VALUE 100000.
       PROCEDURE DIVISION.          
           DISPLAY "SOME-VALUE-1:   "  SOME-VALUE-1.
           DISPLAY "SOME-VALUE-2:   "  SOME-VALUE-2.
           DISPLAY "SOME-VALUE-3:   "  SOME-VALUE-3.
           DISPLAY "SOME-VALUE-4:   "  SOME-VALUE-4.
           DISPLAY "SOME-VALUE-5:   "  SOME-VALUE-5.
           DISPLAY "SOME-VALUE-6:   "  SOME-VALUE-6.
           DISPLAY "SOME-VALUE-7:   "  SOME-VALUE-7.
           STOP RUN.