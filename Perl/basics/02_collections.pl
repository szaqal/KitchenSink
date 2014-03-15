#!/usr/bin/perl -w 
use warnings;

my @arr = (2,3,4);
print $arr[2]."\n";

my @aaa = (2.1..5.3);
print @aaa;
print "\n";

my @aab = ("aa".."ac");
print @aab;
print "\n";

my @aac = (1,1,@arr);
print @aac;
print "\n";

@array = (5, 7, 8, 9);
($var1, $var2) = @array;
print "$var1 $var2\n";

$arraysize = @array;
print "SIZE $arraysize\n";

@slice = @array[1,3];
print @slice;
print "\n";
print "SLICE " . @slice . "\n"; #does not print what I was expecting


@array[1,3] = (10,10);
print @array;
print "\n";

@array[1..2] = (4,4);
print @array;
print "\n";

@arraysorted = sort(@array);
print @arraysorted;
print "\n";

@arrayreversed = reverse(@arraysorted);
print @arrayreversed;
print "\n";

$joined=join(",",@arrayreversed);
print "JOINED $joined \n";

@splitted = split(/,/,$joined);
print @splitted;
print "\n";
