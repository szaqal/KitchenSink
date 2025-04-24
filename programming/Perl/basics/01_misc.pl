#!/usr/bin/perl -w
use warnings;


#-------------------------
$my = "YYY" eq "YYY";
$my1 = 77==77;
print $my."\n";
print $my1."\n";

#------SINGLE QUOTE VS DOUBLE -----------
print "$my" . '$my' . "\n";

#--- MULTI LINE ---
print 'dddd
sss
eee';

# In Perl, all scalar variables have an initial value of the null string, ""

#---- Comparation ----
my $xxx = 10<=>3;
print "Val : " . $xxx. "\n";

#---- String comparation ----
$result = "aaa" lt "bbb"; # result is true
$result = "aaa" gt "bbb"; # result is false
$result = "aaa" eq "bbb"; # result is false
$result = "aaa" le "aaa"; # result is true
$result = "aaa" ge "bbb"; # result is false
$result = "aaa" ne "aaa"; # result is false
$result = "aaa" cmp "bbb"; # result is -1

#---- String repetition ----
print "ab" x 3 . "\n";
