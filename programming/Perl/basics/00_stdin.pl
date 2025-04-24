#!/usr/bin/perl -w
use warnings;

my $input=<STDIN>;

print "ECHO : $input";

$input=<STDIN>;
chop($input);
print "ECHO :  $input";
