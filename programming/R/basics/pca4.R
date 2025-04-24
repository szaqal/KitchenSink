varNames <- read.table("/Users/pmalczyk/Downloads/studn.var")
varNames <- t(varNames)
dados = read.table("/Users/pmalczyk/Downloads/studn.dat", header = F, col.names=varNames)
df <- cbind(dados$Age, dados$SoftEngineering , dados$OOProgramming , dados$CompIntelligence  )
Y <- df 
ma <- apply(Y, 2, max)
mi <- apply(Y, 2, min)
svd.Yr <- svd(Y)
mu <- diag(svd.Yr$d);
c1 <- svd.Yr$v[,1]
v1 <- c1*sqrt(svd.Yr$d[1]);v1
c2 <- -svd.Yr$v[,2]
v2 <- c2*sqrt(svd.Yr$d[2]); v2
p <- 100*(mu[1,1]^2 + mu[2,2]^2)/sum(Yr[,1:4]*Yr[,1:4]); p
