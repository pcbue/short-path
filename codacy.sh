#!/bin/bash

export CODACY_PROJECT_TOKEN=e583bcfe2e9642b4afc8addd00ed1ae1
cd /tmp
git clone https://github.com/codacy/codacy-coverage-reporter
cd codacy-coverage-reporter
sbt assembly
java -cp /tmp/codacy-coverage-reporter/target/codacy-coverage-reporter-assembly-1.0.5.jar com.codacy.CodacyCoverageReporter -l Java -r jacoco.xml