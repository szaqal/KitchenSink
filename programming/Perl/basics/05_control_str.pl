#!/usr/bin/perl

@xxx = (1,2,3,4);

foreach $item (@xxx) {
	print $item;
}

foreach (@xxx) {
	print $_;
}

print "\n";
