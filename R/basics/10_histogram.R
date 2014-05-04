#
# Shows how to create histogram
# with specified number of Bins in this case 10
#
#load dataset
z<-read.table(file="/Users/pmalczyk/Downloads/dataset_317_1.txt")
#create division vector
div = seq(min(z[,1]), max(z[,1]), by=(max(z[,1])-min(z[,1]))/10)
#create histogram
x<-hist(z[,1], breaks=div)

#RESULT

$breaks
 [1] 4.40 4.75 5.10 5.45 5.80 6.15 6.50 6.85 7.20 7.55 7.90

$counts
 [1] 10 20 14 27 18 25 16  7  3 10

$density
 [1] 0.19047619 0.38095238 0.26666667 0.51428571 0.34285714 0.47619048 0.30476190 0.13333333 0.05714286
[10] 0.19047619

$mids
 [1] 4.575 4.925 5.275 5.625 5.975 6.325 6.675 7.025 7.375 7.725

$xname
[1] "z[, 1]"

$equidist
[1] TRUE

attr(,"class")
[1] "histogram"
