#!/bin/bash

# This script need to get ${testCategory} variable from Jenkins

mvn clean compile test surefire-report:report-only  -B -P${testCategory} -DBUILD_URL=${BUILD_URL} -Dbrowser=${browser}

echo whoami

echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO]  All tests are done"
echo "[INFO] ------------------------------------------------------------------------"

exit 0