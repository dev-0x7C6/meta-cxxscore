#!/bin/bash

echo -n  "Setting cpu governor to performance... "
cpufreq-set -g performance &> /dev/null && echo ok || echo failed

for executable in `find /usr/bin/ -iname 'cxxscore-gcc*' | sort`; do
	$executable "$@"
done

for executable in `find /usr/bin/ -iname 'cxxscore-clang*' | sort`; do
	$executable "$@"
done

