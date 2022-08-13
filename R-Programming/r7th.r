x<-c(100,102,104,107,105,112,103,99)

y<-c(15,12,13,11,12,12,19,26)
sum_x<- sum(x)
sum_y<-sum(y)
sum_xsq<-sum(x^2)
sum_ysq<-sum(y^2)
sum_ofXY<- sum(x*y)
n<-length(x)

corr_coeff = (n*sum_ofXY-(sum_x*sum_y))/sqrt((n*sum_xsq-(sum_x^2))*(n*sum_ysq-(sum_y^2)))

plot(x,y)
  
