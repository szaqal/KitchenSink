        IDENTIFICATION DIVISION.
        Program-ID. Init.
      *  Author. Pawel.

        DATA DIVISION.
        WORKING-STORAGE SECTION.
        01 Users.
            05 User OCCURS 2 TIMES.
                10 Name PIC X(5).


        01 Tbl.
            05 Row OCCURS 2 TIMES.
                10 Coll OCCURS 2 TIMES.
                    15 Item PIC X(1). 

        PROCEDURE DIVISION.
            MOVE 'Name1' TO Name(1).
            MOVE 'Name2' TO Name(2).
      *      Move 'Name3' TO Name(3).                                     Doesnt return error
            DISPLAY Users.

            DISPLAY "Item 1:"Name(1).
            DISPLAY "Item 2:"Name(2).

            MOVE 'A' TO Item(1,1).
            MOVE 'B' TO Item(2,2).

            DISPLAY Item(1,1).
            DISPLAY Item(2,2).
            DISPLAY Item(1,2).
            DISPLAY Item(2,1).


        STOP RUN. 