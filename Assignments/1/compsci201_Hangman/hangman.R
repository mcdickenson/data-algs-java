# CS 201: Duke University
# Assignment 1: Hangman
# Matt Dickenson
# January, 2013

setwd('~/desktop/data-algs-java/assignments/1')
lengths <- c(4:20)
counts <- c(2208, 3798, 4931, 5505, 5377, 
	4898, 4054, 2972, 1869, 1137, 545, 278, 
	103, 57, 23, 3, 3)
data <- c()
for(i in 1:17){
	data <- c(data, rep(lengths[i], counts[i]))
}

pdf("plot1a.pdf")
hist(data, main="Histogram of Word Lengths (Sample)",
	xlab="Word Length")
dev.off()