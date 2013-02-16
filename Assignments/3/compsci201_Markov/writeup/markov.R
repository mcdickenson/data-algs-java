# CS 201: Duke University
# Assignment 3: Markov
# Matt Dickenson
# February 16, 2013

setwd('~/desktop/data-algs-java/assignments/3/compsci201_Markov/writeup')

keys <- c(26222, 871, 7049, 1340, 800, 85590, 14316, 1073, 2323, 25740)
hash <- c(8, 13, 4, 10, 2, 27, 21, 3, 12, 3)
tree <- c(9, 3, 5, 2, 1, 5, 2, 1, 1, 3)

hashSmooth = smooth.spline(keys, hash, spar=.95)
treeSmooth = smooth.spline(keys, tree, spar=.95)

pdf("plotB.pdf")

plot(keys, hash, 
	pch=16, ylim=c(-1,29),
	xlab="Key Count",
	ylab="Time (milliseconds)",
	main="HashMap vs. TreeMap")
points(keys, tree, pch=16, col='blue')
lines(hashSmooth)
lines(treeSmooth, col='blue')
legend("topleft", legend=c("Hash", "Tree"),
		col=c('black','blue'), pch=16)

dev.off()