#!/usr/bin/perl

#--------------------------
mkdir ("/tmp/xxx",0777);
chdir("/tmp/xxx");
#--------------------------

opendir(TMP, "/tmp");
while($file = readdir(TMP)) {
	print $file . "\n";
}
closedir(TMP);

#-------------------------
