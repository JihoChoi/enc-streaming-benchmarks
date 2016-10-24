# enc-streaming-benchmarks

Expansion of existing Yahoo Streaming Benchmarks to test encrypted streaming data.


To test the benchmark:

	enc-streaming-benchmarks directory should be under same directory as phestorm directory

	
Important files

	./streaming-bench.sh
		added feature 
			sh streaming-bench ENCRYPT_TEST
			sh streaming-bench START_ENCRYPT_LOAD		
	
	./data/src/setup/core.clj
		creating json messgage tuples to send to kafka
		connecting benchmark with encryption classes


TODO LIST

	-
	-
	-
	-


Expansion Contributer

	Julian James Stephen
		Email	:
		Web 	: 	https://www.cs.purdue.edu/homes/stephe22/

	Jiho Choi
		Email	:	jihochoi1993@gmail.com
		Web		:	http://web.ics.purdue.edu/~choi296/




References
	Benchmarking Streaming Computation Engines at Yahoo!
		https://yahooeng.tumblr.com/post/135321837876/benchmarking-streaming-computation-engines-at

	yahoo-streaming-benchmarks
		https://github.com/yahoo/streaming-benchmarks
	
	Sanket Chintapalli, Derek Dagit, Bobby Evans, Reza Farivar, Thomas Graves, Mark Holderbaugh, Zhuo Liu, Kyle Nusbaum, Kishorkumar Patil, Boyang Jerry Peng, Paul Poulosky. "Benchmarking Streaming Computation Engines: Storm, Flink and Spark Streaming. " First Annual Workshop on Emerging Parallel and Distributed Runtime Systems and Middleware. IEEE, 2016.







