# Compsci 201 Assignment 6
# Empirical analysis
# Matt Dickenson
# 4/1/2013

setwd('~/desktop/data-algs-java/assignments/6/compsci201_boggle/writeup')

# load data 
data <- read.csv('bogglestats.csv')
dim(data)

lf <- data[data$Player=="LexFirst",]
dim(lf)
head(lf)

pdf("lexfirst.pdf")
plot(lf$N[1:2], lf$Time4[1:2], type='l', lty=4,
	ylim=c(0,2100), main="LexiconFirst Runtimes",
	ylab="Runtime (Seconds)", xlab="Number of Iterations")
lines(lf$N[3:4], lf$Time4[3:4], type='l', lty=2)
lines(lf$N[5:6], lf$Time4[5:6], type='l', lty=3)
lines(lf$N[1:2], lf$Time5[1:2], type='l', lty=5)
lines(lf$N[3:4], lf$Time5[3:4], type='l', lty=6)
lines(lf$N[5:6], lf$Time5[5:6], type='l', lty=7)
legend('topleft', legend=c("Simple, 4x4", "Simple, 5x5", "Trie, 4x4", "Trie, 5x5", "Binary, 5x5", "Binary, 4x4"), lty=c(4,2,3,5,6,7))
dev.off()

bf <- data[data$Player=="BoardFirst",]
dim(bf)
head(bf)

pdf("boardfirst.pdf")
plot(bf$N[1:2], bf$Time4[1:2], type='l', lty=4, # simple
	ylim=c(0,50), main="BoardFirst Runtimes",
	ylab="Runtime (Seconds)", xlab="Number of Iterations")
lines(bf$N[3:4], bf$Time4[3:4], type='l', lty=2) # simple
lines(bf$N[5:6], bf$Time4[5:6], type='l', lty=3) # trie
lines(bf$N[1:2], bf$Time5[1:2], type='l', lty=5) # trie
lines(bf$N[3:4], bf$Time5[3:4], type='l', lty=6) # binary
lines(bf$N[5:6], bf$Time5[5:6], type='l', lty=7) # binary
legend('topleft', legend=c("Simple, 4x4", "Simple, 5x5", "Trie, 4x4", "Trie, 5x5", "Binary, 5x5", "Binary, 4x4"), lty=c(4,2,3,5,6,7))
dev.off()

