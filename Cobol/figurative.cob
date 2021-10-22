        IDENTIFICATION DIVISION.
        Program-ID. Init.
      *  Author. Pawel.

        DATA DIVISION.
        WORKING-STORAGE SECTION.
        01 Age      PIC 9(2) VALUE 'aa'.                                 ALLOWED BUT WARNING
        01 Height   PIC 9(2) VALUE ZEROS. 
        01 Name     PIC X(3) VALUES ZEROS.
        01 Valuation    PIC 9(3)V9(2).     
        01 Valuation2   PIC 99V99. 
        01 Valuation3   PIC S99V99.   

      * Numeric formats  (IBM see page 50)
      * External Decimal (DISPLAY)
      * Internal Decimal (PACKED-DECIMAL, COMP-3)   
      * Internal Floating Point (COMP-1, COMP-2)
      * Binary (COMP, COMP-4)
      * Native Binary (COMP-5)

        PROCEDURE DIVISION.
            DISPLAY AGE.
            DISPLAY Height.
            DISPLAY Name.

            MOVE HIGH-VALUES TO Age.
            DISPLAY AGE.

            MOVE HIGH-VALUES TO Height.
            DISPLAY Height.
()
            MOVE HIGH-VALUES TO Name.
            DISPLAY Name.

            MOVE HIGH-VALUES TO Age.
            DISPLAY AGE.

            MOVE HIGH-VALUES TO Height.
            DISPLAY Height.

            MOVE HIGH-VALUES TO Name.
            DISPLAY Name.


            MOVE ZEROS TO Valuation.
            DISPLAY Valuation.

            MOVE 10 TO Height.
            MOVE Height TO Valuation.                                    10 assigned as expected
            DISPLAY Valuation.


            MOVE Valuation TO Age.
            DISPLAY Age.

            MOVE 123.123 TO Valuation2.                                 23.12
            DISPLAY Valuation2.

            MOVE 123.123 TO Valuation3.                                 23.12
            DISPLAY Valuation3.
      *---------------------------------------------------------------- 

            MOVE 101.1 TO Valuation.
            MOVE Valuation TO Age..
            DISPLAY "101.1 to Age => "Age.                              01
        STOP RUN.