# Encrypted Streaming Benchmarks
<!--
# enc-streaming-benchmarks
-->

<!--
Atom
	1. cmd + shift + p
	2. Markdown Preview
-->

Expansion of existing *Yahoo Streaming Benchmarks* to test encrypted streaming data.



###To test the benchmark:

**enc-streaming-benchmarks** directory should be under the same directory as **phestorm** directory


###Important files

	./streaming-bench.sh
		added feature
			sh streaming-bench ENCRYPT_TEST
			sh streaming-bench START_ENCRYPT_LOAD		

	./data/src/setup/core.clj
		creating json messgage tuples to send to kafka
		connecting benchmark with encryption classes



###Expansion Contributor

Contributor          | Info
-------------------- | -------------
Julian James Stephen | [email]
										 | https://www.cs.purdue.edu/homes/stephe22/
Jiho Choi            | jihochoi1993@gmail.com
					 					 | http://web.ics.purdue.edu/~choi296/

<!--
	Julian James Stephen
		Email	:
		Web 	: 	https://www.cs.purdue.edu/homes/stephe22/

	Jiho Choi
		Email	:	jihochoi1993@gmail.com
		Web		:	http://web.ics.purdue.edu/~choi296/
-->



###TODO LIST

	1.
	2.
	3.
	4.
	5.





###References

[Post : Benchmarking Streaming Computation Engines at Yahoo!](https://yahooeng.tumblr.com/post/135321837876/benchmarking-streaming-computation-engines-at)

[GitHub : yahoo-streaming-benchmarks](https://github.com/yahoo/streaming-benchmarks)

Sanket Chintapalli, Derek Dagit, Bobby Evans, Reza Farivar, Thomas Graves, Mark Holderbaugh, Zhuo Liu, Kyle Nusbaum, Kishorkumar Patil, Boyang Jerry Peng, Paul Poulosky. "Benchmarking Streaming Computation Engines: Storm, Flink and Spark Streaming. " First Annual Workshop on Emerging Parallel and Distributed Runtime Systems and Middleware. IEEE, 2016.
