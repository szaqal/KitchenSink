z<-read.table(file="/Users/pmalczyk/Dev/my/KitchenSink/R/basics/bezdekIris.data")
div<-c(0, 0.5, 1.5, 2,10) //div
for(i in 1:(length(div)-1)) {  tmp <-z[ z[,4]>=div[i] & z[,4]<div[i+1], ]; print(summary(tmp)) }
