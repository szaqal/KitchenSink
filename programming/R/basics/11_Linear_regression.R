#Linear regression sample

z<-read.table(file="/Users/pmalczyk/Downloads/dataset_389_1 (23).txt")
x<-z[,4]
y<-z[,3]
a= cor(x,y)*(sd(y)/sd(x))
b = mean(y) - (sd(y)/sd(x))*mean(x) <-invalid value with regards to summary(nn -> intercept) revisit
nn<-lm(z[,3:4])
round(a,6)
round(b,6)
round(summary(nn)$r.squared, 6)
