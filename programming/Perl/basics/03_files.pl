#!/usr/bin/perl

unless(open(FILE, ">/tmp/file")) {
	die("Unable to open file");
}
print FILE "xxx";
close(FILE);

unless(open(READ, "/tmp/file")) {
	die("Unable to open file");
}
print <READ>;
close(READ);

print "\n";
#------
if(-e "/tmp/file") {
	print "file exists";
} 

print "\n";
