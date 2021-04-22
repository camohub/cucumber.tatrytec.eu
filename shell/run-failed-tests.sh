#!/bin/bash

# Do not run clean cause it deletes failed.txt file
mvn compile test surefire-report:report-only  -B -PfailedTestCategory

exit 0