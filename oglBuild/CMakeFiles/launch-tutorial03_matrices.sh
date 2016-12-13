#!/bin/sh
bindir=$(pwd)
cd /root/final/OpenISS/ogl/tutorial03_matrices/
export 

if test "x$1" = "x--debugger"; then
	shift
	if test "xYES" = "xYES"; then
		echo "r  " > $bindir/gdbscript
		echo "bt" >> $bindir/gdbscript
		/usr/bin/gdb -batch -command=$bindir/gdbscript --return-child-result /root/final/OpenISS/oglBuild/tutorial03_matrices 
	else
		"/root/final/OpenISS/oglBuild/tutorial03_matrices"  
	fi
else
	"/root/final/OpenISS/oglBuild/tutorial03_matrices"  
fi
