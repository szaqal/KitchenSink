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
