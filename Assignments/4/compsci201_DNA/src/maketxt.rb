# convert .dat file to .txt 

# read = 
write = File.open('../data/ecoli_small_clean.txt', 'w')

File.open('../data/ecoli_small.txt', 'r') do |f1|
	while line = f1.gets
		clean = line.gsub(/\ \d+/, '').gsub("\n", '').gsub("\t", '')
		write.puts clean.squeeze(' ')
	end 
end 