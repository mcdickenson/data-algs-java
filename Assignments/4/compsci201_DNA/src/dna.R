# Compsci 201, Spring 2013, Duke University
# Assignment 4: DNA
# Matt Dickenson

# load data
pathData = '~/desktop/data-algs-java/Assignments/4/compsci201_DNA/data'
pathWriteup = '~/desktop/data-algs-java/Assignments/4/compsci201_DNA/writeup'
setwd(pathData)

default = read.csv('runtimes.csv')
m512 = read.csv('runtimes512.csv')
m1024 = read.csv('runtimes1024.csv')
link = read.csv('linktimes.csv')
dim(default)
dim(m512)
dim(m1024)
dim(link)

default
m512
m1024
head(link)

# explore
head(default)
names(default)
plot(default$splicee, default$time1)

default$best <- apply(default[,6:8], 1, min)
default$worst <- apply(default[,6:8], 1, max)
default$avg <- apply(default[,6:8], 1, mean)

plot(default$recomb, default$avg, type='o',
	xaxt='n', xlab="    N", ylab="Time (secs)")
axis(side=1, las=2, at=default$recomb, labels=as.character(default$recomb))

# function to plot runtimes vs input
plottimes <- function(data, mainlab){
	data$best <- apply(data[,6:8], 1, min)
	data$worst <- apply(data[,6:8], 1, max)
	data$avg <- apply(data[,6:8], 1, mean)
	plot(data$recomb, data$avg, type='o',
		ylim=c(min(data$best)*0.9,max(data$worst*1.1)), 
		xaxt='n', 
		xlab="", ylab="Time (secs)",
		main=mainlab)
	axis(side=1, las=2, at=data$recomb, labels=as.character(data$recomb))
	lines(data$recomb, data$best, type='o', pch=5, lty=2)
	lines(data$recomb, data$worst, type='o', pch=0, lty=2)
	legend('bottomright', legend=c('average', 'best', 'worst'), pch=c(1,5,0))
}

setwd(pathWriteup)

# plottimes(default, "SimpleStrand Runtime as\nFunction of Recombinations - Default Mem")

# A 
pdf('default.pdf')
	plottimes(default, "SimpleStrand Runtime as\nFunction of Recombinations - Default Mem")
dev.off()

# plot(default$splicee, default$avg)
m1 <- lm(avg ~ recomb, data=default)
summary(m1)

# B 
pdf('m512.pdf')
	plottimes(m512, "SimpleStrand Runtime as\nFunction of Recombinations - 512 Mem")
dev.off()

pdf('m1024.pdf')
	plottimes(m1024, "SimpleStrand Runtime as\nFunction of Recombinations - 1024 Mem")
dev.off()

plot(data$recomb, data$avg, type='o',
		ylim=c(min(data$best)*0.9,max(data$worst*1.1)), 
		xaxt='n', 
		xlab="", ylab="Time (secs)",
		main=mainlab)
	axis(side=1, las=2, at=data$recomb, labels=as.character(data$recomb))
	lines(data$recomb, data$best, type='o', pch=5, lty=2)
	lines(data$recomb, data$worst, type='o', pch=0, lty=2)
	legend('bottomright', legend=c('average', 'best', 'worst'), pch=c(1,5,0))

# D 
plot(link$numbreaks, link$time)
sub <- link[which(link$splicee==8192),]
dim(sub)
head(sub)

pdf('linkN.pdf')
	plot(link$recomb, link$time, 
		xlab="N", ylab="Time (secs)", 
		main="Runtime With Linked List Implementation")
dev.off()

pdf('linkB.pdf')
	plot(link$numbreaks, link$time, 
			xlab="B", ylab="Time (secs)", 
			main="Runtime With Linked List Implementation")
dev.off()

pdf('linkB2.pdf')
	plot(sub$numbreaks, sub$time, type='o',
		xlab="B", ylab="Time (secs)", 
		main="Runtime With Linked List Implementation")
dev.off()