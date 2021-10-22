        IDENTIFICATION DIVISION.
        Program-ID. Init.
      *  Author. Pawel.

        DATA DIVISION.
        WORKING-STORAGE SECTION.
        01  Val1 PIC S9999 DISPLAY VALUE -9999.
        01  Val5 PIC S9999 COMP-5.
        01  Val4 PIC S9999 COMP-4.
        01  Val3 PIC S9999 COMP-3.


      * Numeric formats  (IBM see page 50)
      * External Decimal (DISPLAY)
      * Internal Decimal (PACKED-DECIMAL, COMP-3)   
      * Internal Floating Point (COMP-1, COMP-2)
      * Binary (COMP, COMP-4)
      * Native Binary (COMP-5)
      *When a USAGE COMP-1 data item is moved to a fixed-point data item that has more
      *than nine digits, the fixed-point data item will receive only nine significant digits,
      *and the remaining digits will be zero.

        PROCEDURE DIVISION.
            MOVE Val1 TO Val5.
            MOVE Val1 TO Val4.
            MOVE Val1 TO Val3.

            DISPLAY Val1.
            DISPLAY "COMP3=>"Val3.
            DISPLAY "COMP4=>"Val4.
            DISPLAY "COMP5=>"Val5.


        STOP RUN.       