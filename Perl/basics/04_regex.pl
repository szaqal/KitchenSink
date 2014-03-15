#!/usr/bin/perl

$found = "xxx" =~ /x/;
$found2 = "xxx" !~ /s/;
$found3 = "xxx" !~/X/;
$found4 = "xxx" =~/X/i;
print "$found $found2 $found3 $found4\n";

@results = "xxx" =~/x/g;
print @results;
print "\n";

$string = "xxx";
$string =~ s/x/y/;
print $string . "\n";

$string = "xxx";
$string =~ s/x/y/g;
print $string . "\n";

$string = "xxxyyyzzz";
$string =~ tr/xyz/abc/;
print $string . "\n";
