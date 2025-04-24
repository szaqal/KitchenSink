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


> factor(letters)
 [1] a b c d e f g h i j k l m n o p q r s t u v w x y z
Levels: a b c d e f g h i j k l m n o p q r s t u v w x y z

factor(rep(letters, 2))
 [1] a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y
[52] z
Levels: a b c d e f g h i j k l m n o p q r s t u v w x y z


