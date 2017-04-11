#!/bin/bash

LOG_FILE="cxxscore.log"

echo -n  "Setting cpu governor to performance... "
cpufreq-set -g performance &> /dev/null && echo ok || echo skipped

rm -f "${LOG_FILE}"

for executable in `find /usr/bin/ -iname 'cxxscore-gcc*' -o -iname 'cxxscore-clang*' | sort`; do
	ls -la "${executable}" | tee -a "${LOG_FILE}"
	time "${executable}" "$@" | tee -a "${LOG_FILE}"
done
