X<-read.table(file="/Users/pmalczyk/Downloads/data.txt")
svdx<-svd(X[,1:4])
c<- -1*svdx$v[,1]
data<-data.matrix(X[,1:4])
z<-data %*% c
max<-max(z)
min<-min(z)
newz<-(z-min)*100/(max-min)
round(newz[5,1],4) 
round(newz[10,1],4)
round(newz[15,1],4)
