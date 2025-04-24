#!/usr/bin/perl -w

use strict;

&printmessage;

sub printmessage { 
	print "Hello\n";
}

#------------------------------------------

sub returnvalue {
 	my $val = 10;
}

print &returnvalue;
print "\n";

#------------------------------------------

sub inputparams {
	my @arr=@_;
	print "$arr[0] $arr[1]\n";
}

&inputparams("ss","xx");

#------------------------------------------

my @inputarr = ("aa","bb");

sub change {
	my @arr = @_;
	$arr[0]="xx";
	print @arr;
	print "\n";
}
&change(@inputarr);
print @inputarr;
print "\n";


#------------------------------------------

