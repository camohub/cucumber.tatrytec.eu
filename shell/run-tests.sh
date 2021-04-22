#!/bin/bash

# This script need to get ${testCategory} variable from Jenkins
# Do not run clean cause it deletes failed.txt file
clean compile test surefire-report:report-only  -B -P${testCategory} -DBUILD_URL=${BUILD_URL}

exit 0