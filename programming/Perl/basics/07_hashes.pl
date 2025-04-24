#!/usr/bin/perl

%hash = ("a",1,"b",2);
print %hash;
print "\n";
print $hash{"a"};
print "\n";
#-------------------------

@arr = ("a",1,"b",2);
%newhash = @arr;
print $hash{"b"};
print "\n";

#------------------------
%hash = ("a",1,"b",2);
@keys = keys(%hash);
print @keys;
print "\n";

#-----------------------
