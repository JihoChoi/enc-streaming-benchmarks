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



###Expansion Contributors

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













<!--
 Copyright 2015, Yahoo Inc.
 Licensed under the terms of the Apache License 2.0. Please see LICENSE file in the project root for terms.
-->
# Yahoo Streaming Benchmarks

Code licensed under the Apache 2.0 license. See LICENSE file for terms.

### Background
At Yahoo we have adopted [Apache Storm](https://storm.apache.org) as our stream processing platform of choice.  But that was in 2012 and the landscape has changed significantly since then. Because of this we really want to know what Storm is good at, where it needs to be improved compared to other systems, and what its limitations are compared to other tools so we can recommend the best tool for the job to our customers.  To do this we started to look for stream processing benchmarks that we could use to do this evaluation, but all of them ended up lacking in several fundamental areas.  Primarily they did not test anything close to a read world use case, so we decided to write a simple one.  This is the first round of these tests.  The tool here is not polished and only covers three tools and one specific use case.  We hope to expand this in the future in terms of the tools tested, the variety of processing tested, and the metrics gathered.

### Setup
We provide a script stream-bench.sh to setup and run the tests on a single node, and to act as an example of what to do when running the tests on a multi-node system. Also, you need to have leiningen installed on your machines before you start the tests (e.g., on Mac OS, you can install by "brew install leiningen").

It takes a list of operations to perform, and options are passed into the script through environment variables. The most significant of these are

#### Operations
   * SETUP - download dependencies (Storm, Spark, Flink, Redis, and Kafka) cleans out any temp files and compiles everything
   * STORM_TEST - Run the test using Storm on a single node
   * SPARK_TEST - Run the test using Spark on a single node
   * FLINK_TEST - Run the test using Flink on a single node
   * STOP_ALL - If something goes wrong stop all processes that were launched for the test.

#### Environment Variables
   * STORM_VERSION - the version of Storm to compile and run against (default 0.10.0)
   * SPARK_VERSION - the version of Spark to compile and run against (default 1.5.1)
   * FLINK_VERSION - the version of Flink to compile and run against (default 0.10.1)
   * LOAD - the number of messages per second to send to be processed (default 1000)
   * TEST_TIME - the number of seconds to run the test for (default 240)
   * LEIN - the location of the lein executable (default lein)

### The Test
The initial test is a simple advertising use case.

Ad events arrive through kafka in a JSON format.  They are parsed to a more usable format, filtered for the ad view events that this processing cares about, the unneeded fields are removed, and then new fields are added by joining the event with campaign data stored in Redis.  Finally the ad views are aggregated by campaign and by time window and stored back into redis, along with a timestamp to indicate when they are updated.


### Results
The current set of results that we care about are comparing the latency that a particular processing system can produce at a given input load.
The result of running a test creates a few files data/seen.txt and data/updated.txt  data/seen.txt contains the counts of events for different campaigns and time windows.  data/updated.txt is the latency in ms from when the last event was emitted to kafka for that particular campaign window and when it was written into Redis.

### References
Sanket Chintapalli, Derek Dagit, Bobby Evans, Reza Farivar, Thomas Graves, Mark Holderbaugh, Zhuo Liu, Kyle Nusbaum, Kishorkumar Patil, Boyang Jerry Peng, Paul Poulosky.
"Benchmarking Streaming Computation Engines: Storm, Flink and Spark Streaming. "
First Annual Workshop on Emerging Parallel and Distributed Runtime Systems and Middleware. IEEE, 2016.
