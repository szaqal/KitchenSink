#!/usr/bin/perl -w

use strict;
use MIME::Lite;


open (CSV, ">/tmp/file.csv");

my $i=0;
my $senderaddress='';
my $recipientaddress='';
my $smtpserver='l';
my $smtpuser='';
my $smtppass='';
my $smtpport=587;

for($i=0;$i<100;$i++) {
	print CSV "\"".join("\",\"",$i, $i*2, $i*4)."\"\n";
}


close (CSV);
print "File created";

my $msg = MIME::Lite->new(
    	From	=> $senderaddress,
        To      => $recipientaddress,
        Subject => 'FILE ATTACHEMENT',
        Type    => 'multipart/mixed'
);

$msg->attach(
       Type     => 'text/csv',
       Path     => '/tmp/file.csv',
       Filename =>  'file.csv',
       Disposition => 'attachment'
);

$msg->send('smtp', $smtpserver, Port=>$smtpport,AuthUser=>$smtpuser, AuthPass=>$smtppass,Debug=>1 );  
