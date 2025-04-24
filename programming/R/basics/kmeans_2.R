iris<- matrix(c(1,2,3,4,5,6,7,8,50,75,80,60,55,40,35,50,0,0,0,1,1,1,1,1), ncol=3) 
iris<- iris(,2:3)
z_iris <- scale(iris)
cMeans <- colMeans(z_iris)
z_iris[,1] <- z_iris[,1] - cMeans[1]
z_iris[,2] <- z_iris[,2] - cMeans[2]
z_iris[,3] <- z_iris[,3] - cMeans[3]
cRange <- apply(z_iris,2,max) - apply(z_iris,2,min)
r_iris <- z_iris
r_iris[,1] <- r_iris[,1] / cRange[1]
r_iris[,2] <- r_iris[,2] / cRange[2]
r_iris[,3] <- r_iris[,3] / cRange[3]
result<-kmeans(r_iris[,1:4], centers=r_iris[c(1,51,101),], iter.max=3)
round(result$centers,5);
