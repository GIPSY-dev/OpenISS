#!/bin/sh -xe

# This script runs tests

# Version of CentOS/RHEL
el_version=$1

# Commands and paths
DOCKERPATH=/OpenISS

# Debug
DEBUG=1

if [ "$DEBUG" -eq "1" ]; then
	uname -a
	date
	pwd
	ls -al
fi

# Run tests
if [ "$el_version" -eq "6" ]; then

	cd $DOCKERPATH/src
 
	bash -n scripts/build.sh
	bash -n scripts/dependencies/el6.sh

	make deps6
	make all

elif [ "$el_version" -eq "7" ]; then

	yum -y install make

	cd $DOCKERPATH/src

	bash -n scripts/build.sh
	bash -n scripts/dependencies/el7.sh

	make deps7
	make all

fi

echo -ne "------\nEND OpenISS TESTS\n"

if [ "$DEBUG" -eq "1" ]; then
	pwd
	ls -al
	date
fi

# EOF
