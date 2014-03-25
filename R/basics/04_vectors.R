> vector <- seq(from=1,to=10,by=1);
> vector
 [1]  1  2  3  4  5  6  7  8  9 10
> vector[3];
[1] 3
> vector[3:6];
[1] 3 4 5 6



> vector <- c(x=1,y=2,z=60);
> vector
 x  y  z 
 1  2 60 
> labels(vector)
[1] "x" "y" "z"
> levels(factor(vector))
[1] "1"  "2"  "60"


> fac <- factor(vector)
> fac
 x  y  z 
 1  2 60 
Levels: 1 2 60


#EMPTY ELEMENTS

> x<-c(1,2,NA,3);
> x
[1]  1  2 NA  3
> ex <- complete.cases(x)
> ex
[1]  TRUE  TRUE FALSE  TRUE
> x[ex]
[1] 1 2 3

#OPERATIONS
> x<-seq(1:20);
> y<-seq(1:20);
> x+y
 [1]  2  4  6  8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40
> x*y
 [1]   1   4   9  16  25  36  49  64  81 100 121 144 169 196 225 256 289 324 361 400


