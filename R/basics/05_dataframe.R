DATA FRAMES

> col1 <- c("a","b","c","d");
> col2 <- c(1,2,3,4);
> col3 <- c(TRUE,TRUE,FALSE,TRUE);
> frame <- data.frame(col1,col2,col3);
> frame
  col1 col2  col3
1    a    1  TRUE
2    b    2  TRUE
3    c    3 FALSE
4    d    4  TRUE

> class(col2);
[1] "numeric"
> class(col3);
[1] "logical"

> frame$col1
[1] a b c d
Levels: a b c d
> frame$col2
[1] 1 2 3 4
> frame$col3
[1]  TRUE  TRUE FALSE  TRUE
