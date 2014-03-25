> for(i in 1:3) { print(i)}
[1] 1
[1] 2
[1] 3


> for(i in x) {print(i)};
[1] 1
[1] 2
[1] 3
[1] 4

> f<-function(x){print(x)};
> f("ddd")
[1] "ddd"

DEFAULT VALUES
> f<-function(x=12){print(x)};
> f()
[1] 12
> f("sss")
[1] "sss"

> formals(f)
$x
[1] 12
