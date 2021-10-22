        IDENTIFICATION DIVISION.
        Program-ID. Init.
      *  Author. Pawel.

        DATA DIVISION.
        WORKING-STORAGE SECTION.
        01 Height PIC 9.

        01 HeightCheck.
            05 BestMatch PIC 9 VALUE LOW-VALUES.
                88 CheckMatch VALUE 5.


        PROCEDURE DIVISION.
        MOVE 4 TO Height.

        EVALUATE Height
            WHEN 1 THROUGH 3
                DISPLAY "SMALL"
            WHEN 3 THROUGH 5
                DISPLAY "MID"
            WHEN OTHER
                DISPLAY "BIG"
        END-EVALUATE


        MOVE 5 TO BestMatch.
        IF CheckMatch THEN
            DISPLAY "HIT"

        STOP RUN.