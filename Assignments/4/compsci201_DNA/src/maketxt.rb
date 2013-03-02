# convert .dat file to .txt 

# writename = '../data/ecoli_small_clean.txt'
writename = '../data/ecoli_clean.txt'
write = File.open(writename, 'w')

# filename = '../data/ecoli_small.txt'
filename = '../data/ecoli.txt'

File.open(filename, 'r') do |f1|
	while line = f1.gets
		clean = line.gsub(/\ \d+/, '').gsub("\n", '').gsub("\t", '')
		write.puts clean.squeeze(' ')
	end 
end 