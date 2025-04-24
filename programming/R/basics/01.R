
> var.obj <- c(1,"ss");
> var.obj;
[1] "1"  "ss"
> mode(var.obj)
[1] "character"

> var.obj <- c(1,"ss",TRUE);
> mode(var.obj)
[1] "character"
> var.obj
[1] "1"    "ss"   "TRUE"

> class(var.obj[1])
[1] "character"
