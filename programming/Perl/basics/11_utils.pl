#!/usr/bin/perl -w

use strict;

#--------------------------------------
my @arr = ("ab","ac","ad","ae","cc");
my @found = grep(/cc/,@arr);
print @found;
print "\n";
#--------------------------------------
splice (@arr, 1,2,("xx", "yy"));
print @arr;
print "\n";
#--------------------------------------
splice (@arr, 1,2, "OO");
print @arr;
print "\n";

#-------------------------------------
my @arr2=("a","b","c");
shift(@arr2);
print @arr2;
print "\n";
unshift(@arr2,"O");
print @arr2;
print "\n";
#-------------------------------------
push (@arr2,"LL");
print @arr2;
print "\n";
#-------------------------------------
pop(@arr2);
print @arr2;
print "\n";
#------------------------------------
my @arr3 = map($_."Y",@arr2);
print @arr2;
print @arr3;
print "\n";
#------------------------------------
my %array = ("foo", 26, "bar", 17);
my @list = keys(%array);
my @list2 = values(%array);
print @list;
print "\n";
print @list2;
print "\n";
#-----------------------------------

print "\n";
